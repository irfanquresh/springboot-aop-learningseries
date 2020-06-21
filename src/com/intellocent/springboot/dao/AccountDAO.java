package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() throws Exception {
		System.out.println(getClass() + ": Adding Account...");
		//throw new Exception();
	}
	
	public void addFamilyAccount() throws Exception {
		System.out.println(getClass() + ": Adding Family Account...");
		//throw new Exception();
	}
}
