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
	
	

		
		
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		
	    http.csrf().disable()
	    	.authorizeRequests()
	        .antMatchers("/").permitAll()
	       
	        .anyRequest().authenticated()
	        .and()
	        // Filtar las rutasJWT in header
	       
	        .addFilterBefore(new JWTAuthenticationFilter(),
	                UsernamePasswordAuthenticationFilter.class);
	  }

	
		
		

}
