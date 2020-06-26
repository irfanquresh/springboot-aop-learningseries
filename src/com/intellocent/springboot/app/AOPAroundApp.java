package com.intellocent.springboot.app;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.intellocent.springboot.config.ApplicationConfiguration;
import com.intellocent.springboot.dao.TraficFortuneService;

public class AOPAroundApp {

	private static Logger myLogger=Logger.getLogger(AOPAroundApp.class.getName());
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ApplicationConfiguration.class);

		TraficFortuneService traficFortuneService = context.getBean("traficFortuneService", TraficFortuneService.class);

		String myTraficFortuneService = traficFortuneService.getFortune(true);

		myLogger.info("----------------->");
		myLogger.info("Main program AFter Returning");
		myLogger.info(myTraficFortuneService);

		context.close();
	}
}
