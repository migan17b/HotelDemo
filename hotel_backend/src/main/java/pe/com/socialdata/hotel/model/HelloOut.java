package pe.com.socialdata.hotel.model;

import java.io.Serializable;

public class HelloOut implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6361864567957620748L;
	
	private String codigo;
	private String message;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
