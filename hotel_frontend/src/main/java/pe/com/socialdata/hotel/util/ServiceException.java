package pe.com.socialdata.hotel.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServiceException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MensajeBean mensaje;
	
	public ServiceException() {}
   
  public ServiceException(Object origen, String mensaje)
	  {
	    super(mensaje);
	    Log log = LogFactory.getLog(origen.getClass());
	    log.error(origen.getClass().getName() + "|" + mensaje);
	    log.debug("Error", this);
	   }
	  
   public ServiceException(Object origen, Exception e) {
	     super(e);
	     Log log = LogFactory.getLog(origen.getClass());
     log.error(origen.getClass().getName() + "|" + e.getMessage());
	     log.debug("Error", this);
	   }
	  
	  public ServiceException(Object origen, MensajeBean mensaje) {
	     super(mensaje.getMensajeerror());
	    this.mensaje = mensaje;
	    Log log = LogFactory.getLog(origen.getClass());
	    log.error(origen.getClass().getName() + "|" + mensaje.getMensajeerror());
	    log.debug("Error", this);
	   }
  
	
	
}
