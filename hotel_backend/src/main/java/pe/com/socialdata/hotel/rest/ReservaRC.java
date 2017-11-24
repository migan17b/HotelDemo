package pe.com.socialdata.hotel.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.socialdata.hotel.model.ReservaModel;

import pe.com.socialdata.hotel.service.ReservaService;
import pe.com.socialdata.hotel.util.CustomErrorType;




@RestController
@RequestMapping("/v1")
public class ReservaRC {
	
	private static Logger log = Logger.getLogger(ReservaRC.class);
	
	
	
	@Autowired
	ReservaService	reservaService;
	
	//GET
		@RequestMapping(value="/reservas", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List<ReservaModel>> getReservas(@RequestParam(value="fdesde", required=false) String fdesde ,
				@RequestParam(value="fhasta", required=false) String fhasta){
			
			List<ReservaModel> reservas = new ArrayList<ReservaModel>();
			
			
				reservas = reservaService.searchReservaByFechaReserva(new Date(), new Date());
				if (reservas.isEmpty()) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
				}
				
				return new ResponseEntity<List<ReservaModel>>(reservas, HttpStatus.OK);
			
			
			
		}

		//GET
		@RequestMapping(value="/reservas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<ReservaModel> getReservaById(@PathVariable("id") Long idReserva){
			if (idReserva == null || idReserva <= 0) {
				return new ResponseEntity(new CustomErrorType("idReserva es requerido"), HttpStatus.CONFLICT);
			}
			
			ReservaModel Reserva = reservaService.findReservaModelById(idReserva);
			if (Reserva == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<ReservaModel>(Reserva, HttpStatus.OK);
		}
		
		
		//POST
		@RequestMapping(value="/reservas", method = RequestMethod.POST, headers = "Accept=application/json")
		public ResponseEntity<?> createReserva(@RequestBody ReservaModel ReservaModel, UriComponentsBuilder uriComponentsBuilder){
			log.debug("createReserva " + ReservaModel +"=======================================" );
			
			ReservaModel =reservaService.registrarReserva(ReservaModel);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(
					uriComponentsBuilder.path("/v1/reservas/{id}")
					.buildAndExpand(ReservaModel.getId())
					.toUri()
					);
			
			return new ResponseEntity<ReservaModel>(ReservaModel,headers, HttpStatus.CREATED);
		}
		
		//PUT
		@RequestMapping(value="/reservas", method = RequestMethod.PUT, headers = "Accept=application/json")
		public ResponseEntity<ReservaModel> updateReserva(@RequestBody ReservaModel ReservaModel){
			log.debug("updateReserva " + ReservaModel +"=======================================");
			if (ReservaModel.getId() == null || ReservaModel.getId() <= 0) {
				return new ResponseEntity(new CustomErrorType("idReserva es requerido"), HttpStatus.CONFLICT);
			}
			
			if (ReservaModel.getRowVersion() == null ) {
				return new ResponseEntity(new CustomErrorType("rowVersion es requerido"), HttpStatus.CONFLICT);
			}
			
			ReservaModel currentReserva = reservaService.findReservaModelById (ReservaModel.getId());
			if (currentReserva == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
	
			ReservaModel=reservaService.actualizarReserva(ReservaModel);
			return new ResponseEntity<ReservaModel>(ReservaModel, HttpStatus.OK);
		}
		
		//DELETE
		@RequestMapping(value="/reservas/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteReserva(@PathVariable("id") Long idReserva){
			log.debug("deleteReserva " + idReserva +"=======================================");
			if (idReserva == null || idReserva <= 0) {
				return new ResponseEntity(new CustomErrorType("idReserva es requerido"), HttpStatus.CONFLICT);
			}
			
			ReservaModel ReservaModel = reservaService.findReservaModelById(idReserva);
			if (ReservaModel == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			
			reservaService.anulaReserva(idReserva);
			return new ResponseEntity<ReservaModel>(HttpStatus.OK);
					
		}


}
