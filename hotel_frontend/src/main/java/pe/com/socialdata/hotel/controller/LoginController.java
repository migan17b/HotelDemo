package pe.com.socialdata.hotel.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.socialdata.hotel.util.ViewConstant;



// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 */
@Controller
public class LoginController {

	/** The Constant LOG. */
	private static final Log   LOG = LogFactory.getLog(LoginController.class);
	
	
	
	/**
	 * Show login form.
	 *
	 * @param model the model
	 * @param error the error
	 * @param logout the logout
	 * @return the string
	 */
	@GetMapping("/login")
	public String showLoginForm( 
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout,
			Model model){
		LOG.info("METHOD 'showLoginForm'-- PARAMS: error= " + error + " - logout="+logout);
		//LOG.info("METHOD 'showLoginForm'-- PARAMS: username= " + username + " - password="+password);
	//	@RequestParam(name="username" )String username,
	//	 @RequestParam(name="password" )String password,
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		
		LOG.info("TEMPLATE: '" +ViewConstant.VIEW_LOGIN   ); 
		return ViewConstant.VIEW_LOGIN;
	}
	
	/**
	 * Login check.
	 *
	 * @return the string
	 */
	@GetMapping({"/loginsuccess","/"})
	public String loginCheck(  ){
		LOG.info("METHOD 'loginCheck'-- PARAMS:' "  + "'");
		
			LOG.info("TEMPLATE: '" +ViewConstant.VIEW_MENU+   "'"  ); 
			return "redirect:/menu/showmenu";
		
		
	}
	
	
	
	
}
