package pe.com.socialdata.hotel.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity


public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	  	@Autowired
		@Qualifier("userService")
		private UserDetailsService userService;
	  

		
		
		 @Override
		  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			 auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder()) ;
		 }
	  	
	  /*	@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder()) ;
		} */
	  	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		
	    http.csrf().disable()
	    	.authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.GET, "/v1/sigin/*").permitAll()
	        .antMatchers(HttpMethod.POST, "/login").permitAll()
	        //.antMatchers(HttpMethod.POST, "/userrole").permitAll()
	        .anyRequest().authenticated()
	        .and()
	        // redireccionamos a la cuenta login
	        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
	                UsernamePasswordAuthenticationFilter.class)
	        // Filtar las rutasJWT in header
	       	        .addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	  }

	
		
		

}
