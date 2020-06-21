package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

import com.intellocent.springboot.entity.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean status) throws Exception {
		System.out.println(getClass() + ": Adding Account...");
		// throw new Exception();
	}

	public void addFamilyAccount(Account account) throws Exception {
		System.out.println(getClass() + ": Adding Family Account...");
		// throw new Exception();
	}
}
