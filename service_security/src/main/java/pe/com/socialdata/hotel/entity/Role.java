package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ROLE" database table.
 * 
 */
@Entity
@Table(name="ROLE",  schema="REG_HOTEL")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ROLE")
	private String role;

	



	@Column(name="IND_ESTADO")
	private String indEstado;



	
	@OneToMany(mappedBy="role")
	private List<Perfil> perfils;




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public String getIndEstado() {
		return indEstado;
	}




	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}




	public List<Perfil> getPerfils() {
		return perfils;
	}




	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	


	
	

	

}