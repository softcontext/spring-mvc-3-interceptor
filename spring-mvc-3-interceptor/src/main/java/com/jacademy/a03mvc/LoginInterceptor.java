package com.jacademy.a03mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
	/*
	 * 핸들러 인터셉터는 DispatcherServlet이 컨트롤러를 호출하기 전과 후에 요청과 응답을 참조하거나 가공할 수 있다.
	 * 핸들러 매핑은 DispatcherServlet으로 부터 매핑 작업을 요청받으면 그 결과로 핸들러 실행 체인(HandlerExecutionChain)을 돌려준다.
	 * 핸들러 실행 체인은 하나 이상의 핸들러 인터셉터를 거쳐서 컨트롤러가 실행될 수 있도록 구성되어 있다.
	 * 핸들러 인터셉터 자체가 스프링의 빈이기 때문에 DI를 통해 다른 빈을 활용할 수도 있다.
	 * 컨트롤러 호출과정에 적용되는 부가 기능은 핸들러 인터셉터를 사용하는 편이 낫다.
	 */

	//컨트롤러가 호출되기 전에 실행된다.
	//인터셉터가 등록된 순서대로 실행된다.
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String userid = (String) request.getSession().getAttribute("userid");
		if (userid == null || userid.equals("")) {
			String location = request.getSession().
					getServletContext().getContextPath() + "/login?action=login";
			response.sendRedirect(location);
			return false;
		}
		/*
		 * 리턴 값이 true이면 핸들러 실행 체인의 다음 단계로 진행되지만, 
		 * false라면 작업을 중단하고 리턴하므로 컨트롤러와 남은 인터셉터들은 실행되지 않는다.
		 */
		return true;
	}

	//컨트롤러를 실행하고 난 후에 호출된다.
	//컨트롤러에서 예외가 발생되면 실행하지 않는다.
	//preHandle() 메소드에서 false를 리턴했을 경우에는 postHandle()도 실행되지 않는다.
	//postHandle()과 afterCompletion()은 preHandle()이 실행된 순서와 반대로 실행된다.
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		//컨트롤러가 돌려준 ModelAndView타입의 정보가 제공되서 컨트롤러 작업 결과를 참조하거나 조작할 수 있다.
		
	}

	//클라이언트에 뷰를 통해 응답을 전송한뒤 실행 된다.
	//뷰를 생설항때 예외가 발생해도 실행된다.
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//처리 중에 사용한 리소스를 반환해 주기에 적당한 메소드이다.
	}

}
