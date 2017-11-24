package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.model.UserRoleModel;
import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;




@Service("userService")
public class UserServiceImpl  implements UserDetailsService{

	
	private String token;


	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("user  :::::::::::::"+username + " ----" + this.token);
		//GENERANDO TOKEN LOGIN CON SERVICIO SECURITY==============
		 BackendRestInvoker<UserModel> restInvoker= new BackendRestInvoker<UserModel>(ConstantesURL.SECURITY_SERVER,ConstantesURL.SECURITY_PORT);

		  ResponseEntity<UserModel> responseEntity=
				restInvoker.sendGet(ConstantesURL.SECURITY_CONTEXT +"/v1/userrole/" + username , UserModel.class, this.token);
		
		  UserModel user = responseEntity.getBody();
		
		
		//User user = userRepository.findByUsername(username);
		System.out.println("roles number :::::::::::::"+user.getUserRole().size());
		List<GrantedAuthority>  authorities= buildAuhorities(user.getUserRole()); 
		
		return buildUser(user, authorities);
	}
	
	private org.springframework.security.core.userdetails.User buildUser(UserModel user , List<GrantedAuthority> authorities){
		System.out.println("user: " +user.getUsername() + "  pass :" +   user.getPassword()+ "*******************************************");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}
	private List<GrantedAuthority> buildAuhorities(List<UserRoleModel> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRoleModel userRole: userRoles){
			System.out.println("ROLES :::::: " + userRole.getRole() );
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		auths.add(new SimpleGrantedAuthority("token:"+this.getToken()));
		return new ArrayList<GrantedAuthority>(auths);
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
