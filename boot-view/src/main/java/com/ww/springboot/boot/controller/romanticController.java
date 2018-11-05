package com.ww.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/romantic")
public class romanticController {
	
	@RequestMapping("")
	public String show(){
		return "romantic/list";
	}

	
	
}
