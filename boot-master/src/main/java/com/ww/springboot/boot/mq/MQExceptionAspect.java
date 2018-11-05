package com.ww.springboot.boot.mq;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ww.springboot.boot.model.ExpServiceMsg;

/**
 * @author wanwei
 * @TODO  使用切面可以将某一种相同的处理集中到一点进行处理
 * @date: 2018年9月20日 下午2:31:41 
 */
@Aspect
@Component("mqExceptionAspect")
public class MQExceptionAspect {
	
	@Autowired
	private MessageSender messageSender;
	
	//定义切面指向
	@Pointcut("@annotation(org.springframework.amqp.rabbit.annotation.RabbitHandler)")
	public void mqExceptionAroundPointCut() {
    }

	//进入切面后处理
	@Around("mqExceptionAroundPointCut()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		ExpServiceMsg expServiceMsg = getMessage(pjp);
		System.out.println(expServiceMsg.toString());
		Object result = null;
		try{
			result = pjp.proceed();
			}catch(Exception e){
				messageSender.sendRetry(QueueConstants.QueueEnum.getQueueEnumByName(expServiceMsg.getRoutingKey()), expServiceMsg);
			}
		return result;
	}
	
	private ExpServiceMsg getMessage(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            if (obj instanceof ExpServiceMsg) {
                return (ExpServiceMsg) obj;
            }
        }
        return null;
    }
}
