package com.jacademy.a03mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(params="action=login")
	public String login(){
		return "login/login_form";
	}
	
	@RequestMapping(params="action=check")
	public String check(
			@RequestParam(value="id", required=false, defaultValue="NONE") String id,
			HttpServletRequest request){
		
		if (id != null && !id.equals("NONE")) {
			request.getSession().setAttribute("userid", id);
			System.out.println("userid: " + id);
		}
		
		return "redirect:/";
	}
}
