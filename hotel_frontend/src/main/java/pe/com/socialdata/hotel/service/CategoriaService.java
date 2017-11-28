package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.model.CategoriaModel;


public interface CategoriaService {

	public abstract CategoriaModel add(CategoriaModel categoriaModel, String token);
	public abstract CategoriaModel save(CategoriaModel categoriaModel, String token);
	
	public List<CategoriaModel> listAllCategoria(String token);
	
	public abstract CategoriaModel findCategoriaModelById(Long id, String token);
	
	public abstract void removeCategoria(Long id, String token);
	
	public List<CategoriaModel> searchCategoriaByName(String name, String token);
	
	public ReporteArchivoBean generateEXCEL( String token) ;
	
	public void sendMail(String token,  String mail) ;
}
