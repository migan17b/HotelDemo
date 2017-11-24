package pe.com.socialdata.hotel.rest;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import pe.com.socialdata.hotel.model.PerfilModel;


import pe.com.socialdata.hotel.service.PerfilService;

@RestController
@RequestMapping("/v1")
public class PerfilRC {
	
	
	private static Logger log = Logger.getLogger(PerfilRC.class);
	
	@Autowired
	PerfilService perfilService;
	
	@RequestMapping(value="/perfiles/{rol}" , method = RequestMethod.GET,  headers = "Accept=application/json" ,produces = "application/json")
	public ResponseEntity<List<PerfilModel>> findPerfilByRol( @PathVariable("rol") String rol){
		List<PerfilModel> perfiles = 		perfilService.findPerfilByRol(rol );
		
		if (perfiles !=null){
			
			log.debug("findbyuser - fin===========================================");
			return new ResponseEntity<List<PerfilModel>>(perfiles, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<PerfilModel>>(perfiles, HttpStatus.NOT_FOUND);
		}
		
	}
	@RequestMapping(value="/perfiles/{rol}/module/{idModule}" , method = RequestMethod.GET,  headers = "Accept=application/json" ,produces = "application/json")
	public ResponseEntity<List<PerfilModel>> findPerfilByRolandModule( @PathVariable("rol") String rol , @PathVariable("idModule") Long idModule ){
		List<PerfilModel> perfiles = 		perfilService.findPerfilByRolandModule(rol, idModule);
		
		if (perfiles !=null){
			
			log.debug("findbyuser - fin===========================================");
			return new ResponseEntity<List<PerfilModel>>(perfiles, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<PerfilModel>>(perfiles, HttpStatus.NOT_FOUND);
		}
		
	}

}
