package pe.com.socialdata.hotel.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Perfil;
import pe.com.socialdata.hotel.model.PerfilModel;
import pe.com.socialdata.hotel.model.convert.PerfilConvert;
import pe.com.socialdata.hotel.repository.PerfilRepository;
import pe.com.socialdata.hotel.service.PerfilService;

@Service
public class PerfilServiceImpl  implements PerfilService{

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
		
	}

	@Override
	public List<PerfilModel> findPerfilByRolandModule(String rol, Long idModule) {
		LOG.debug("INCIA findPerfilByRol");
		List<PerfilModel> perfilesModel = new ArrayList<PerfilModel>();
		List<Perfil> perfiles =perfilRepository.findByRolandModuleWithQuery(rol, idModule);
		
		for( Perfil obj : perfiles ) {
			PerfilModel  perfilModel = perfilConvert.convertPerfil2PerfilModel( obj );
			perfilesModel.add(perfilModel);
		}
		LOG.debug("FIN findPerfilByRol");
		return perfilesModel;
		
	}

}
