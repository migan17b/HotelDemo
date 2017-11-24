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
import org.springframework.web.servlet.ModelAndView;


import pe.com.socialdata.hotel.model.EmpresaModel;

import pe.com.socialdata.hotel.service.EmpresaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.FormatoConstantes;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller()
@RequestMapping("/empresa")
public class EmpresaController {
	
	/*
	@Autowired
	private EmpresaService empresaService;
	
	private static final Log LOG = LogFactory.getLog(EmpresaController.class);
	
	@PostMapping("/addempresa")
	public String addEmpresa(@ModelAttribute(name="empresaModel")EmpresaModel empresaModel, Model model  ) {
		String codigoOperacion = FormatoConstantes.ERROR_OPERACION;
		String errorMessage = FormatoConstantes.CADENA_VACIA;
		LOG.info("METHOD 'addempresa'-- PARAMS:' " + empresaModel );
		try {
			empresaModel= empresaService.save(empresaModel);
			if (null !=empresaModel) {
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
		

		LOG.info("TEMPLATE: '" + ViewConstant.VIEW_EMPRESA_FORM + "' -- DATA :'" + empresaModel + "' ");
		return "redirect:/empresa/showempresas";
	}
	
	@GetMapping("/showempresas")
	public ModelAndView showempresas() {
		LOG.info("METHOD 'showempresas'");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_EMPRESAS);
	
		
		mav.addObject("empresas", empresaService.listAllEmpresa());
		return mav;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/empresa/showempresas";
	}
	
	
	@GetMapping("/empresaform")
	public String empresaform(@RequestParam(name = "id", required = false) Integer id,
			Model model) {
		EmpresaModel empresaModel = new EmpresaModel();
		LOG.debug("id " +  id);
		if (null!=id){
			empresaModel =empresaService.findEmpresaModelById(id);
		}
		model.addAttribute("empresaModel", empresaModel);
		

		return ViewConstant.VIEW_EMPRESA_FORM;
	}

	@GetMapping("/removeempresa")
	public ModelAndView removeempresa(@RequestParam(name = "id", required = true) Integer id) {
		LOG.info("METHOD 'removeempresa'-- PARAMS:' " + id + "'");
		empresaService.removeEmpresa(id);
		return showempresas();
	}
	*/
}
