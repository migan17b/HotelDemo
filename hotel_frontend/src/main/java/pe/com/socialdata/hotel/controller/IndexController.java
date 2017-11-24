package pe.com.socialdata.hotel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.MenuDTO;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
public class IndexController {
	
	private static final Log   LOG = LogFactory.getLog(IndexController.class);
	@Autowired
	CategoriaService categoriaService;
	@GetMapping("/index")
	public String index() {
		LOG.debug("INDEX LOAD ");
		return "index";
	}
	
	@RequestMapping(value="/indexcategorias",consumes=   {"application/JSON"} ,produces = {"application/JSON"}, method= RequestMethod.POST   )
	@ResponseBody
	@CrossOrigin
	public List<CategoriaModel> indexcategorias(@RequestBody CategoriaModel categoriaModel) {
		LOG.info("METHOD 'indexcategorias'");
		System.out.println( categoriaModel.getNombre());
		
		String token="eyJraWQiOiJteS1rZXktaWQiLCJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUxMTU2MDM2OH0.Hi0XgaiAPfHgzX5VQqTKxP413WpDUHIhgbCJ_UVCivu1gdQCiMNnCxtWQ4DUu2bU1bUAFtS7RzESFa1pcruA2MW9oI2wumbstpragJj76HUh4xsGVRFKHtxR0J1qNrJuC9B5CHxZHTmwG96NXY7hnHH4mzAG3nxQdiPAjkcusdxNYzj26NfZX2VbVjTJCML4hOV9AXxTFVx9QV48R53462E5iULwO5EQo2K_zvzkcUon3keeTgNb5vWSV3bUXLnHLT4UxKRDMYeN-__PDqTff16A9t7qt126Fi0M9BBNnnS5rxx91oNk14kSlR3GBhOHTCzxhqoG49UJJmwBC85EKg";
		
		return categoriaService.searchCategoriaByName(categoriaModel.getNombre(),token);
	}
}
