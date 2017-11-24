package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.model.PerfilModel;


public interface PerfilService {
	
	public  List<PerfilModel> findPerfilByRol(String rol)   ;
	public  List<PerfilModel> findPerfilByRolandModule(String rol, Long idModule)   ;

}
