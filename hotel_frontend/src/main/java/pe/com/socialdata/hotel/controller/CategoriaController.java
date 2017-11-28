package pe.com.socialdata.hotel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.com.socialdata.hotel.jasper.HabitacionReporte;
import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.model.CategoriaModel;
import pe.com.socialdata.hotel.model.CorreoModel;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.MenuDTO;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.service.CategoriaService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.FormatoConstantes;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	
	@Autowired
	CategoriaService categoriaService;
	
	private static final Log LOG = LogFactory.getLog(CategoriaController.class);
	
	
	@PostMapping("/addcategoria")
	public String addcategoria(@ModelAttribute(name="categoriaModel")CategoriaModel categoriaModel, Model model ,
			@SessionAttribute("userSession") UserModel userSession) {
		String codigoOperacion = FormatoConstantes.ERROR_OPERACION;
		String errorMessage = FormatoConstantes.CADENA_VACIA;
		LOG.info("METHOD 'addcategoria'-- PARAMS:' " + categoriaModel +"=======================================");
		try {
			if (categoriaModel.getId() == null || categoriaModel.getId()==0) {
				categoriaModel= categoriaService.add(categoriaModel, userSession.getToken());
			}else {
				categoriaModel= categoriaService.save(categoriaModel, userSession.getToken());
			}
			
			if (null !=categoriaModel) {
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
		

		LOG.info("TEMPLATE: '" + ViewConstant.VIEW_CATEGORIA_FORM + "' -- DATA :'" + categoriaModel + "' ");
		return "redirect:/categoria/showcategorias";
	}

	@GetMapping("/showcategorias")
	public ModelAndView showcategorias(@SessionAttribute("userSession") UserModel userSession,
			@SessionAttribute("menuSession") MenuDTO menuSession) {
		LOG.info("METHOD 'showcategorias'");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_CATEGORIAS);
	
		CorreoModel correoModel= new CorreoModel();
		
		mav.addObject("categorias", categoriaService.listAllCategoria(userSession.getToken()));
		mav.addObject("correoModel", correoModel);
		mav.addObject("userSession", userSession);
		mav.addObject("menuSession", menuSession);
		
		return mav;
	}
	
	@RequestMapping(value="/searchcategorias",consumes=   {"application/JSON"} ,produces = {"application/JSON"}, method= RequestMethod.POST  )
	@ResponseBody
	public List<CategoriaModel> searchcategorias(@SessionAttribute("userSession") UserModel userSession,
			@RequestBody CategoriaModel categoriaModel) {
		LOG.info("METHOD 'searchcategorias'");
		
		return categoriaService.searchCategoriaByName(categoriaModel.getNombre(),userSession.getToken());
		
	}
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/categoria/showcategorias";
	}
	
	
	@GetMapping("/categoriaform")
	public String categoriaform(@RequestParam(name = "id", required = false) Long id,
			Model model , @SessionAttribute("userSession") UserModel userSession,
			@SessionAttribute("menuSession") MenuDTO menuSession) {
		CategoriaModel categoriaModel = new CategoriaModel();
		LOG.debug("id " +  id);
		if (null!=id){
			categoriaModel =categoriaService.findCategoriaModelById(id,userSession.getToken());
		}
		model.addAttribute("categoriaModel", categoriaModel);
		model.addAttribute("userSession", userSession);
		model.addAttribute("menuSession", menuSession);

		return ViewConstant.VIEW_CATEGORIA_FORM;
	}

	@GetMapping("/removecategoria")
	public ModelAndView removecategoria(@RequestParam(name = "id", required = true) Long id,@SessionAttribute("userSession") UserModel userSession,
			@SessionAttribute("menuSession") MenuDTO menuSession) {
		LOG.info("METHOD 'removecategoria'-- PARAMS:' " + id + "' =====================================");
		categoriaService.removeCategoria(id,userSession.getToken());
		return showcategorias(userSession, menuSession);
	}
	
	@GetMapping("/categoriareport")
	public String categoriareport(
			Model model,@SessionAttribute("userSession") UserModel userSession) {
		LOG.info("METHOD categoriareport 'categoriaform'-- PARAMS:' "  );
		String token=userSession.getToken();
		CategoriaModel categoriaModel = new CategoriaModel();
		
		
		List<CategoriaModel> categorias=null;
	
		categorias =categoriaService.listAllCategoria(token);
		List<Map <String,Object>> listaCategorias = new ArrayList<>(); 
		
			    
		for (int i =0 ; i < categorias.size(); i++) {
			Map<String , Object> cat = new HashMap<>();
			cat.put("id", categorias.get(i).getId().toString());
			cat.put("nombre", categorias.get(i).getNombre());
			cat.put("precio", categorias.get(i).getPrecio().toString());
			listaCategorias.add(cat);
		}
		
		model.addAttribute("categoriaModel", categoriaModel);
		
		LOG.info("METHOD 'categoriaform':' Fin");
		 model.addAttribute("format", "pdf");
	        model.addAttribute("datasource",listaCategorias);
	        model.addAttribute("nom_hotel", "MELANY");
	   
	        return "categorias_report";
	}

	
	@GetMapping("/categoriaexcel")
	public ModelAndView categoriaexcel(
			Model model,@SessionAttribute("userSession") UserModel userSession,  HttpServletResponse response) {
		LOG.info("METHOD 'categoriaexcel'' "  );
		ModelAndView modelAndView = null;
		String token=userSession.getToken();
		CategoriaModel categoriaModel = new CategoriaModel();
		
		
			ReporteArchivoBean reporteArchivoBean =categoriaService.generateEXCEL( token);
			
			
			
			if (reporteArchivoBean == null) {
				
			}
		
			//setAuditoriaBeanHolder(request, response);

			// setear el response y escribir los bytes del pdf
			byte[] dataBytes = reporteArchivoBean.getData();

			String nombreArchivoPDF = reporteArchivoBean.getFieldName();

			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.‌​sheet"); // response
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nombreArchivoPDF + "\";");
			response.setHeader("Cache-Control", "public");
			response.setHeader("Pragma", "public");
			response.setDateHeader("Expires", 0);
			response.setContentLength(dataBytes.length);

			ServletOutputStream ouputStream;
			try {
				ouputStream = response.getOutputStream();
				ouputStream.write(dataBytes, 0, dataBytes.length);
				ouputStream.flush();
				ouputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		
		
		LOG.info("METHOD 'categoriaexcel':' Fin");
		return modelAndView;
	}
	
	
	@PostMapping("/sendmail")
	public ModelAndView sendmail(@ModelAttribute(name="correoModel")CorreoModel correoModel ,@SessionAttribute("userSession") UserModel userSession,
			@SessionAttribute("menuSession") MenuDTO menuSession) {
		LOG.info("METHOD 'showcategorias'");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_CATEGORIAS);
		LOG.debug("coorreeeooo:" + correoModel.getEmail());
		
		categoriaService.sendMail(userSession.getToken(), correoModel.getEmail());
		mav.addObject("categorias", categoriaService.listAllCategoria(userSession.getToken()));
		
		mav.addObject("correoModel", correoModel);
		mav.addObject("userSession", userSession);
		mav.addObject("menuSession", menuSession);
		return mav;
	}
}
