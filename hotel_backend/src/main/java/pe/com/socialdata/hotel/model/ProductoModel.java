package pe.com.socialdata.hotel.model;


public class ProductoModel {

	private Long id;
	

	private String descripcion;
	

	private String nombre;


	private Double precioVenta;

	private String tipo;


	private String unidad;

	private Long rowVersion;
	


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getRowVersion() {
		return rowVersion;
	}


	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}


	@Override
	public String toString() {
		return "ProductoModel [id=" + id + ", descripcion=" + descripcion + ", nombre=" + nombre + ", precioVenta="
				+ precioVenta + ", tipo=" + tipo + ", unidad=" + unidad + ", rowVersion=" + rowVersion + "]";
	}
	
	
	
	
	
	
	
}
