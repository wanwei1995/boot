package com.ww.springboot.boot.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ww.springboot.boot.model.ExpServiceMsg;
import com.ww.springboot.boot.mq.QueueConstants;

@Controller
@RequestMapping("mqTest")
public class MqTestController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@RequestMapping("")
	public String find(@ModelAttribute("expServiceMsg") ExpServiceMsg expServiceMsg,
            ModelMap map ){
		if(!StringUtils.isEmpty(expServiceMsg.getMessage())){
			rabbitTemplate.convertAndSend(expServiceMsg.getExName(), expServiceMsg.getRoutingKey(), expServiceMsg);
		}
		map.addAttribute("expServiceMsg", expServiceMsg);
		return "mq/test";
	}
	
	@RabbitListener(queues = QueueConstants.MQ_TEST1)
    @RabbitHandler
    public void receive(ExpServiceMsg expServiceMsg) throws UnsupportedEncodingException{
		System.out.println(expServiceMsg.toString());
	}
}
