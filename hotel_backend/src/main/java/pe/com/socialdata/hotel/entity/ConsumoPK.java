package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;


@Embeddable
public class ConsumoPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="ID_PRODUCTO")
	private Long idProducto;

	@Column(name="ID_RESERVA")
	private Long idReserva;

	public ConsumoPK() {
	}
	
	
	
	public ConsumoPK(Long idProducto, Long idReserva) {
		super();
		this.idProducto = idProducto;
		this.idReserva = idReserva;
	}



	public Long getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Long getIdReserva() {
		return this.idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsumoPK)) {
			return false;
		}
		ConsumoPK castOther = (ConsumoPK)other;
		return 
			(this.idProducto == castOther.idProducto)
			&& (this.idReserva == castOther.idReserva);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idProducto ^ (this.idProducto >>> 32)));
		hash = hash * prime + ((int) (this.idReserva ^ (this.idReserva >>> 32)));
		
		return hash;
	}
}