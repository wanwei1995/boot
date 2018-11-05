package com.ww.springboot.boot.job2;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component("sendWeeklySchedule")
public class SendWeeklySchedule {
    
	private Logger logger;
	
	public SendWeeklySchedule() {
		logger = Logger.getLogger(SendWeeklySchedule.class);
	}
	
	public void SendWeeklyJob() {
		logger.info("----  发送周报开始 -----");
		
		System.out.println("hello");
		
		logger.info("----  发送周报结束 -----");
	}
}
