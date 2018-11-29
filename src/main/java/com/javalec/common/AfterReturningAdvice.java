package com.javalec.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterReturningAdvice {

	@Pointcut("execution(* com.javalec.guestbook.controller..*Controller.*(..))")
	public void allPointcut() {}
	
	@AfterReturning("allPointcut()")
	public void afterLog() {
		System.out.println("[사후처리] 비즈니스 로직 처리 후   수행!!");
	}
	
}
