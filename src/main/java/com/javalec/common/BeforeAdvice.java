package com.javalec.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAdvice {
	
	
	@Pointcut("execution(* com.javalec.guestbook.controller..*Controller.*(..))")
	public void allPointcut() {}
	
	@Before("allPointcut()")
	public void beforeLog() {
		System.out.println("[사전처리] 비즈니스 로직전 수행!!");
	}
	
}
