package pe.com.socialdata.hotel.service.impl;


import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.model.MenuDTO;
import pe.com.socialdata.hotel.model.PerfilModel;

import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;

import pe.com.socialdata.hotel.service.PerfilService;

@Service
public class PerfilServiceImpl  implements PerfilService{
	private static Logger log = Logger.getLogger(PerfilServiceImpl.class);
	@Override
	public MenuDTO findPerfilByRol(String rol,String token) {
		MenuDTO menu = new MenuDTO();
		log.debug("findPerfilByRol=========================================");
		log.debug("token:"+token);
		//GENERANDO TOKEN LOGIN CON SERVICIO SECURITY==============
		 BackendRestInvoker<PerfilModel> restInvoker= new BackendRestInvoker<PerfilModel>(ConstantesURL.SECURITY_SERVER,ConstantesURL.SECURITY_PORT);

		
		  ResponseEntity<List<PerfilModel>> responseEntity=
				  restInvoker.sendGetList(ConstantesURL.SECURITY_CONTEXT +"/v1/perfiles/"+rol , PerfilModel.class,token);
				

		  List<PerfilModel >menusList = (List<PerfilModel >)responseEntity.getBody();
		  System.out.println(" zise " + menusList.size() );
		
				responseEntity= restInvoker.sendGetList(ConstantesURL.SECURITY_CONTEXT +"/v1/perfiles/"+rol+"/module/" + 8 , PerfilModel.class,token);
				 List<PerfilModel>maestros = responseEntity.getBody();
				 menu.setMaestros(maestros);
		
		  menu.setMenus(menusList);
		  
		  return menu;
	}

	/*
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	PerfilConvert perfilConvert;
	
	private static final Log LOG = LogFactory.getLog(PerfilServiceImpl.class);
	@Override
	public List<PerfilModel> findPerfilByRol(String rol) {
		LOG.debug("INCIA findPerfilByRol");
		List<PerfilModel> perfilesModel = new ArrayList<PerfilModel>();
		List<Perfil> perfiles =perfilRepository.findByRolWithQuery(rol);
		
		for( Perfil obj : perfiles ) {
			PerfilModel  perfilModel = perfilConvert.convertPerfil2PerfilModel( obj );
			perfilesModel.add(perfilModel);
		}
		LOG.debug("FIN findPerfilByRol");
		return perfilesModel;
		
	}*/

	
}
