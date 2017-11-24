package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;
import pe.com.socialdata.hotel.service.PersonaService;




@Service
public class PersonaServiceImpl implements PersonaService {

	private static final Log LOG = LogFactory.getLog(PersonaServiceImpl.class);
	/*
	@Autowired
	PersonaRespository personaRespository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	PersonaConvert personaConvert;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW  )
	@Override
	public PersonaModel addTrabajador(PersonaModel personaModel) {
		try {
			LOG.debug("addTrabajador");
			personaModel.setTipoDoc(ConstantesHotel.TIPO_DOCUMENTO_DNI);
			personaModel.setTipoPer(ConstantesHotel.TIPO_PERSONA_TRABAJADOR);
			
			
			LOG.debug("=======================================");
			//CREANDO USUARIO
			BCryptPasswordEncoder pe= new BCryptPasswordEncoder();
			String username =personaModel.getNombres().substring(0, 1) + personaModel.getApePaterno();
			String password="123456";
			User user = new User(username, personaModel.getCorreo(), true, "1", pe.encode(password ));
			userRepository.save(user);
			LOG.debug("1 - user create");
			//CREANDO USER-ROL 
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole(ConstantesHotel.ROLE_USER);
			LOG.debug("2 - role-user create");
			userRoleRepository.save(userRole);
			Persona persona = personaConvert.convertPersonaModel2Persona (personaModel);
			
			//CREANDO PERSONA
			persona.setUser(user);
			persona =personaRespository.save(persona);
			LOG.debug("3 - Persona create");
			
			personaModel = personaConvert.convertPersona2PersonaModel(persona);
		}catch (GenericJDBCException eq) {
			
			//	LOG.error(eq.getMessage(), eq);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_DATA_BD));	
			} catch (Exception ex) {
				LOG.error(ex.getMessage(), ex);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
			}
			finally{
				LOG.debug(getClass().getName() +"Fin save");
			}
		return personaModel;
	}

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

	@Override
	public PersonaModel updateTrabajador(PersonaModel personaModel) {
		try {
			LOG.debug("updateTrabajador");
			Persona persona = personaConvert.convertPersonaModel2Persona (personaModel);
			persona =personaRespository.save(persona);
			LOG.debug("1 - Persona update");
			
			personaModel = personaConvert.convertPersona2PersonaModel(persona);
		}catch (GenericJDBCException eq) {
			
			//	LOG.error(eq.getMessage(), eq);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_DATA_BD));	
			} catch (Exception ex) {
				LOG.error(ex.getMessage(), ex);
				throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
			}
			finally{
				LOG.debug(getClass().getName() +"Fin save");
			}
		return personaModel;
	}*/

	@Override
	public PersonaModel addTrabajador(PersonaModel personaModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaModel updateTrabajador(PersonaModel personaModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PersonaModel> listAllPersona() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaModel findPersonaModelById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonaModel findByUsernameWithQuery(String username, String token) {
		 BackendRestInvoker<PersonaModel> restInvoker= new BackendRestInvoker<PersonaModel>(ConstantesURL.SECURITY_SERVER,ConstantesURL.SECURITY_PORT);

		  ResponseEntity<PersonaModel> responseEntity=
				restInvoker.sendGet(ConstantesURL.SECURITY_CONTEXT +"/v1/personas/" + username+"/user" , PersonaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  PersonaModel persona = responseEntity.getBody();
		  return persona;
	}

}
