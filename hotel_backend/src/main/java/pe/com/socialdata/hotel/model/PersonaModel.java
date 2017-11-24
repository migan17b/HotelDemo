package pe.com.socialdata.hotel.model;


import javax.persistence.Column;
import javax.persistence.Transient;

import pe.com.socialdata.hotel.entity.User;

public class PersonaModel {
	
	
	private Long id;


	private String apeMaterno;

	
	private String apePaterno;

	
	private String nombres;
	
	

	private String correo;

	
	private String direccion;

	
	private Integer idEmpresa;


	private String numDoc;



	private String telefono;


	private String tipoDoc;


	private Integer tipoPer;


	private User user;
	
	
	
	private String username;


	private String password;
	
	
	private String fullName;
	
	 private Long rowVersion;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getApeMaterno() {
		return apeMaterno;
	}


	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}


	public String getApePaterno() {
		return apePaterno;
	}


	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public String getNumDoc() {
		return numDoc;
	}


	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public Integer getTipoPer() {
		return tipoPer;
	}


	public void setTipoPer(Integer tipoPer) {
		this.tipoPer = tipoPer;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullName() {
		return this.getApePaterno()+ " " + this.getApeMaterno() + " "+ this.getNombres()  ;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Long getRowVersion() {
		return rowVersion;
	}


	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}
	
	
	
	
	
}
