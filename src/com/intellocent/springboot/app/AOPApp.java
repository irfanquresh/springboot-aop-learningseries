package com.intellocent.springboot.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.AccountDAO;
import com.intellocent.springboot.dao.MembershipDAO;

public class AOPApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		accountDAO.addAccount();
		accountDAO.addFamilyAccount();
		membershipDAO.addAccount();
		membershipDAO.addFamilyAccount();

		context.close();
	}
}
