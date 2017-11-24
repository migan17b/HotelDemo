package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;



import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@Entity
@Table(name="CATEGORIA", schema="REG_HOTEL")
public class Categoria  extends AuditingEntity implements Serializable, BaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_ID_GENERATOR", allocationSize = 1,sequenceName="SEQ_CATEGORIA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_ID_GENERATOR" )
	@Column(name="ID_CATEGORIA")
	private Long id;

	@Column(name="NOMBRE")
	private String nombre;

	@Column(name="PRECIO")
	private Double precio;

	
	

	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	
	



	public Categoria() {
	}

	


}