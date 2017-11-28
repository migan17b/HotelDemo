package pe.com.socialdata.hotel.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;



import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.util.CustomErrorType;

@RestController
@RequestMapping("/v1")
public class CategoriaRC {
	
	private static Logger LOG = Logger.getLogger(CategoriaRC.class);
	
	@Autowired
	CategoriaService categoriaService;
	
	//GET
		@RequestMapping(value="/categorias", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<List<CategoriaModel>> getCategorias(@RequestParam(value="nombre", required=false) String nombre){
			LOG.debug("getCategorias===========================");
			List<CategoriaModel> categorias = new ArrayList<CategoriaModel>();
			
			if (nombre == null) {
				categorias = categoriaService.listAllCategoria();
				if (categorias.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
				}
				LOG.debug(" lista de categorias  "+ categorias.size() );
				return new ResponseEntity<List<CategoriaModel>>(categorias, HttpStatus.OK);
			} else {
				categorias = categoriaService.searchCategoriaByName(nombre);
				if (categorias.isEmpty()) {
					return new ResponseEntity(HttpStatus.NOT_FOUND);
				}
				
				return new ResponseEntity<List<CategoriaModel>>(categorias, HttpStatus.OK);
			}
			
			
		}

		//GET
		@RequestMapping(value="/categorias/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
		public ResponseEntity<CategoriaModel> getCategoriaById(@PathVariable("id") Long idCategoria){
			if (idCategoria == null || idCategoria <= 0) {
				return new ResponseEntity(new CustomErrorType("idCategoria es requerido"), HttpStatus.CONFLICT);
			}
			
			CategoriaModel categoria = categoriaService.findCategoriaModelById(idCategoria);
			if (categoria == null) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.OK);
		}
		
		
		//POST
		@RequestMapping(value="/categorias", method = RequestMethod.POST, headers = "Accept=application/json")
		public ResponseEntity<?> createCategoria(@RequestBody CategoriaModel categoriaModel, UriComponentsBuilder uriComponentsBuilder){
			LOG.debug("createCategoria " + categoriaModel +"=======================================" );
			
			categoriaModel =categoriaService.save(categoriaModel);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(
					uriComponentsBuilder.path("/v1/categorias/{id}")
					.buildAndExpand(categoriaModel.getId())
					.toUri()
					);
			
			return new ResponseEntity<CategoriaModel>(categoriaModel,headers, HttpStatus.CREATED);
		}
		
		//PUT
		@RequestMapping(value="/categorias", method = RequestMethod.PUT, headers = "Accept=application/json")
		public ResponseEntity<CategoriaModel> updateCategoria(@RequestBody CategoriaModel categoriaModel){
			LOG.debug("updateCategoria " + categoriaModel +"=======================================");
			if (categoriaModel.getId() == null || categoriaModel.getId() <= 0) {
				return new ResponseEntity(new CustomErrorType("idCategoria es requerido"), HttpStatus.CONFLICT);
			}
			
			if (categoriaModel.getRowVersion() == null ) {
				return new ResponseEntity(new CustomErrorType("rowVersion es requerido"), HttpStatus.CONFLICT);
			}
			
			CategoriaModel currentCategoria = categoriaService.findCategoriaModelById (categoriaModel.getId());
			if (currentCategoria == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
	
			categoriaModel=categoriaService.save(categoriaModel);
			return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
		}
		
		//DELETE
		@RequestMapping(value="/categorias/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteCategoria(@PathVariable("id") Long idCategoria){
			LOG.debug("deleteCategoria " + idCategoria +"=======================================");
			if (idCategoria == null || idCategoria <= 0) {
				return new ResponseEntity(new CustomErrorType("idCategoria es requerido"), HttpStatus.CONFLICT);
			}
			
			CategoriaModel categoriaModel = categoriaService.findCategoriaModelById(idCategoria);
			if (categoriaModel == null) {
				return new ResponseEntity(HttpStatus.NOT_FOUND);
			}
			
			categoriaService.removeCategoria(idCategoria);
			return new ResponseEntity<CategoriaModel>(HttpStatus.OK);
					
		}
}
