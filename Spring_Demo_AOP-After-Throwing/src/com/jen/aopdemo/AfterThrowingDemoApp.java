package com.jen.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jen.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccoutDao = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;
		try {
			boolean tripWire = true;
			theAccounts = theAccoutDao.findAccounts(tripWire);
			
		}catch(Exception e) {
			System.out.println("\n\n Main Program Exception Cought");
		}
		
		System.out.println("\n\n Main Program After Throwing");
		System.out.println("-----------------------------");
		System.out.println(theAccounts);
		
		
	
		context.close();
	}

}
