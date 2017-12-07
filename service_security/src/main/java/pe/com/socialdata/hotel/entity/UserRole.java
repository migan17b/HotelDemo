package pe.com.socialdata.hotel.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERROLE database table.
 * 
 */
@Entity
@Table(name="USERROLE" , schema="HR", 
uniqueConstraints=@UniqueConstraint(columnNames={"ROLE","USER_NAME"} ))
public class UserRole extends AuditingEntity implements  BaseEntity,  Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USER_ROLE_ID_GENERATOR", allocationSize = 1,sequenceName="HR.SEQ_USER_ROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ROLE_ID_GENERATOR")
	@Column(name="USER_ROLE_ID")
	private Long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_NAME" , nullable=false)
	private User user;

	@Column(name="ROLE" , nullable=false, length=45)
	private String role;





	public UserRole() {
	}





	public Long getUserRoleId() {
		return userRoleId;
	}





	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}

	

}