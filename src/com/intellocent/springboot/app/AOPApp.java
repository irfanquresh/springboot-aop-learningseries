package com.intellocent.springboot.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.AccountDAO;

public class AOPApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		accountDAO.addAccount();

		System.out.println("--------------Execute Again-----------");
		accountDAO.addAccount();
		context.close();
	}
}
