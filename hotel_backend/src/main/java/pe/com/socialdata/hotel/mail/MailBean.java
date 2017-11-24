package pe.com.socialdata.hotel.mail;

public class MailBean {
	
	
	
	String nomDestino;
	String emailDestino;//correo donde se envia

	String nomOrigen;
	String emailOrigen ;//correo origen
	String fechaHora;
	
	String mensaje;
	String asunto;
	public String getNomDestino() {
		return nomDestino;
	}
	public void setNomDestino(String nomDestino) {
		this.nomDestino = nomDestino;
	}
	public String getEmailDestino() {
		return emailDestino;
	}
	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}
	public String getNomOrigen() {
		return nomOrigen;
	}
	public void setNomOrigen(String nomOrigen) {
		this.nomOrigen = nomOrigen;
	}
	public String getEmailOrigen() {
		return emailOrigen;
	}
	public void setEmailOrigen(String emailOrigen) {
		this.emailOrigen = emailOrigen;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	
	
	
}
