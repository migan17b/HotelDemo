package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;




/**
 * The persistent class for the CONSUMO database table.
 * 
 */
@Entity
@Table(name="CONSUMO",  schema="REG_HOTEL")
public class Consumo extends AuditingEntity implements  BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsumoPK id;

	@Column(name="CANTIDAD")
	private Double cantidad;


	@Column(name="IND_ESTADO")
	private String indEstado;

	@Column(name="PRECIO_PAGO")
	private Double precioPago;

	@Column(name="PRECIO_VENTA")
	private Double precioVenta;

	@Column(name="UNIDAD")
	private String unidad;


	@ManyToOne(optional=true)
	@JoinColumn(name="ID_COMPROBANTE" )
	private Comprobante comprobante;

	@ManyToOne()
	@JoinColumn(name="ID_PRODUCTO", insertable=false, updatable=false  )
	private Producto producto;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ID_RESERVA",  insertable=false, updatable=false)
	private Reserva reserva;

	public Consumo() {
	}

	public ConsumoPK getId() {
		return this.id;
	}

	public void setId(ConsumoPK id) {
		this.id = id;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}



	public String getIndEstado() {
		return this.indEstado;
	}

	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}

	public Double getPrecioPago() {
		return this.precioPago;
	}

	public void setPrecioPago(Double precioPago) {
		this.precioPago = precioPago;
	}

	public Double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	

	public Comprobante getComprobante() {
		return this.comprobante;
	}

	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	
	

}