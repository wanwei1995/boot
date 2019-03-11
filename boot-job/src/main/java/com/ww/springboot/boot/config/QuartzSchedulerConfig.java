package com.ww.springboot.boot.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.ww.springboot.boot.factory.DianaJobFactory;

/**
 * @author 第一种类型叫做RAMJobStore:
                                        最佳的性能，因为内存中数据访问最快
                                       不足之处是缺乏数据的持久性，当程序路途停止或系统崩溃时，所有运行的信息都会丢失
--->       第二种类型叫做JDBC作业存储:
                                       通过调整其quartz.properties属性文件，持久化任务调度信息
                                       使用数据库保存任务调度信息后，即使系统崩溃后重新启动，任务的调度信息将得到恢复
 * @TODO
 * @date: 2019年2月28日 下午5:50:38 
 */
@Configuration
public class QuartzSchedulerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuartzSchedulerConfig.class);
    private static final String QUARTZ_PROPERTIES_NAME = "/quartz.properties";

    @Autowired
    private DianaJobFactory dianaJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        try {
            schedulerFactoryBean.setQuartzProperties(quartzProperties());
            schedulerFactoryBean.setSchedulerName("DIANA_TASK_EXECUTOR");
            // 延迟10秒启动
            schedulerFactoryBean.setStartupDelay(5);
            schedulerFactoryBean.setApplicationContextSchedulerContextKey("dianaApplicationContextKey");
            schedulerFactoryBean.setOverwriteExistingJobs(true);
            schedulerFactoryBean.setAutoStartup(true);
            schedulerFactoryBean.setJobFactory(dianaJobFactory);
            schedulerFactoryBean.setDataSource(dataSource);
        }catch (Exception e) {
            LOGGER.error("加载 {} 配置文件失败.", QUARTZ_PROPERTIES_NAME, e);
            throw new RuntimeException("加载配置文件失败", e);
        }
        return schedulerFactoryBean;
    }



    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(QUARTZ_PROPERTIES_NAME));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

}
