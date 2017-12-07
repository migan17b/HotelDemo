package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="HABITACION", schema="HR")
public class Habitacion extends AuditingEntity implements  BaseEntity,  Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HABITACION_ID_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_HABITACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HABITACION_ID_GENERATOR")
	@Column(name="ID_HABITACION")
	private Long id;

	@Column(name="CARACTERISTICAS")
	private String caracteristicas;


	@Column(name="IND_ESTADO")
	private String indEstado;

	@Column(name="NUM_CAMAS")
	private Integer numCamas;

	@Column(name="NUM_HABITACION")
	private String numHabitacion;

	@Column(name="NUM_PISO")
	private Integer numPiso;

	@Column(name="PRECIO_DIA")
	private Double precioDia;

	@Column(name="PRECIO_HORA")
	private Double precioHora;
	
	
	@Column(name="ID_CATEGORIA", nullable=false)
	private Long idCategoria;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_CATEGORIA", insertable=false, updatable=false)
	private Categoria categoria;


	@Column(name="ID_HOTEL" ,nullable=false)
	private Long idHotel;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_HOTEL",  insertable=false, updatable=false)
	private Hotel hotel;

	

	
	public Habitacion() {
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCaracteristicas() {
		return caracteristicas;
	}



	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}



	public String getIndEstado() {
		return indEstado;
	}



	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}



	public Integer getNumCamas() {
		return numCamas;
	}



	public void setNumCamas(Integer numCamas) {
		this.numCamas = numCamas;
	}



	public String getNumHabitacion() {
		return numHabitacion;
	}



	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}



	public Integer getNumPiso() {
		return numPiso;
	}



	public void setNumPiso(Integer numPiso) {
		this.numPiso = numPiso;
	}



	public Double getPrecioDia() {
		return precioDia;
	}



	public void setPrecioDia(Double precioDia) {
		this.precioDia = precioDia;
	}



	public Double getPrecioHora() {
		return precioHora;
	}



	public void setPrecioHora(Double precioHora) {
		this.precioHora = precioHora;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public Hotel getHotel() {
		return hotel;
	}



	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}




	
	

	public Long getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}



	public Long getIdHotel() {
		return idHotel;
	}



	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}



	
	

}