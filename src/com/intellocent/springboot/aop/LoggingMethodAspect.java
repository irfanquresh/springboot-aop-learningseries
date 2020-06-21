package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class LoggingMethodAspect {

	// @Before("execution(public void addAccount())")
	// @Before("execution(public void
	// com.intellocent.springboot.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	@Before("execution(* add*())")
	public void beforeExecution() {
		System.out.println("Aspect Logging: Starting Add account execution");
	}

	// @AfterReturning("execution(public void addAccount())")
	// @AfterReturning("execution(public void
	// com.intellocent.springboot.dao.AccountDAO.addAccount())")
	// @AfterReturning("execution(public void add*())")
	@AfterReturning("execution(* add*())")
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
