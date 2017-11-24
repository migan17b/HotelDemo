package pe.com.socialdata.hotel.rest;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.com.socialdata.hotel.model.TokenModel;
import pe.com.socialdata.hotel.repository.LogContext;


@RestController
public class LoginRC {

	public LoginRC() {
		// TODO Auto-generated constructor stub
	}
	private static Logger log = Logger.getLogger(LoginRC.class);
	static final String HEADER_STRING = "Authorization";
	
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public ResponseEntity<TokenModel> getUser( HttpServletResponse res){
		log.debug("login - inicio===========================================");
		
		TokenModel tokenModel = new TokenModel();  
			String token =res.getHeader(HEADER_STRING);
		if (token !=null){
		
			tokenModel.setToken(token);
			return new ResponseEntity<TokenModel>(tokenModel, HttpStatus.OK);
		}else{
			return new ResponseEntity<TokenModel>(tokenModel, HttpStatus.UNAUTHORIZED);
		}
		
	}
	
	
}
