package pe.com.socialdata.hotel.rest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.socialdata.hotel.model.TokenModel;
import pe.com.socialdata.hotel.service.MensajeriaService;

@RestController
@RequestMapping("/v1")
public class LoginAccount {
	private static Logger log = Logger.getLogger(LoginAccount.class);
	
	@Autowired
	MensajeriaService mensajeriaService;
	
	
	
	
	@RequestMapping(value="/sigin/{token}" , method = RequestMethod.GET,  headers = "Accept=application/json" ,produces = "application/json")
	public ResponseEntity<TokenModel> getUser( @PathVariable("token") String token){
		log.debug("login - inicio===========================================");
		
		TokenModel tokenModel = new TokenModel();  
			
		if (token !=null){
			log.debug("token " + token);
			
			tokenModel.setToken(token);
			return new ResponseEntity<TokenModel>(tokenModel, HttpStatus.OK);
		}else{
			return new ResponseEntity<TokenModel>(tokenModel, HttpStatus.UNAUTHORIZED);
		}
		
	}
}
