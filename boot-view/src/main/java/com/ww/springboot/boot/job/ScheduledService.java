package com.ww.springboot.boot.job;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ww.springboot.boot.job2.SendWeeklySchedule;

@EnableScheduling
@Component
@Async
public class ScheduledService {
	
    private Logger logger;
	
	public ScheduledService() {
		logger = Logger.getLogger(SendWeeklySchedule.class);
	}
	//每个星期五的18点整触发
	@Scheduled(cron = "0 0 18 ? * FRI")
	public void sendWeekly(){
		logger.info("cron测试开始");
		System.out.println(new Date());
		logger.info("cron测试结束");
	}
	//每天的整点触发
	@Scheduled(cron = "0 0 * * * *")
	public void makeData(){
		System.out.println("整点播报");
	}
}
