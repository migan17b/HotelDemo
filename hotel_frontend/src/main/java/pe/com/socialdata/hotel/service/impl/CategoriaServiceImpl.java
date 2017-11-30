package pe.com.socialdata.hotel.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.jasper.ReporteJasperBean;
import pe.com.socialdata.hotel.jasper.ReporteJasperConstantes;
import pe.com.socialdata.hotel.jasper.ReporteJasperUtil;
import pe.com.socialdata.hotel.model.CategoriaModel;


import pe.com.socialdata.hotel.rc.client.util.BackendRestInvoker;
import pe.com.socialdata.hotel.rc.client.util.ConstantesURL;
import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.service.MensajeriaService;


@Service
public class CategoriaServiceImpl  implements CategoriaService {

	private static final Log LOG = LogFactory.getLog(CategoriaServiceImpl.class);
	
	@Autowired
	MensajeriaService mensajeriaService;
	
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
		  ObjectMapper mapper = new ObjectMapper();
		
		 ObjectMapper MAPPER = new ObjectMapper();
		 Gson gson = new Gson();
		 String json = gson.toJson(responseEntity.getBody(),ArrayList.class);
	        List<CategoriaModel> categorias = null;
			try {
				categorias = MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, CategoriaModel.class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  //List<CategoriaModel> categorias =(responseEntity.getBody();;
		   
				 
		  LOG.info("METHOD  fin 'listAllCategoria'" );
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

	@Override
	public ReporteArchivoBean generateEXCEL(String token) {
		LOG.debug("generateEXCEL");
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<List<CategoriaModel>> responseEntity=
				restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias"  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  ObjectMapper mapper = new ObjectMapper();
		 System.out.println( responseEntity.getBody().getClass().getName());
		 ObjectMapper MAPPER = new ObjectMapper();
		 Gson gson = new Gson();
		 String json = gson.toJson(responseEntity.getBody(),ArrayList.class);
	        List<CategoriaModel> categorias = null;
			try {
				categorias = MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, CategoriaModel.class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  LOG.debug("genera reporte"); 
		 /*GENERANDO EL REPORTE==============================================*/
	  	Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	  
	  
	  	parametrosJasper.put("nom_hotel","Melany");

		
	  //	List<HabitacionReporte>listaDataJasper = new ArrayList<HabitacionReporte>();
	  	List<Map<String , Object>> listaDataJasper = new ArrayList<Map<String , Object>>();
	  	for (CategoriaModel obj : categorias) {
	  		LOG.debug("===========================================");
	  		
	  	
		
	
			
	  		Map<String , Object> cat = new HashMap<String , Object>();
	  		cat.put("id", obj.getId().toString());
			cat.put("nombre", obj.getNombre());
			cat.put("precio", obj.getPrecio().toString());
			
			
	  		
	  		listaDataJasper.add(cat);
	  		LOG.debug(cat);
	  	}
	  	
	  	ReporteJasperBean reporteJasperBean = new ReporteJasperBean();
		reporteJasperBean.setParametros(parametrosJasper);
		reporteJasperBean.setListaDetalle(listaDataJasper);
		reporteJasperBean.setFileName(ReporteJasperConstantes.PLANILLA_CATEGORIA_XLS);
		reporteJasperBean.setJasperName( ReporteJasperConstantes.PLANILLA_CATEGORIA_JASPER_XLS );
		
		  LOG.debug("generaR jasper");
		ReporteArchivoBean reporteArchivoBean = ReporteJasperUtil.generarArchivoExcel     (reporteJasperBean, ReporteJasperConstantes.RUTA_JASPER, ReporteJasperConstantes.RUTA_EXCEL);
			
		return reporteArchivoBean;
	}
	
	
	@Override
	public void sendMail(String token, String mail) {
		LOG.debug("generateEXCEL");
		 BackendRestInvoker<CategoriaModel> restInvoker= new BackendRestInvoker<CategoriaModel>(ConstantesURL.BACKEND_SERVER,ConstantesURL.BACKEND_PORT);

		  ResponseEntity<List<CategoriaModel>> responseEntity=
				restInvoker.sendGetList(ConstantesURL.BACKEND_CONTEXT +"/v1/categorias"  , CategoriaModel.class, token);
		
		 // responseEntity.getStatusCode() 
		  ObjectMapper mapper = new ObjectMapper();
		 System.out.println( responseEntity.getBody().getClass().getName());
		 ObjectMapper MAPPER = new ObjectMapper();
		 Gson gson = new Gson();
		 String json = gson.toJson(responseEntity.getBody(),ArrayList.class);
	        List<CategoriaModel> categorias = null;
			try {
				categorias = MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, CategoriaModel.class));
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		  LOG.debug("genera reporte"); 
		 /*GENERANDO EL REPORTE==============================================*/
	  	Map<String, Object> parametrosJasper = new HashMap<String, Object>();
	  
	  
	  	parametrosJasper.put("nom_hotel","Melany");

		
	  //	List<HabitacionReporte>listaDataJasper = new ArrayList<HabitacionReporte>();
	  	List<Map<String , Object>> listaDataJasper = new ArrayList<Map<String , Object>>();
	  	for (CategoriaModel obj : categorias) {
	  		LOG.debug("===========================================");
	  		
	  	
		
	
			
	  		Map<String , Object> cat = new HashMap<String , Object>();
	  		cat.put("id", obj.getId().toString());
			cat.put("nombre", obj.getNombre());
			cat.put("precio", obj.getPrecio().toString());
			
			
	  		
	  		listaDataJasper.add(cat);
	  		LOG.debug(cat);
	  	}
	  	
	  	ReporteJasperBean reporteJasperBean = new ReporteJasperBean();
		reporteJasperBean.setParametros(parametrosJasper);
		reporteJasperBean.setListaDetalle(listaDataJasper);
		reporteJasperBean.setFileName(ReporteJasperConstantes.PLANILLA_CATEGORIA_PDF);
		reporteJasperBean.setJasperName( ReporteJasperConstantes.PLANILLA_CATEGORIA_JASPER_RPT );
		
		  LOG.debug("generaR jasper");
		ReporteArchivoBean reporteArchivoBean = ReporteJasperUtil.generarArchivoPDF    (reporteJasperBean, ReporteJasperConstantes.RUTA_JASPER, ReporteJasperConstantes.RUTA_PDF);
		LOG.debug(">>>>>>>>>>>>>>>getFieldNamePath>>>>>>>>>>>>" + reporteArchivoBean.getFieldNamePath() );	
		LOG.debug(">>>>>>>>>>getFieldName>>>>>>>>>>>>>>>>>>" + reporteArchivoBean.getFieldName() );
		
		mensajeriaService.sendCategorias(mail, reporteArchivoBean.getFieldName());
	}

}
