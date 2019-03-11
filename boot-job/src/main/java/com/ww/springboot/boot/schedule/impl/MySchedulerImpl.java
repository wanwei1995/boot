package com.ww.springboot.boot.schedule.impl;

import org.quartz.Job;
import org.springframework.stereotype.Component;

import com.ww.springboot.boot.job.TestJob;
import com.ww.springboot.boot.schedule.MyScheduler;

@Component
public class MySchedulerImpl extends MyScheduler{

	@Override
	public void scheduleJobs() throws Exception {
		// TODO Auto-generated method stub
		startJob("测试", TestJob.class, "* * * * * ?");
	}

	@Override
	public void addJob(String jobName, Class<? extends Job> clazz, String cron) throws Exception {
		// TODO Auto-generated method stub
		startJob(jobName, clazz, cron);
	}

}
