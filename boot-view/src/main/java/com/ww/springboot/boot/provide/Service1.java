package com.ww.springboot.boot.provide;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping("/rest")
public class Service1 {
	
	@RequestMapping("/test1")
	@ResponseBody
	public String test(){
		return "test";
	}
	
	@RequestMapping("/test2")
	@ResponseBody
	public String test2(String text){
		return text;
	}
}
