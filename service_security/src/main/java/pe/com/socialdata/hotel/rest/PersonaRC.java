package pe.com.socialdata.hotel.rest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.service.MensajeriaService;
import pe.com.socialdata.hotel.service.PersonaService;


@RestController
@RequestMapping("/v1")
public class PersonaRC {
	
	private static Logger log = Logger.getLogger(PersonaRC.class);
	
	@Autowired
	PersonaService personaService;
	
	@Autowired
	MensajeriaService mensajeriaService;
	
	@RequestMapping(value="/personas/{username}/user" , method = RequestMethod.GET, headers = "Accept=application/json",produces = "application/json")
	public ResponseEntity<PersonaModel> getUser( @PathVariable("username") String username){
		log.debug("getUser - inicio===========================================");

		PersonaModel personaModel=personaService.findByUsernameWithQuery(username);
		if (personaModel !=null){
		
			log.debug("getUser - fin===========================================");
			return new ResponseEntity<PersonaModel>(personaModel, HttpStatus.OK);
		}else{
			return new ResponseEntity<PersonaModel>(personaModel, HttpStatus.NOT_FOUND);
		}
		
	}
	
	//GET
			@RequestMapping(value="/personas/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
			public ResponseEntity<PersonaModel> getPersonaById(@PathVariable("id") Long idPersona){
				if (idPersona == null || idPersona <= 0) {
					return new ResponseEntity(new CustomErrorType("idPersona es requerido"), HttpStatus.CONFLICT);
				}
				
				PersonaModel persona = personaService.findPersonaModelById(idPersona);
				if (persona == null) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
				
				return new ResponseEntity<PersonaModel>(persona, HttpStatus.OK);
			}
	//POST
			@RequestMapping(value="/personas", method = RequestMethod.POST, headers = "Accept=application/json")
			public ResponseEntity<?> createPersona(@RequestBody PersonaModel personaModel, UriComponentsBuilder uriComponentsBuilder){
				log.debug("createPersona " + personaModel +"=======================================" );
				
				String url=uriComponentsBuilder.path("/v1/sigin/").toUriString();
				personaModel =personaService.addTrabajador(personaModel);
				mensajeriaService.sendCreateUser(personaModel, url);
				
				
				HttpHeaders headers = new HttpHeaders();
				headers.setLocation(
						uriComponentsBuilder.path("/v1/personas/{id}")
						.buildAndExpand(personaModel.getId())
						.toUri()
						);
				
				return new ResponseEntity<PersonaModel>(personaModel,headers, HttpStatus.CREATED);
			}
	

}
