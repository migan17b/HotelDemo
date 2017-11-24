package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;



/**
 * The persistent class for the PERFIL database table.
 * 
 */
@Entity
@Table(name="PERFIL" , schema="REG_HOTEL")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PERFIL")
	private Long id;



	@Column(name="ROLE")
	private String rol;



	//bi-directional many-to-one association to Module
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ID_MODULE")
	private Module module;

	@ManyToOne
	@JoinColumn(name="ROLE" , insertable=false, updatable=false)
	private Role role;


	public Perfil() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRol() {
		return rol;
	}


	public void setRol(String rol) {
		this.rol = rol;
	}


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	

	

}