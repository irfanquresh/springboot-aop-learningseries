package com.intellocent.springboot.entity;

public class Account {

	private String name;
	private String level;

	public String getName(String name) {
		System.out.println("get Name called:" + name);
		return name;
	}

	public String getName() {
		System.out.println("get Name called");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
