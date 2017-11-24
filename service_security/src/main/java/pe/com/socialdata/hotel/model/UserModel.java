package pe.com.socialdata.hotel.model;

import java.io.Serializable;
import java.util.List;





public class UserModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;

	private String email;


	private Boolean enabled;


	private String indEstado;

		
	private List<UserRoleModel> userRole;
	
	


	public Boolean isEnabled() {
		return enabled;
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


	public Boolean getEnabled() {
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


	public List<UserRoleModel> getUserRole() {
		return userRole;
	}


	public void setUserRole(List<UserRoleModel> userRole) {
		this.userRole = userRole;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	
	
	
}
