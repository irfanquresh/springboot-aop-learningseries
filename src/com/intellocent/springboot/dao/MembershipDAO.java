package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

import com.intellocent.springboot.entity.Account;

@Component
public class MembershipDAO {

	public void addAccount(Account account) throws Exception {
		System.out.println(getClass() + ": Adding Membership...");
		// throw new Exception();
	}

	public void addFamilyAccount(Account account) throws Exception {
		System.out.println(getClass() + ": Adding Family Membership...");
		// throw new Exception();
	}
}
