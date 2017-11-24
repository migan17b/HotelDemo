package pe.com.socialdata.hotel.service;

import java.util.List;

import pe.com.socialdata.hotel.model.CategoriaModel;


public interface CategoriaService {

	public abstract CategoriaModel save(CategoriaModel categoriaModel);
	
	public List<CategoriaModel> listAllCategoria();
	
	public abstract CategoriaModel findCategoriaModelById(Long id);

	
	public abstract void removeCategoria(Long id);
	
	public List<CategoriaModel> searchCategoriaByName(String name);
	
	
}
