package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(public void addAccount())")
	public void beforeExecution() {
		System.out.println("Logging: Starting Add account execution");
	}

	@AfterReturning("execution(public void addAccount())")
	public void afterReturnExecution() {
		System.out.println("Logging: Completing Add account execution");
	}

	@AfterThrowing("execution(public void addAccount())")
	public void afterException() {
		System.out.println("Logging: Exception in Add execution");
	}
}
