package pe.com.socialdata.hotel.model;

import java.util.List;








public class HabitacionModel {

	
	private Long id;
	
	private Long idHotel;
	
	private HotelModel hotel;
	
	private Long idCategoria;

	
	private CategoriaModel categoria;
	
	
	private String numHabitacion;
	
	private Integer numPiso;
	
	private Integer numCamas;
	
	private String caracteristicas;

	private Double precioDia;

	
	private Double precioHora;

	private String indEstado;

	private List<ReservaModel> reservas;
	
	private List<CategoriaModel> categorias;

	private Long rowVersion;
	


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




	public Long getIdCategoria() {
		return idCategoria;
	}




	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}




	public CategoriaModel getCategoria() {
		return categoria;
	}




	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}




	public Long getIdHotel() {
		return idHotel;
	}




	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}




	public HotelModel getHotel() {
		return hotel;
	}




	public void setHotel(HotelModel hotel) {
		this.hotel = hotel;
	}




	public List<ReservaModel> getReservas() {
		return reservas;
	}




	public void setReservas(List<ReservaModel> reservas) {
		this.reservas = reservas;
	}




	public Long getRowVersion() {
		return rowVersion;
	}




	public void setRowVersion(Long rowVersion) {
		this.rowVersion = rowVersion;
	}




	public List<CategoriaModel> getCategorias() {
		return categorias;
	}




	public void setCategorias(List<CategoriaModel> categorias) {
		this.categorias = categorias;
	}




	@Override
	public String toString() {
		return "HabitacionModel [id=" + id + ", idHotel=" + idHotel + ", idCategoria=" + idCategoria
				+ ", numHabitacion=" + numHabitacion + ", numPiso=" + numPiso + ", numCamas=" + numCamas
				+ ", caracteristicas=" + caracteristicas + ", precioDia=" + precioDia + ", precioHora=" + precioHora
				+ ", indEstado=" + indEstado + ", rowVersion=" + rowVersion + "]";
	}
	
	
	
	
	
	
}
