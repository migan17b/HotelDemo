package pe.com.socialdata.hotel.rest;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.socialdata.hotel.model.UserModel;

import pe.com.socialdata.hotel.service.UserRoleService;

@RestController
@RequestMapping("/v1")
public class UserRoleRC {
	
	private static Logger log = Logger.getLogger(UserRoleRC.class);
	
	@Autowired
	UserRoleService userRoleService;

	@RequestMapping(value="/userrole/{username}" , method = RequestMethod.GET,  headers = "Accept=application/json" ,produces = "application/json")
	public ResponseEntity<UserModel> userrole(@PathVariable("username") String username){
		log.debug("userrole - inicio===========================================");
		
		UserModel user=userRoleService.findUserRoleByUsername(username);
			
		if (user !=null){
		

			log.debug("userrole - fin===========================================");
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);
		}else{
			return new ResponseEntity<UserModel>(user, HttpStatus.NOT_FOUND);
		}
		
	}
}
