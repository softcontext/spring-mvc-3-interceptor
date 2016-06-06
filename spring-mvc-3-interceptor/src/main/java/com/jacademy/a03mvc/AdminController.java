package com.jacademy.a03mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(params="action=member")
	public String login(){
		return "admin/member_list";
	}
}
