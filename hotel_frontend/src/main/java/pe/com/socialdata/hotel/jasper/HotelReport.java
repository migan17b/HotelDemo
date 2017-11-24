package pe.com.socialdata.hotel.jasper;

import java.util.List;

import pe.com.socialdata.hotel.model.EmpresaModel;
import pe.com.socialdata.hotel.model.HabitacionModel;






public class HotelReport {

	
	
	private Long id;

	private String direccion;

	
	private String estrellas;

	private String nombre;

	private String telefono;
	
	private String nomEmpresa;

	
	public HotelReport() {
		
	}
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

	public String getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(String estrellas) {
		this.estrellas = estrellas;
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

	public String getNomEmpresa() {
		return nomEmpresa;
	}

	public void setNomEmpresa(String nomEmpresa) {
		this.nomEmpresa = nomEmpresa;
	}

	public HotelReport(Long id, String direccion, String estrellas, String nombre, String telefono, String nomEmpresa) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.estrellas = estrellas;
		this.nombre = nombre;
		this.telefono = telefono;
		this.nomEmpresa = nomEmpresa;
	}
	

	
	
}
