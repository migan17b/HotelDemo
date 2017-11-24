package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.model.MenuDTO;



public interface PerfilService {
	
	public  MenuDTO findPerfilByRol(String rol, String token)   ;

}
