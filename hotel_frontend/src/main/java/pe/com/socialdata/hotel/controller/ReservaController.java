package pe.com.socialdata.hotel.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pe.com.socialdata.hotel.model.ReservaModel;
import pe.com.socialdata.hotel.service.ReservaService;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
@RequestMapping("/reserva")
public class ReservaController {
	
	@Autowired
	ReservaService reservaService;
	private static final Log LOG = LogFactory.getLog(ReservaController.class);

	
	@GetMapping("/reservaform")
	public String reservaForm(@RequestParam(name = "id", required = false) Long id,
			Model model) {
		ReservaModel reservaModel = new ReservaModel();
		if (null!=id){
			reservaModel =reservaService.findReservaModelById(id);
		}
		model.addAttribute("reservaModel", reservaModel);
		

		return ViewConstant.VIEW_RESERVA_FORM;
	}
}
