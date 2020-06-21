package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingMethodAndParamsAspect {

//	@Before("execution(* add*(com.intellocent.springboot.entity.Account,..))")
//	@Before("execution(* add*(..))")
	@Before("execution(* com.intellocent.springboot.dao.*.*(..))")
	public void beforeExecution() {
		System.out.println("Aspect Logging: Starting Add account execution");
	}

//	@AfterReturning("execution(* add*(com.intellocent.springboot.entity.Account,..))")
//	@AfterReturning("execution(* add*(..))")
	@AfterReturning("execution(* com.intellocent.springboot.dao.*.*(..))")
	public int afterReturnExecution() {
		System.out.println("Aspect Logging: Completing Add account execution");
		System.out.println("-------------------------------");
		return 1;
	}

	// @AfterThrowing("execution(public void addAccount())")
	public void afterException() {
		System.out.println("Aspect Logging: Exception in Add execution");
	}
}
