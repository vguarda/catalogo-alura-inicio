package br.com.caelum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession();
		
		if(session.getAttribute("logado") != null) return true;
		
		String requestUri = request.getRequestURI();
		
		if(requestUri.endsWith("form")) response.sendRedirect(request.getServletContext().getContextPath()); 
		else
		response.sendRedirect("../");
		
		return false;
		
	}
}
