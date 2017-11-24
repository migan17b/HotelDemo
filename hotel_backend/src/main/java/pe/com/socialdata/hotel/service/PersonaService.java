package pe.com.socialdata.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.model.PersonaModel;


public interface PersonaService {
	
	 
	public List<PersonaModel> listAllPersona();
	
	public abstract PersonaModel findPersonaModelById(Long id);
	
	public abstract PersonaModel findByUsernameWithQuery(String username);
}
