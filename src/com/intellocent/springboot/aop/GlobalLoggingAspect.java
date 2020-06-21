package com.intellocent.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.intellocent.springboot.entity.Account;

@Aspect
@Component
@Order(1)
public class GlobalLoggingAspect {

	@Before("com.intellocent.springboot.aop.GlobalAspect.forDAOWithoutGetterAndSetter()")
	public void log(JoinPoint theJoinPoint) {
		System.out.println("-----------------");
		System.out.println("Logging Aspect=> Performing Logging...");

		MethodSignature methSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("MethodSignature:" + methSignature);

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			System.out.println("Temp Args:" + tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("Account Name:" + account.getName());
				System.out.println("Account Level:" + account.getLevel());
			}
		}

		Object tgt = theJoinPoint.getTarget();
		System.out.println("Target:" + tgt);

		System.out.println("");
	}

}
