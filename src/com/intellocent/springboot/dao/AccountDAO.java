package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() throws Exception {
		System.out.println(getClass() + ": Doing DB Work...");
		throw new Exception();
	}
}
