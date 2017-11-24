package pe.com.socialdata.hotel.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.com.socialdata.hotel.entity.Persona;


public interface PersonaRespository extends JpaRepository<Persona, Serializable>{
	

	public abstract Persona findById(Long id);
	
	@Query("from Persona p where lower(p.user.username) = lower(:username)")
	List<Persona> findByUsernameWithQuery(@Param("username") String username);
	

}
