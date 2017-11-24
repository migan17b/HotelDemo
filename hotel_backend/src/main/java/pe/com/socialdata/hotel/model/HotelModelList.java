package pe.com.socialdata.hotel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;






public class HotelModelList {

	
	
	private Long id;

	private String direccion;

	
	private Integer estrellas;

	private String nombre;

	private String telefono;
	
	private Integer idEmpresa;
	
	private EmpresaModel empresaModel;


	

	private Long rowVersion;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getEstrellas() {
		return estrellas;
	}


	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	


	

	

	public EmpresaModel getEmpresaModel() {
		return empresaModel;
	}


	public void setEmpresaModel(EmpresaModel empresaModel) {
		this.empresaModel = empresaModel;
	}


	public Integer getIdEmpresa() {
		return idEmpresa;
	}


	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}


	public Long getRowVersion() {
		return rowVersion;
	}


	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	


	
	
	


	@Override
	public String toString() {
		return "HotelModel [id=" + id + ", direccion=" + direccion + ", estrellas=" + estrellas + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", idEmpresa=" + idEmpresa + ", rowVersion=" + rowVersion + "]";
	}
	
	
	
	
}
