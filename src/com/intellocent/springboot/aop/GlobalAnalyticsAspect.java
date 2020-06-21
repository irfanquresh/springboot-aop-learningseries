package com.intellocent.springboot.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class GlobalAnalyticsAspect {

	@Before("com.intellocent.springboot.aop.GlobalAspect.forDAOWithoutGetterAndSetter()")
	public void analytics() {
		System.out.println("");
		System.out.println("Analytics Aspect=> Performing Analytics...");
		System.out.println("");
	}
}
