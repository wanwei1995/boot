package com.ww.springboot.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
//@EnableEurekaClient
@ComponentScan(basePackages = "com.ww.springboot.boot.*")
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("启动完成!");
	}
}
