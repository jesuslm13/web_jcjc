package jcjc.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import jcjc.user.entity.User;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(log.isInfoEnabled()) {
//			User user = (User)request.getAttribute("user");
			
//			if(request.getRequestURI().equals("/jcjc/politician/type.do") 
//					|| request.getRequestURI().equals("/jcjc/user/login.do") 
//					|| request.getRequestURI().equals("/jcjc/user/join.do")){
				log.info("====================START====================");
				log.info("RequestURI : "+request.getRequestURI());
				
//				return super.preHandle(request, response, handler);
//				
//			} else {
//				if(user == null) {
//					log.info("====================START====================");
//					log.info("RequestURI : "+request.getRequestURI());
//					response.sendRedirect("/jcjc/user/login.do");
//					
//					return false;
//				}
//			}
		}
		
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(log.isInfoEnabled()) {
			log.info("====================END====================");
		}
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
}
