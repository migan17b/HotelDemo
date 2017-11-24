package pe.com.socialdata.hotel.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.service.PersonaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.FormatoConstantes;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	private static final Log LOG = LogFactory.getLog(PersonaController.class);
	/*
	@Autowired
	PersonaService personaService;

	@PostMapping("/addpersona")
	public String addpersona(@ModelAttribute(name="personaModel")PersonaModel personaModel, Model model,
			@SessionAttribute("personaSession") PersonaModel personaSession) {
		String codigoOperacion = FormatoConstantes.ERROR_OPERACION;
		String errorMessage = FormatoConstantes.CADENA_VACIA;
		LOG.info("METHOD 'addpersona'-- PARAMS:' " + personaModel );
		try {
			if (null ==personaModel.getId()) {
				LOG.debug("idempresa " +  personaSession.getIdEmpresa());
				personaModel.setIdEmpresa(personaSession.getIdEmpresa() );
				personaModel= personaService.addTrabajador(personaModel);	
			}else {
				personaModel= personaService.updateTrabajador(personaModel);
			}
			
			if (null !=personaModel) {
				codigoOperacion = FormatoConstantes.EXITO_OPERACION;
			} else {
				codigoOperacion = FormatoConstantes.ERROR_OPERACION;
			}
		} catch (ServiceException ex) {
			LOG.error(ex.getMessage(), ex);
			codigoOperacion = FormatoConstantes.ERROR_OPERACION;
			errorMessage = ex.getMessage();

		} catch (Exception ex) {
			LOG.error(ex.getMessage(), ex);
			codigoOperacion = FormatoConstantes.ERROR_OPERACION;
			errorMessage = ResourceBundleUtil.getMessage(ConstantesHotel.MENSAJE_ERROR_GENERICO)  + " : " + ex.getMessage();
		}finally {
			model.addAttribute("codigoOperacion", codigoOperacion);
			model.addAttribute("errorMessage", errorMessage);
		}
		

		LOG.info("TEMPLATE: '" + ViewConstant.VIEW_PERSONA_FORM + "' -- DATA :'" + personaModel + "' ");
		return "redirect:/persona/showpersonas";
	}
	
	@GetMapping("/showpersonas")
	public ModelAndView showpersonas() {
		LOG.info("METHOD 'showpersonas'");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_PERSONAS);
	
		
		mav.addObject("personas", personaService.listAllPersona());
		return mav;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/persona/showpersonas";
	}
	
	
	@GetMapping("/personaform")
	public String personaform(@RequestParam(name = "id", required = false) Long id,
			Model model  ) {
		PersonaModel personaModel = new PersonaModel();
		LOG.debug("id " +  id);
		
		if (null!=id){
			personaModel =personaService.findPersonaModelById(id);
		}
		model.addAttribute("personaModel", personaModel);
		

		return ViewConstant.VIEW_PERSONA_FORM;
	}
*/
}
