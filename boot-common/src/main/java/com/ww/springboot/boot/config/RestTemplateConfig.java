package com.ww.springboot.boot.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	 @Bean
	    MultipartConfigElement multipartConfigElement() {
	        MultipartConfigFactory factory = new MultipartConfigFactory();
	        factory.setLocation(System.getProperty("user.dir"));
	        return factory.createMultipartConfig();
	    }

	    @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	        // Do any additional configuration here
	        return builder.setConnectTimeout(15000).setReadTimeout(15000).build();
	    }

}
