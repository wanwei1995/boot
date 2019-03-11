package com.ww.springboot.boot.schedule;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;


/**
 * @author wanwei
 * @TODO   Quartz的4个核心概念：
           1、Job
                                    表示一个工作，要执行的具体内容。此接口中只有一个方法
              void execute(JobExecutionContext context)

           2、JobDetail
             JobDetail表示一个具体的可执行的调度程序，Job是这个可执行程调度程序所要执行的内容，另外JobDetail还包含了这个任务调度的方案和策略。

           3、Trigger代表一个调度参数的配置，什么时候去调。

           4、Scheduler代表一个调度容器，一个调度容器中可以注册多个JobDetail和Trigger。当Trigger与JobDetail组合，就可以被Scheduler容器调度了。
 * @date: 2019年2月28日 下午5:15:58 
 */
public abstract class MyScheduler {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
	
	protected Scheduler getScheduler () {
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		return scheduler;
	}
	
	abstract public void scheduleJobs() throws Exception;

	abstract public void addJob(String jobName, Class<? extends Job> clazz, String cron) throws Exception;
	
    protected void startJob(String jobName, Class<? extends Job> clazz, String cron) throws Exception {
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(jobName, "job")
                .storeDurably(true)
                .build();

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName, "job")
                .withSchedule(scheduleBuilder)
                .build();

        Scheduler scheduler = getScheduler();
        if (scheduler.checkExists(jobDetail.getKey())){
            //scheduler.deleteJob(jobDetail.getKey());
            //return ;
            scheduler.resumeJob(jobDetail.getKey());
            return;
        }
        getScheduler().scheduleJob(jobDetail, cronTrigger);
    }
}
