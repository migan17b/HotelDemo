package pe.com.socialdata.hotel.config;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import pe.com.socialdata.hotel.repository.LogContext;



@Component("requestTimeInterceptor")
public class RequestTimeInterceptor  extends HandlerInterceptorAdapter{
	

	
	private static final Log   LOGGER = LogFactory.getLog(RequestTimeInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGER.info("=========preHandle===============================" );
		request.setAttribute("startTime", System.currentTimeMillis());
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String username ="";
		if (null!= auth && auth.isAuthenticated()){
			username = auth.getName();
		}
		LogContext.setUserId(username);
		
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime =(long) request.getAttribute("startTime");
		String url=request.getRequestURL().toString();
		Authentication auth= SecurityContextHolder.getContext().getAuthentication();
		String username ="";
		if (null!= auth && auth.isAuthenticated()){
			username = auth.getName();
		}
		
		
		LOGGER.info("URL to :' " + url+  "' in: '" +(System.currentTimeMillis() - startTime) +"' ms" );
	}

	

}
