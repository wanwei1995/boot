package com.ww.springboot.boot.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ww.springboot.boot.model.Configuration;
import com.ww.springboot.boot.service.ConfigService;

@Service
@RequestMapping("/transaction2")
public class TransactionService2 {
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping("/test")
	@ResponseBody
	@Transactional
	public String test(){
		Configuration configuration = configService.findById(1L);
		configService.update(configuration);
		return "SUCCESS";
		
	}

}
