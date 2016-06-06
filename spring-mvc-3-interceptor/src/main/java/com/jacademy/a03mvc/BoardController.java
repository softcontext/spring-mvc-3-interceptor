package com.jacademy.a03mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	@RequestMapping(params="action=list")
	public String login(){
		return "board/board_list";
	}
}
