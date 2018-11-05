package com.ww.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("dynamicText")
public class DynamicController {
	
	@RequestMapping("")
	public String index(){
		return "dynamic/list";
	}

}
