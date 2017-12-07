package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS" ,  schema="HR")
public class User   extends AuditingEntity implements  BaseEntity,  Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_NAME")
	private String username;

	
	@Column(name="EMAIL")
	private String email;

	@Column(name="ENABLED")
	private Boolean enabled;

	@Column(name="IND_ESTADO")
	private String indEstado;

	@Column(name="PASSWORD")
	private String password;
	
	@Transient
	private String fullName;
	
	@Transient
	private Integer idEmpresa;
	
	@OneToMany(fetch =FetchType.EAGER ,mappedBy="user")
	private List<UserRole> userRole;

	public User() {
	}

	

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getIndEstado() {
		return indEstado;
	}

	public void setIndEstado(String indEstado) {
		this.indEstado = indEstado;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public Integer getIdEmpresa() {
		return idEmpresa;
	}



	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public User(String username, String email, Boolean enabled, String indEstado, String password) {
		super();
		this.username = username;
		this.email = email;
		this.enabled = enabled;
		this.indEstado = indEstado;
		this.password = password;
	}



	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", enabled=" + enabled + ", indEstado=" + indEstado
				+ ", password=" + password + "]";
	}



	
	

}