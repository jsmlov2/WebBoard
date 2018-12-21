package github.sunkeun.webboard.controller.listeners;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginChecker extends HandlerInterceptorAdapter{

	// StringBuffer sb;
	// StringBuilder ss;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		
		System.out.println("[LOGIN CHECKER] " + req.getRequestURI());
		HttpSession session = req.getSession();
		if ( session.getAttribute("Member") == null ) {
			String ctxpath = req.getContextPath();
			res.sendRedirect(ctxpath + "/login");
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
