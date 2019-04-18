package com.ww.springboot.boot.config;


import java.util.Set;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ww.springboot.boot.enumeration.IntegerEnum;
import com.ww.springboot.boot.enumeration.IntegerEnumTypeHandler;
import com.ww.springboot.boot.enumeration.StringEnum;
import com.ww.springboot.boot.enumeration.StringEnumTypeHandler;
import com.ww.springboot.boot.utils.ClassPathScanHandler;

@Configuration
public class MyBatisConfig {
    @Primary
    @Bean
    MybatisProperties mybatisProperties() {
    	ClassPathScanHandler handler = new ClassPathScanHandler(false, false, null);
    	Set<Class<?>> integerEnumClasses = handler.getPackageAllClassesByInterface("com.ww.springboot.boot.enumeration", true, IntegerEnum.class);
    	Set<Class<?>> stringEnumClasses = handler.getPackageAllClassesByInterface("com.ww.springboot.boot.enumeration", true, StringEnum.class);
      
    	
    	MybatisProperties props = new MybatisProperties();
        org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
        config.setJdbcTypeForNull(JdbcType.NULL);
        for (Class<?> clazz : integerEnumClasses) {
        	config.getTypeHandlerRegistry().register(clazz, IntegerEnumTypeHandler.class);
        }
        
        for (Class<?> clazz : stringEnumClasses) {
        	config.getTypeHandlerRegistry().register(clazz, StringEnumTypeHandler.class);
        }
        props.setConfiguration(config);
        return props;
    }

}
