package com.javalec.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAdvice {

	@Pointcut("execution(* com.javalec.guestbook.controller..*Controller.*(..))")
	public void allPointcut() {}
	@Around("allPointcut()")
	public Object aroungLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE] 비즈니스 로직 처리 전 수행!!");
		Object returnObj = pjp.proceed() ;
		System.out.println("[After] 비즈니스 로직 처리 후 수행!!");
		
		
		return returnObj ;
	}
	
}
