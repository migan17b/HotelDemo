package pe.com.socialdata.hotel.entity;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="EMPRESA", schema="HR")
public class Empresa   extends AuditingEntity implements  BaseEntity,  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="EMPRESA_IDEMPRESA_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_EMPRESA" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPRESA_IDEMPRESA_GENERATOR" )
	@Column(name="ID_EMPRESA")
	private Integer id;
	
	@Column(name="RUC")
	private String ruc;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="TELEFONO")
	private String telefono;
	
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
    
	

}
