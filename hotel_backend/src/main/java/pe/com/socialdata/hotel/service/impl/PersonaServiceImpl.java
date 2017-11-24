package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.com.socialdata.hotel.entity.Hotel;
import pe.com.socialdata.hotel.entity.Persona;
import pe.com.socialdata.hotel.entity.User;
	
import pe.com.socialdata.hotel.model.EmpresaModel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.model.convert.PersonaConvert;
import pe.com.socialdata.hotel.repository.PersonaRespository;

import pe.com.socialdata.hotel.service.PersonaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service
public class PersonaServiceImpl implements PersonaService {

	private static final Log LOG = LogFactory.getLog(PersonaServiceImpl.class);
	
	@Autowired
	PersonaRespository personaRespository;
	
	
	@Autowired
	PersonaConvert personaConvert;
	
	
	@Override
	public List<PersonaModel> listAllPersona() {
		LOG.debug("inicia listAllPersona");
		List<Persona> personas= (List<Persona>)personaRespository.findAll();
	 	List<PersonaModel> personsasModel = new ArrayList<PersonaModel>();
	 	if (null!=personas){
	 		
		 	for(Persona persona : personas){
		 		LOG.debug("id:"+ persona.getId());
		 		personsasModel.add(personaConvert.convertPersona2PersonaModel(persona) );
		 	}
	 	}
	 	LOG.debug("fin listAllPersona");
	 	return personsasModel;
	}

	@Override
	public PersonaModel findPersonaModelById(Long id) {
		LOG.debug("inicio findPersonaModelById");
		
		
		
		return personaConvert.convertPersona2PersonaModel(personaRespository.findById (id));
	}

	@Override
	public PersonaModel findByUsernameWithQuery(String username) {
		
		return personaConvert.convertPersona2PersonaModel(personaRespository.findByUsernameWithQuery (username).get(0));
	}

	
}
