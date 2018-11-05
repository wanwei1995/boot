package com.ww.springboot.boot.job2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfigration {
	@Bean(name = {"schedulerFactory"})
	public SchedulerFactoryBean schedulerFactory() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		bean.setOverwriteExistingJobs(true);
		bean.setStartupDelay(1);
		return bean;
	}
}
