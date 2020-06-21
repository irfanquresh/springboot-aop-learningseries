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
@Order(3)
public class GlobalCloudAspect {

	@Before("com.intellocent.springboot.aop.GlobalAspect.forDAOWithoutGetterAndSetter()")
	public void cloud() {
		System.out.println("");
		System.out.println("Cloud Aspect=> Performing instance health check...");
		System.out.println("");
	}

}
