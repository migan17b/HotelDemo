package pe.com.socialdata.hotel.model;

import java.util.Date;
import java.util.List;




public class ReservaModel {

	private Long id;
	

	private Double costo;


	private Date fechaIngreso;


	private Date fechaReserva;


	private Date fechaSalida;


	private String indEstado;


	private String indModalidad;

	
	private Integer numDias;


	private Integer numHoras;


	private String observacion;


	private String tipoReserva;

	


	private Long idHabitacion;


	private PersonaModel persona;
	

	private Long idPersona;


	 private Long rowVersion;
	 
	private List<ConsumoModel> consumos;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getCosto() {
		return costo;
	}


	public void setCosto(Double costo) {
		this.costo = costo;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	public Date getFechaReserva() {
		return fechaReserva;
	}


	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public String getIndEstado() {
		return indEstado;
	}


	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}


	public String getIndModalidad() {
		return indModalidad;
	}


	public void setIndModalidad(String indModalidad) {
		this.indModalidad = indModalidad;
	}


	public Integer getNumDias() {
		return numDias;
	}


	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}


	public Integer getNumHoras() {
		return numHoras;
	}


	public void setNumHoras(Integer numHoras) {
		this.numHoras = numHoras;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public String getTipoReserva() {
		return tipoReserva;
	}


	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}


	


	public Long getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	public PersonaModel getPersona() {
		return persona;
	}


	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}


	public Long getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}


	public List<ConsumoModel> getConsumos() {
		return consumos;
	}


	public void setConsumos(List<ConsumoModel> consumos) {
		this.consumos = consumos;
	}


	public Long getRowVersion() {
		return rowVersion;
	}


	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}
	
	

}
