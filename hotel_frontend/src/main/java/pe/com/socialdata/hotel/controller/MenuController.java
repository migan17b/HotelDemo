package pe.com.socialdata.hotel.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.com.socialdata.hotel.model.MenuDTO;
import pe.com.socialdata.hotel.model.PerfilModel;
import pe.com.socialdata.hotel.model.PersonaModel;
import pe.com.socialdata.hotel.model.UserModel;
import pe.com.socialdata.hotel.repository.LogContext;
import pe.com.socialdata.hotel.service.PerfilService;
import pe.com.socialdata.hotel.service.PersonaService;
import pe.com.socialdata.hotel.util.ViewConstant;

@Controller
@RequestMapping("/menu")
@SessionAttributes({"userSession","menuSession"})
public class MenuController {
	
	private static final Log   LOG = LogFactory.getLog(MenuController.class);
	
	@Autowired
	PerfilService perfilService;
	
	@Autowired
	PersonaService personaService;
	
	
	
	@GetMapping("/showmenu")
	public ModelAndView showmenu(@AuthenticationPrincipal User user, Authentication authentication) {
		LOG.debug("=======INCIA showmenu neweee============================================");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_MENU);
		String username =user.getUsername();
		String token="";
		MenuDTO menu=null;
	
		LogContext.setUserId(user.getUsername());
		for(GrantedAuthority o : authentication.getAuthorities()) {
			System.out.println("rol:"+o.getAuthority().substring(0, 5));
			if (o.getAuthority().substring(0, 5).equals("token")) {
				String tokens[] =o.getAuthority().split(":");
				token=tokens[1];
				System.out.println("token:"+ token);
			}
			
			
			
		}
		for(GrantedAuthority o : authentication.getAuthorities()) {
			System.out.println("rol:"+o.getAuthority().substring(0, 5));
			if (!o.getAuthority().substring(0, 5).equals("token")) {
			
				 menu =perfilService.findPerfilByRol(o.getAuthority(),token);
				LOG.debug("ROLES: " +  o.getAuthority());
			}
			
			
			
		}
		PersonaModel persona= personaService.findByUsernameWithQuery(username,token);
		UserModel userSession = new UserModel(username, persona.getFullName(),persona.getCorreo(), persona.getIdEmpresa(),token );
	
		
		
		mav.addObject("userSession", userSession);
		mav.addObject("menuSession", menu);
		
		LOG.debug("=======FIN showmenu============================================");
		return mav;
	}

	
	
	@GetMapping("/showmaestros")
	public ModelAndView showmaestros(@SessionAttribute("userSession") UserModel userSession,
			@SessionAttribute("menuSession") MenuDTO menuSession) {
		LOG.debug("=======INCIA showmaestros neweee============================================");
		ModelAndView mav = new ModelAndView(ViewConstant.VIEW_MAESTROS);
		
	
	
		
		
		
		mav.addObject("userSession", userSession);
		mav.addObject("menuSession", menuSession);
		
		LOG.debug("=======FIN showmaestros============================================");
		return mav;
	}

}
