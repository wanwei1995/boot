package com.ww.springboot.boot.job2;

import org.springframework.stereotype.Component;

@Component
public class MySchedulerImpl extends MyScheduler{

	@Override
	public void scheduleJobs() throws Exception {
		//startJob("发周报", SendWeeklySchedule.class, "SendWeeklyJob", "* * * ? * FRI");
		
	}

	@Override
	public void addJob(String jobName, Class<?> clazz, String method, String cron) throws Exception {
		startJob(jobName, clazz, method, cron);
	}

}
