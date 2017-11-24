package pe.com.socialdata.hotel.jasper;

import java.util.List;








public class HabitacionReporte {

	
	private String id;
	
	private String categoria;
	
	private String numHabitacion;
	
	private String numPiso;
	
	private String numCamas;
	
	private String caracteristicas;

	private String precioDia;

	
	private String precioHora;

	private String estado;

	public String getId() {
		return id;
	}
	
	

	public void setId(String id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(String numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	public String getNumPiso() {
		return numPiso;
	}

	public void setNumPiso(String numPiso) {
		this.numPiso = numPiso;
	}

	public String getNumCamas() {
		return numCamas;
	}

	public void setNumCamas(String numCamas) {
		this.numCamas = numCamas;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(String precioDia) {
		this.precioDia = precioDia;
	}

	public String getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(String precioHora) {
		this.precioHora = precioHora;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



	@Override
	public String toString() {
		return "HabitacionReporte [id=" + id + ", categoria=" + categoria + ", numHabitacion=" + numHabitacion
				+ ", numPiso=" + numPiso + ", numCamas=" + numCamas + ", caracteristicas=" + caracteristicas
				+ ", precioDia=" + precioDia + ", precioHora=" + precioHora + ", estado=" + estado + "]";
	}


	
	
	
	
	
}
