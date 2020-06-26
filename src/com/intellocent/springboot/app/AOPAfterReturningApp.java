package com.intellocent.springboot.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.AccountDAO;
import com.intellocent.springboot.dao.MembershipDAO;
import com.intellocent.springboot.entity.Account;

public class AOPAfterReturningApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> myAccount = accountDAO.findAccount(false);

		System.out.println("----------------->");
		System.out.println("Main program AFter Returning");
		System.out.println(myAccount);

		context.close();
	}
}
