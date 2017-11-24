package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="EMPRESA", schema="REG_HOTEL")
public class Comprobante extends AuditingEntity implements  BaseEntity, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPROBANTE_ID_GENERATOR", allocationSize = 1,sequenceName="SEQ_COMPROBANTE" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPROBANTE_ID_GENERATOR" )
	@Column(name="ID_COMPROBANTE")
	private Long id;


	@Column(name="DESCUENTO")
	private Double descuento;

	@Column(name="ESTADO")
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PAGO")
	private Date fechaPago;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_VOUCHER")
	private Date fechaVoucher;

	@Column(name="IGV")
	private Double igv;

	@Column(name="NUM_VOUACHER")
	private String numVouacher;

	@Column(name="NUMERO_COMPROBANTE")
	private String numeroComprobante;

	@Column(name="SERIE_COMPROBANTE")
	private String serieComprobante;

	@Column(name="SUB_TOTAL")
	private Double subTotal;

	@Column(name="TIPO_COMPROBANTE")
	private String tipoComprobante;

	@Column(name="TIPO_PAGO")
	private String tipoPago;

	@Column(name="TOTAL_PAGO")
	private Double totalPago;

	

	
	@OneToMany(mappedBy="comprobante")
	private List<Consumo> consumos;

	public Comprobante() {
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Date getFechaVoucher() {
		return this.fechaVoucher;
	}

	public void setFechaVoucher(Date fechaVoucher) {
		this.fechaVoucher = fechaVoucher;
	}

	
	public String getNumVouacher() {
		return this.numVouacher;
	}

	public void setNumVouacher(String numVouacher) {
		this.numVouacher = numVouacher;
	}

	public String getNumeroComprobante() {
		return this.numeroComprobante;
	}

	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}

	public String getSerieComprobante() {
		return this.serieComprobante;
	}

	public void setSerieComprobante(String serieComprobante) {
		this.serieComprobante = serieComprobante;
	}

	
	public String getTipoComprobante() {
		return this.tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}

	
	public List<Consumo> getConsumos() {
		return this.consumos;
	}

	public void setConsumos(List<Consumo> consumos) {
		this.consumos = consumos;
	}

	public Consumo addConsumo(Consumo consumo) {
		getConsumos().add(consumo);
		consumo.setComprobante(this);

		return consumo;
	}

	public Consumo removeConsumo(Consumo consumo) {
		getConsumos().remove(consumo);
		consumo.setComprobante(null);

		return consumo;
	}

}