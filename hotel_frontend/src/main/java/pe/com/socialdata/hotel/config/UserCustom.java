package pe.com.socialdata.hotel.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class UserCustom extends org.springframework.security.core.userdetails.User {

	
	private String token;
	public UserCustom(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
