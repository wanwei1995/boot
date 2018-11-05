/*package com.ww.springboot.boot.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ww.springboot.boot.provide.DubboService;

@Controller
@RequestMapping("dubboTest")
public class DubboTestController {
	@Reference
	private DubboService dubboService;
	
	@RequestMapping("")
	public String dubbo1(){
		String s = dubboService.DubboTest1();
		return s;
	}
}
*/