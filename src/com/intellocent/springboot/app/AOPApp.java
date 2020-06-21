package com.intellocent.springboot.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.AccountDAO;
import com.intellocent.springboot.dao.MembershipDAO;
import com.intellocent.springboot.entity.Account;

public class AOPApp {

	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// accountDAO.addAccount();
		// accountDAO.addFamilyAccount();
		// membershipDAO.addAccount();
		// membershipDAO.addFamilyAccount();

		Account account = new Account();
		
		account.getName("ABC");
		accountDAO.addAccount(account, true);
		accountDAO.addFamilyAccount(account);
		membershipDAO.addAccount(account);
		membershipDAO.addFamilyAccount(account);

		context.close();
	}
}
