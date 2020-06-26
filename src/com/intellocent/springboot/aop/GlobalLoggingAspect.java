package com.intellocent.springboot.aop;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.intellocent.springboot.app.AOPAroundApp;
import com.intellocent.springboot.entity.Account;

@Aspect
@Component
@Order(1)
public class GlobalLoggingAspect {

	private Logger myLogger = Logger.getLogger(AOPAroundApp.class.getName());

	@Before("com.intellocent.springboot.aop.GlobalAspect.forDAOWithoutGetterAndSetter()")
	public void log(JoinPoint theJoinPoint) {
		myLogger.info("\n-------------------");
		myLogger.info("Logging Aspect=> Performing Logging...");

		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("MethodSignature:" + methSignature);

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			myLogger.info("Temp Args:" + tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("Account Name:" + account.getName());
				myLogger.info("Account Level:" + account.getLevel());
			}
		}

		Object tgt = theJoinPoint.getTarget();
		myLogger.info("Target:" + tgt);
		myLogger.info("******************\n");
	}

	@AfterReturning(pointcut = "execution(* com.intellocent.springboot.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

		myLogger.info("\n-------------------");
		myLogger.info("====> AfterReturningFindAccountAdvice");
		myLogger.info(result.toString());

		// Convert result as required
		for (Account tempAccount : result) {
			tempAccount.setName(tempAccount.getName().toUpperCase());
		}

		myLogger.info("******************\n");
	}

	@AfterThrowing(pointcut = "execution(* com.intellocent.springboot.dao.AccountDAO.findAccount(..))", throwing = "theExc")
	public void afterthrowingFindAccountAdvice(JoinPoint theJoinPoint, Exception theExc) {

		String methSignature = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------------------");
		myLogger.info("====> AfterthrowingFindAccountAdvice");
		myLogger.info("MethodSignature:" + methSignature);
		myLogger.info("The Exception is:" + theExc);
		myLogger.info("******************\n");

	}

	@After("execution(* com.intellocent.springboot.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String methSignature = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------------------");
		myLogger.info("====> AfterFinallyFindAccountAdvice");
		myLogger.info("MethodSignature:" + methSignature);
		myLogger.info("******************\n");
	}

	@Around("execution(* com.intellocent.springboot.dao.TraficFortuneService.getFortune(..))")
	public Object aroundAccountAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String methSignature = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n-------------------");
		myLogger.info("====> AroundAccountAdvice");
		myLogger.info("MethodSignature:" + methSignature);

		long begin = System.currentTimeMillis();

		Object result = null;

		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			result = "major Accident! But no worries";
			// throw e;
		}

		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("Duration: " + (duration / 1000.0));

		myLogger.info("Result===>" + result);
		myLogger.info("******************\n");
		return result;
	}

}
