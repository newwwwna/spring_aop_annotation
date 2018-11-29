package com.javalec.common;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterThrowingAdvice {

	@Pointcut("execution(* com.javalec.guestbook.controller..*Controller.*(..))")
	public void allPointcut() {}
	
	@AfterThrowing("allPointcut()")
	public void exceptionLog() {
		System.out.println("[예외 처리] 비즈니스 로직 처리 중 예외 발생!!");
	}
	
}
