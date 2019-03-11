package com.ww.springboot.boot.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJob implements Job{
	
	 /**
     * 日志对象
     */
    protected Logger LOGGER = LoggerFactory.getLogger(getClass());


    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        try {
            //do something
        	System.out.println("测试成功");
        } catch (Exception e) {
            LOGGER.error("失败", e);
        }
    }

}
