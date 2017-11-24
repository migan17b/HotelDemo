package pe.com.socialdata.hotel.model;



public class EmpresaModel  {
	
	
	private Integer id;
	
	
	private String ruc;
	

	private String nombre;
	

	private String telefono;

	private Long rowVersion;

	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	


	public Long getRowVersion() {
		return rowVersion;
	}


	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}


	@Override
	public String toString() {
		return "EmpresaModel [id=" + id + ", ruc=" + ruc + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", rowVersion=" + rowVersion + "]";
	}
	
	

}
