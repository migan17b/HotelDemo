package pe.com.socialdata.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.entity.Categoria;

import pe.com.socialdata.hotel.model.CategoriaModel;

import pe.com.socialdata.hotel.model.convert.CategoriaConvert;

import pe.com.socialdata.hotel.repository.CategoriaRepository;

import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;

@Service("categoriaService")
public class CategoriaServiceImpl  implements CategoriaService{

private static Log LOG = LogFactory.getLog(EmpresaServiceImpl.class);
	
	@Autowired
	CategoriaRepository  categoriaRepository;
	
	@Autowired
	CategoriaConvert 		categoriaConvert;
	
	@Override
	public CategoriaModel save(CategoriaModel categoriaModel) {
		LOG.debug("inicia  save");
		try {
			Categoria categoria = categoriaConvert.convertCategoriaModel2Categoria(categoriaModel);
			
			categoria=categoriaRepository.save(categoria);
			categoriaModel = categoriaConvert.convertCategoria2CategoriaModel(categoria);
			
		
		} catch (Exception ex) {
			//LOG.error(ex.getMessage(), ex);
			throw new ServiceException(this, ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO));
		}
		finally{
			LOG.debug("Fin save");
		}
		
		return categoriaModel;
	}

	@Override
	public List<CategoriaModel> listAllCategoria() {
		LOG.debug("listAllCategoria ===============");
		
		List<Categoria> categorias = categoriaRepository.findAll();
		LOG.debug("categorias BD ===============" + categorias.size());
		List<CategoriaModel> categoriasModel = new ArrayList<CategoriaModel>();
		
		for(Categoria obj : categorias) {
			categoriasModel.add( categoriaConvert.convertCategoria2CategoriaModel(obj));
		}
		
		return categoriasModel;
	}

	@Override
	public CategoriaModel findCategoriaModelById(Long id) {
		return	categoriaConvert.convertCategoria2CategoriaModel (categoriaRepository.findById(id));
	}

	@Override
	public void removeCategoria(Long id) {
		Categoria categoria =categoriaRepository.findById(id);
		if (null !=categoria) {
			categoriaRepository.delete(categoria);
		}else {
			LOG.warn("categoria no existe!");
		}
		
	}

	@Override
	public List<CategoriaModel> searchCategoriaByName(String name) {
		List<CategoriaModel> lista = new ArrayList<CategoriaModel>();
		CategoriaModel categoria = categoriaConvert.convertCategoria2CategoriaModel (categoriaRepository.findByNombreLike("%"+name+"%"));
		lista.add(categoria);
		return lista;
	}

}
