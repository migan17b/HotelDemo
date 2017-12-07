package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HOTEL", schema="HR")
public class Hotel extends AuditingEntity implements  BaseEntity,  Serializable {
	

	private static final long serialVersionUID = 1L;


	@Id
	@SequenceGenerator(name="HOTEL_ID_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_HOTEL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HOTEL_ID_GENERATOR")
	@Column(name="ID_HOTEL")
	private Long id;

	
	@Column(name="DIRECCION")
	private String direccion;

	
	@Column(name="ESTRELLAS")
	private Integer estrellas;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="TELEFONO")
	private String telefono;
	
	@ManyToOne(fetch=FetchType.EAGER , optional=false)
	@JoinColumn(name="ID_EMPRESA")
	private Empresa empresa;

	@OneToMany(mappedBy="hotel", fetch=FetchType.EAGER)
	private List<Habitacion> habitaciones;
	
	
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





	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	
	
	
	
	
}
