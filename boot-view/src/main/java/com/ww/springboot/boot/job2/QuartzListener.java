package com.ww.springboot.boot.job2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class QuartzListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private MyScheduler myScheduler;

	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		try {
			this.myScheduler.scheduleJobs();
		} catch (Exception arg2) {
			arg2.printStackTrace();
		}

	}
}
