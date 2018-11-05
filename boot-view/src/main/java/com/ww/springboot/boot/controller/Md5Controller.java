package com.ww.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("MD5")
public class Md5Controller {
	
	@RequestMapping("")
	public String start(){
		return "md5/list";
	}

}
