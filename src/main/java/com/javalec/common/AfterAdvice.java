package com.javalec.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAdvice {

	
	@Pointcut("execution(* com.javalec.guestbook.controller..*Controller.*(..))")
	public void allPointcut() {
		
	}
	
	@After("allPointcut()")
	public void finallyLog() {
		System.out.println("[사후처리] 비즈니스 로직 처리 후 무조건 무족건 수행!!");
	}
	
}
