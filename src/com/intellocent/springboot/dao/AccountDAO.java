package com.intellocent.springboot.dao;

import org.springframework.stereotype.Component;

import com.intellocent.springboot.entity.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean status) throws Exception {
		System.out.println(getClass() + ": Adding Account...");
		// throw new Exception();
	}

	public void addFamilyAccount(Account account) throws Exception {
		System.out.println(getClass() + ": Adding Family Account...");
		// throw new Exception();
	}

	public String getName() {
		System.out.println("GetName :" + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("SetName:" + name);
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("GetServiceCode:" + serviceCode);
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("SetServiceCode:" + serviceCode);
		this.serviceCode = serviceCode;
	}

}
