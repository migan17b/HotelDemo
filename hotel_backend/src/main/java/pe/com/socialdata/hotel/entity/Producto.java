package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Persistable;


/**
 * The persistent class for the PRODUCTO database table.
 * 
 */
@Entity
@Table(name="PRODUCTO",  schema="REG_HOTEL")
@DynamicUpdate
@NamedQuery(name = "Producto.getByIdNamedQuery", query = "FROM Producto WHERE id = ?1")
public class Producto extends AuditingEntity implements  BaseEntity{
	
	
	@Id
	@SequenceGenerator(name="PRODUCTO_IDPRODUCTO_GENERATOR", allocationSize = 1,sequenceName="SEQ_PRODUCTO" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTO_IDPRODUCTO_GENERATOR" )
	@Column(name="ID_PRODUCTO")
	private Long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;
	
	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PRECIO_VENTA")
	private Double precioVenta;

	@Column(name="TIPO")
	private String tipo;

	@Column(name="UNIDAD")
	private String unidad;

	
	public Producto() {
	}

	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecioVenta() {
		return this.precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public Producto( String descripcion, String nombre, Double precioVenta, String tipo,
			String unidad) {
		super();
	
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.tipo = tipo;
		this.unidad = unidad;
	}


	






	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	
	
	
	

}