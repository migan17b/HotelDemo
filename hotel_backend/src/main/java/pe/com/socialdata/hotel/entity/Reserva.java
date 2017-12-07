package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="RESERVA",  schema="HR")
public class Reserva extends AuditingEntity implements  BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESERVA_IDRESERVA_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_RESERVA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESERVA_IDRESERVA_GENERATOR")
	@Column(name="ID_RESERVA")
	private Long id;
	
	
	@Column(name="COSTO")
	private Double costo;


	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_INGRESO")
	private Date fechaIngreso;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_RESERVA")
	private Date fechaReserva;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_SALIDA")
	private Date fechaSalida;

	@Column(name="IND_ESTADO")
	private String indEstado;

	@Column(name="IND_MODALIDAD")
	private String indModalidad;

	@Column(name="NUM_DIAS")
	private Integer numDias;

	@Column(name="NUM_HORAS")
	private Integer numHoras;

	@Column(name="OBSERVACION")
	private String observacion;

	@Column(name="TIPO_RESERVA")
	private String tipoReserva;

	@ManyToOne
	@JoinColumn(name="ID_HABITACION" , insertable=false, updatable=false)
	private Habitacion habitacion;

	
	@Column(name="ID_HABITACION")
	private Long idHabitacion;

	

	@ManyToOne
	@JoinColumn(name="ID_PERSONA", insertable=false, updatable=false)
	private Persona persona;
	
	@Column(name="ID_PERSONA")
	private Long idPersona;


	@OneToMany(mappedBy="reserva")
	private List<Consumo> consumos;

	
	
	
	public Reserva() {
	}

	

	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	

	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getIndEstado() {
		return this.indEstado;
	}

	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}

	public String getIndModalidad() {
		return this.indModalidad;
	}

	public void setIndModalidad(String indModalidad) {
		this.indModalidad = indModalidad;
	}

	public Integer getNumDias() {
		return this.numDias;
	}

	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

	public Integer getNumHoras() {
		return this.numHoras;
	}

	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipoReserva() {
		return this.tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}


	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	

	public Habitacion getHabitacion() {
		return this.habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdHabitacion() {
		return idHabitacion;
	}



	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}



	public Long getIdPersona() {
		return idPersona;
	}



	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}







}