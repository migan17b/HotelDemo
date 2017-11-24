package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.User;
import pe.com.socialdata.hotel.entity.UserRole;
import pe.com.socialdata.hotel.repository.UserRepository;




@Service("userService")
public class UserServiceImpl  implements UserDetailsService{

	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("user  :::::::::::::"+username);
		User user = userRepository.findByUsername(username);
		System.out.println("roles number :::::::::::::"+user.getUserRole().size());
		List<GrantedAuthority>  authorities= buildAuhorities(user.getUserRole()); 
		
		return buildUser(user, authorities);
	}
	
	private org.springframework.security.core.userdetails.User buildUser(User user , List<GrantedAuthority> authorities){
		System.out.println("user: " +user.getUsername() + "  pass :" +   user.getPassword());
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);
	}
	private List<GrantedAuthority> buildAuhorities(List<UserRole> userRoles){
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for(UserRole userRole: userRoles){
			System.out.println("ROLES :::::: " + userRole.getRole() );
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
	
}

