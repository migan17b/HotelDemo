package pe.com.socialdata.hotel.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import pe.com.socialdata.hotel.model.HelloOut;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/")

public class indexRC {
	private static Logger log = Logger.getLogger(indexRC.class);
	
	@RequestMapping( method = RequestMethod.GET)
    public ResponseEntity<HelloOut> world( HttpServletResponse httpResponse, WebRequest request) {
	
	HelloOut output = new HelloOut();



	try {
	  

	    output.setCodigo("00");
	    output.setMessage("HELLO SECURITY!!!!");

	} catch (Exception e) {
	    log.error(e.getMessage(), e);
	    
	    output.setCodigo("01");
	    output.setMessage(e.getMessage());;
	} finally {
	    
	}
	return new ResponseEntity<HelloOut>(output, HttpStatus.OK);
    }

}
