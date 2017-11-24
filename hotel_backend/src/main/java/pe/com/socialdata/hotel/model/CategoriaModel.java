package pe.com.socialdata.hotel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pe.com.socialdata.hotel.entity.Habitacion;

public class CategoriaModel {

	private Long id;


	private String nombre;

	private Double precio;

	 private Long rowVersion;

	 @JsonIgnore
	private List<Habitacion> habitaciones;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}



	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}


	

	public Long getRowVersion() {
		return rowVersion;
	}



	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}



	@Override
	public String toString() {
		return "CategoriaModel [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", rowVersion=" + rowVersion
				+ "]";
	}



	

	
	
	
	
	
	
	
}
