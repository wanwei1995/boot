package com.ww.springboot.boot.job2;

import org.quartz.Scheduler;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.ww.springboot.boot.utils.SpringUtils;

public abstract class MyScheduler {
	
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	protected Scheduler getScheduler() {
		Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
		return scheduler;
	}

	public abstract void scheduleJobs() throws Exception;

	public abstract void addJob(String arg0, Class<?> arg1, String arg2, String arg3) throws Exception;

	protected void startJob(String jobName, Class<?> clazz, String method, String cron) throws Exception {
		MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
		jobDetail.setConcurrent(false);
		jobDetail.setName(jobName);
		jobDetail.setGroup("job");
		Object task = SpringUtils.getBean(clazz);
		jobDetail.setTargetObject(task);
		jobDetail.setTargetMethod(method);
		jobDetail.afterPropertiesSet();
		CronTriggerImpl trigger = new CronTriggerImpl();
		((CronTriggerImpl) trigger).setCronExpression(cron);
		((CronTriggerImpl) trigger).setName(jobName);
		((CronTriggerImpl) trigger).setJobName(jobName);
		((CronTriggerImpl) trigger).setJobGroup("job");
		this.getScheduler().scheduleJob(jobDetail.getObject(), trigger);
	}

}
