package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingMethodAndParamsAspect {

	@Pointcut("execution(* com.intellocent.springboot.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("execution(* com.intellocent.springboot.dao.*.get*(..))")
	private void forGetter() {
	}

	@Pointcut("execution(* com.intellocent.springboot.dao.*.set*(..))")
	private void forSetter() {
	}

//	@Pointcut("(forGetter() || forSetter()) & !forDAOPackage()")
	@Pointcut("!(forGetter() || forSetter()) & forDAOPackage()")
	private void forDAOWithoutGetterAndSetter() {
	}

//	@Before("execution(* add*(com.intellocent.springboot.entity.Account,..))")
//	@Before("execution(* add*(..))")
//	@Before("execution(* com.intellocent.springboot.dao.*.*(..))")
	@Before("forDAOWithoutGetterAndSetter()")
	public void performLogging() {
		System.out.println("Aspect Logging: Starting Add account execution");
	}

	@Before("forDAOWithoutGetterAndSetter()")
	public void performAnalystics() {
		System.out.println("Aspect Analytics: Starting Add account execution");
	}

//	@AfterReturning("execution(* add*(com.intellocent.springboot.entity.Account,..))")
//	@AfterReturning("execution(* add*(..))")
//	@AfterReturning("execution(* com.intellocent.springboot.dao.*.*(..))")
	@AfterReturning("forDAOWithoutGetterAndSetter()")
	public boolean afterReturnExecution() {
		System.out.println("Aspect Logging: Completing Add account execution");
		System.out.println("-------------------------------");
		return true;
	}

//	@AfterThrowing("execution(public void addAccount())")
	public void afterException() {
		System.out.println("Aspect Logging: Exception in Add execution");
	}
}
