package com.intellocent.springboot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.intellocent.springboot.entity.Account;

@Component
public class TraficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean flag) {

		if (flag) {
			throw new RuntimeException("Major Accident! Highway is closed!!");
		}
		return getFortune();
	}

}
