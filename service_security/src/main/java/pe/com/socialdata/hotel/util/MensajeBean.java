package pe.com.socialdata.hotel.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MensajeBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private String mensajeerror = "";
	 private String mensajesol = "";
 
	 private boolean error;

	   private List errorDetail;
	 private Map data;
	 
	 
	 
	 
	public String getMensajeerror() {
		return mensajeerror;
	}
	public void setMensajeerror(String mensajeerror) {
		this.mensajeerror = mensajeerror;
	}
	public String getMensajesol() {
		return mensajesol;
	}
	public void setMensajesol(String mensajesol) {
		this.mensajesol = mensajesol;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public List getErrorDetail() {
		return errorDetail;
	}
	public void setErrorDetail(List errorDetail) {
		this.errorDetail = errorDetail;
	}
	public Map getData() {
		return data;
	}
	public void setData(Map data) {
		this.data = data;
	}
	 
	 
	 
	 
}
