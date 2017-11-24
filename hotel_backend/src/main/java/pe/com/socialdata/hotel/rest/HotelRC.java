package pe.com.socialdata.hotel.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;


import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.HotelModelList;
import pe.com.socialdata.hotel.service.HotelService;
import pe.com.socialdata.hotel.util.CustomErrorType;

@RestController
@RequestMapping("/v1")
public class HotelRC {
	
	private static Logger log = Logger.getLogger(HotelRC.class);
	
	@Autowired
	HotelService  hotelService;
	
	
	//GET
			@RequestMapping(value="/hoteles", method = RequestMethod.GET, headers = "Accept=application/json")
			public ResponseEntity<List<HotelModelList>> getHoteles(){
				
				List<HotelModelList> hoteles = new ArrayList<HotelModelList>();
				
				
					hoteles = hotelService.listAllHotel();
					if (hoteles.isEmpty()) {
						return new ResponseEntity(HttpStatus.NO_CONTENT);
					}
					log.debug(" lista de hoteles  "+ hoteles.size() );
					return new ResponseEntity<List<HotelModelList>>(hoteles, HttpStatus.OK);
				
				
				
			}
			//GET
			@RequestMapping(value="/hoteles/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
			public ResponseEntity<HotelModel> getHotelById(@PathVariable("id") Long idHotel){
				if (idHotel == null || idHotel <= 0) {
					return new ResponseEntity(new CustomErrorType("idHotel es requerido"), HttpStatus.CONFLICT);
				}
				
				HotelModel hotel = hotelService.findHotelModelById(idHotel);
				if (hotel == null) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
				
				return new ResponseEntity<HotelModel>(hotel, HttpStatus.OK);
			}

}
