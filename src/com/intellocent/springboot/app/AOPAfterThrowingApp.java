package com.intellocent.springboot.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.AccountDAO;
import com.intellocent.springboot.dao.MembershipDAO;
import com.intellocent.springboot.entity.Account;

public class AOPAfterThrowingApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> myAccount = null;
		try {
			myAccount = accountDAO.findAccount(false);
		} catch (Exception e) {
			System.out.println("\n-------------------");
			System.out.println("Main Program Exceptions:" + e);
			System.out.println("******************\n");
		}

		System.out.println("\n-------------------");
		System.out.println("Main program AFter Returning");
		System.out.println(myAccount);
		System.out.println("******************\n");

		context.close();
	}
}
