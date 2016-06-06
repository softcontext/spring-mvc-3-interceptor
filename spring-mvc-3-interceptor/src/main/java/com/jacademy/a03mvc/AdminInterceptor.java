package com.jacademy.a03mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AdminInterceptor implements HandlerInterceptor{

	//Controller 실행 요청전
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String userid = (String) request.getSession().getAttribute("userid");
		if (userid == null) {
			String location = request.getSession().
					getServletContext().getContextPath() + "/login?action=login";
			response.sendRedirect(location);
			
			return false;
			
		} else if(!userid.equals("admin")){
			
			//처리방법 1
//			String location = request.getSession().
//					getServletContext().getContextPath() + "/";
//			
//			response.sendRedirect(location);
			
			//처리방법 2
			request.getRequestDispatcher("invalidAccess").forward(request, response);
			
			return false;
		}
		return true;
	}

	//view(jsp)로 forward되기 전
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	//끝난뒤
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
