package pe.com.socialdata.hotel.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import pe.com.socialdata.hotel.jasper.HabitacionReporte;
import pe.com.socialdata.hotel.jasper.ReporteArchivoBean;
import pe.com.socialdata.hotel.model.HotelModel;
import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.service.HotelService;
import pe.com.socialdata.hotel.util.ConstantesHotel;
import pe.com.socialdata.hotel.util.FormatoConstantes;
import pe.com.socialdata.hotel.util.ResourceBundleUtil;
import pe.com.socialdata.hotel.util.ServiceException;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService; 
	private static final Log LOG = LogFactory.getLog(HotelController.class);
	

	@PostMapping("/addhotel")
	public String addHotel(@ModelAttribute(name="hotelModel")HotelModel hotelModel, Model model, @SessionAttribute("userSession") UserModel userSession   ) {
		String codigoOperacion = FormatoConstantes.ERROR_OPERACION;
		String errorMessage = FormatoConstantes.CADENA_VACIA;
		LOG.info("METHOD 'addHotel'-- PARAMS:' " + hotelModel );
		try {
			String token=userSession.getToken();
			hotelModel= hotelService.save(hotelModel,  token);
			if (null !=hotelModel) {
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
		

		LOG.info("TEMPLATE: '" + ViewConstant.VIEW_HOTEL_FORM + "' -- DATA :'" + hotelModel + "' ");
		return "redirect:/hotel/showhoteles";
	}

	@GetMapping("/showhoteles")
	public ModelAndView showhoteles( @SessionAttribute("userSession") UserModel userSession) {
		LOG.info("METHOD 'showhoteles'");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_HOTELES);
		String token=userSession.getToken();
		
		mav.addObject("hoteles", hotelService.listAllHotel(token));
		return mav;
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/hotel/showhoteles";
	}
	
	
	@GetMapping("/hotelform")
	public String hotelform(@RequestParam(name = "id", required = false) Long id,
			Model model,@SessionAttribute("userSession") UserModel userSession) {
		LOG.info("METHOD 'hotelform'-- PARAMS:' " + id );
		String token=userSession.getToken();
		HotelModel hotelModel = new HotelModel();
		//TODO CAMBIAR PARA OBTENER LA EMPRESA  DE SESION
		hotelModel.setIdEmpresa(userSession.getIdEmpresa() );
		//hotelModel.setIdEmpresa(1);
		LOG.debug("id " +  id);
		if (null!=id){
			hotelModel =hotelService.findHotelModelById(id,token);
		}
		model.addAttribute("hotelModel", hotelModel);
		
		LOG.info("METHOD 'hotelform':' Fin");
		return ViewConstant.VIEW_HOTEL_FORM;
	}

	@GetMapping("/removehotel")
	public ModelAndView removehotel(@RequestParam(name = "id", required = true) Long id, @SessionAttribute("userSession") UserModel userSession) {
		LOG.info("METHOD 'removehotel'-- PARAMS:' " + id + "'");
		String token="s";
		hotelService.removeHotel(id,token);
		return showhoteles(userSession);
	}
	
	
	@GetMapping("/hotelreport")
	public ModelAndView hotelReporte(@RequestParam(name = "id", required = false) Long id,
			Model model,@SessionAttribute("userSession") UserModel userSession,  HttpServletResponse response) {
		LOG.info("METHOD 'hotelform'-- PARAMS:' " + id );
		ModelAndView modelAndView = null;
		String token=userSession.getToken();
		HotelModel hotelModel = new HotelModel();
		//TODO CAMBIAR PARA OBTENER LA EMPRESA  DE SESION
		hotelModel.setIdEmpresa(userSession.getIdEmpresa() );
		//hotelModel.setIdEmpresa(1);
		LOG.debug("id " +  id);
		if (null!=id){
			ReporteArchivoBean reporteArchivoBean =hotelService.generatePDF(id, token);
			
			
			
			if (reporteArchivoBean == null) {
				
			}
		
			//setAuditoriaBeanHolder(request, response);

			// setear el response y escribir los bytes del pdf
			byte[] dataBytes = reporteArchivoBean.getData();

			String nombreArchivoPDF = reporteArchivoBean.getFieldName();

			response.setContentType("application/pdf"); // response
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

			
		}
		
		
		LOG.info("METHOD 'hotelform':' Fin");
		return modelAndView;
	}
	
	
	@GetMapping("/hotelreport2")
	public String hotelReporte2(@RequestParam(name = "id", required = false) Long id,
			Model model,@SessionAttribute("userSession") UserModel userSession) {
		LOG.info("METHOD 2222222222222222222222 'hotelform'-- PARAMS:' " + id );
		String token=userSession.getToken();
		HotelModel hotelModel = new HotelModel();
		//TODO CAMBIAR PARA OBTENER LA EMPRESA  DE SESION
		hotelModel.setIdEmpresa(userSession.getIdEmpresa() );
		//hotelModel.setIdEmpresa(1);
		LOG.debug("id " +  id);
		List<HabitacionReporte> habitaciones=null;
		if (null!=id){
			hotelModel =hotelService.findHotelModelById(id,token);
			
			 habitaciones = hotelService.habitacionToReporte(hotelModel.getHabitaciones());
			
		}
		model.addAttribute("hotelModel", hotelModel);
		
		LOG.info("METHOD 'hotelform':' Fin");
		 model.addAttribute("format", "pdf");
	        model.addAttribute("datasource",habitaciones);
	        model.addAttribute("nombre", hotelModel.getNombre());
	        model.addAttribute("direccion", hotelModel.getDireccion());
	        return "habitaciones_report";
	}

	
}
