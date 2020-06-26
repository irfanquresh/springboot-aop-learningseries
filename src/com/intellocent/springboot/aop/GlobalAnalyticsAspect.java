package com.intellocent.springboot.aop;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.intellocent.springboot.app.AOPAroundApp;

@Aspect
@Component
@Order(2)
public class GlobalAnalyticsAspect {

	private Logger myLogger = Logger.getLogger(AOPAroundApp.class.getName());

	@Before("com.intellocent.springboot.aop.GlobalAspect.forDAOWithoutGetterAndSetter()")
	public void analytics() {
		myLogger.info("\n-------------------");
		myLogger.info("Analytics Aspect=> Performing Analytics...");
		myLogger.info("******************\n");
	}
}
