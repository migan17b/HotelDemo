package pe.com.socialdata.hotel.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.com.socialdata.hotel.controller.CategoriaController;
import pe.com.socialdata.hotel.model.CategoriaModel;

import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;
import pe.com.socialdata.hotel.service.CategoriaService;

@Service
public class CategoriaServiceImpl  implements CategoriaService {

	private static final Log LOG = LogFactory.getLog(CategoriaServiceImpl.class);
	
	@Override
	public CategoriaModel add(CategoriaModel categoriaModel,String  token) {
		LOG.debug(" add " + categoriaModel+"=======================================" );
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER ,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<CategoriaModel> responseEntity=
				restInvoker.sendPost(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias"  ,categoriaModel, CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  CategoriaModel categoria = responseEntity.getBody();
		  return categoria;
	}

	@Override
	public CategoriaModel save(CategoriaModel categoriaModel,String  token) {
		LOG.debug(" save " + categoriaModel+"=======================================" );
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<CategoriaModel> responseEntity=
				restInvoker.sendPatch(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias"  ,categoriaModel, CategoriaModel.class, token);
		
		 LOG.debug("getStatusCode" + responseEntity.getStatusCode() );
		 //LOG.debug("getStatusCode" + responseEntity.getHeaders().get );
		 
		  CategoriaModel categoria = responseEntity.getBody();
		  return categoria;
	}

	@Override
	public List<CategoriaModel> listAllCategoria(String  token) {
		LOG.info("METHOD 'listAllCategoria'");
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<List<CategoriaModel>> responseEntity=
				restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias"  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  
		  List<CategoriaModel> categorias = responseEntity.getBody();
		  LOG.info("METHOD  fin 'listAllCategoria'" + categorias.size());
		  return categorias;
	}

	@Override
	public CategoriaModel findCategoriaModelById(Long id,String  token) {
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<CategoriaModel> responseEntity=
				restInvoker.sendGet(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias/"+ id  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  CategoriaModel categoria = responseEntity.getBody();
		  return categoria;
	}

	@Override
	public void removeCategoria(Long id,String  token) {
		LOG.info("METHOD 'removeCategoria' ====================================================");
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<CategoriaModel> responseEntity=
				restInvoker.sendDelete(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias/"+ id  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  CategoriaModel categoria = responseEntity.getBody();
		 
		
	}

	@Override
	public List<CategoriaModel> searchCategoriaByName(String name,String  token) {
		LOG.info("METHOD 'searchCategoriaByName :' " +name);
		BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<List<CategoriaModel>> responseEntity=
				restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias?nombre="+name  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  
		  List<CategoriaModel> categorias = responseEntity.getBody();
		  LOG.info("METHOD  fin 'searchCategoriaByName'" + categorias.size());
		  return categorias;
	}

}
