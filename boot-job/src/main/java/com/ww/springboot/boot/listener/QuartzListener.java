package com.ww.springboot.boot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.ww.springboot.boot.schedule.MyScheduler;

/**
 * 启动时加载定时任务
 */
//@Component
public class QuartzListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(QuartzListener.class);


    @Autowired
	private MyScheduler myScheduler;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
        try {
            myScheduler.scheduleJobs();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(),e);
        }
	}
}
