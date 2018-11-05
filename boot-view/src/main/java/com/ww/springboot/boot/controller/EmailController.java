package com.ww.springboot.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ww.springboot.boot.service.EmailService;

@Controller
@RequestMapping("email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping("")
	public String start(){
		return "email/list";
	}
	
	
	/**
	 * @author wanwei
	 * @TODO  发送周报
	 * @date: 2018年9月10日 上午11:11:21
	 * @return
	 */
	@RequestMapping("sendWeekly")
	@ResponseBody
	public String sendWeekly(){
		emailService.sendWeekly();
		return "SUCCESS";
	}

}
