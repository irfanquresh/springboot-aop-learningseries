package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() throws Exception {
		System.out.println(getClass() + ": Adding Membership...");
		// throw new Exception();
	}

	public void addFamilyAccount() throws Exception {
		System.out.println(getClass() + ": Adding Family Membership...");
		// throw new Exception();
	}
}
