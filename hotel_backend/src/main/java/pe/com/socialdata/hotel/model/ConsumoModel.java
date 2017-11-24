package pe.com.socialdata.hotel.model;



import javax.persistence.Column;

import pe.com.socialdata.hotel.entity.Comprobante;
import pe.com.socialdata.hotel.entity.ConsumoPK;
import pe.com.socialdata.hotel.entity.Producto;
import pe.com.socialdata.hotel.entity.Reserva;

public class ConsumoModel {
	

	private Long idProducto;


	private Long idReserva;

	
	private Double cantidad;



	private String indEstado;

	private Double precioPago;


	private Double precioVenta;


	private String unidad;


	
	private Comprobante comprobante;

	
	private Producto producto;


	private Reserva reserva;


	


	public Double getCantidad() {
		return cantidad;
	}


	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}


	public String getIndEstado() {
		return indEstado;
	}


	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}


	public Double getPrecioPago() {
		return precioPago;
	}


	public void setPrecioPago(Double precioPago) {
		this.precioPago = precioPago;
	}


	public Double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public String getUnidad() {
		return unidad;
	}


	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	public Comprobante getComprobante() {
		return comprobante;
	}


	public void setComprobante(Comprobante comprobante) {
		this.comprobante = comprobante;
	}


	public Producto getProducto() {
		return producto;
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


	public Long getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}


	public Long getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	
	
	

}
