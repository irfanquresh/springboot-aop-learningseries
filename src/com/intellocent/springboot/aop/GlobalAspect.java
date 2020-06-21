package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GlobalAspect {

	@Pointcut("execution(* com.intellocent.springboot.dao.*.*(..))")
	public void forDAOPackage() {
	}

	@Pointcut("execution(* com.intellocent.springboot.dao.*.get*(..))")
	public void forGetter() {
	}

	@Pointcut("execution(* com.intellocent.springboot.dao.*.set*(..))")
	public void forSetter() {
	}

	@Pointcut("forDAOPackage() && !(forGetter() || forSetter())")
	public void forDAOWithoutGetterAndSetter() {
	}
}
