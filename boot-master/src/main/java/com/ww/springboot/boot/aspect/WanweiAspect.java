package com.ww.springboot.boot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component("wanweiAspect")
public class WanweiAspect {
	
	@Pointcut("@annotation(com.ww.springboot.boot.aspect.WanweiInterceptor)")
	public void exceptionAroundPointCut() {
		
	}
	
	@Around("exceptionAroundPointCut()")
	public void point(ProceedingJoinPoint pjp) throws Throwable {
		
		try {
			System.out.println("---- 切面start ---");
			pjp.proceed();
			System.out.println("---- 切面end ---");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
