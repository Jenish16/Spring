package com.jen.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jen.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccoutDao = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = theAccoutDao.findAccounts();
		
		System.out.println("\n\n Main Program After Returning");
		System.out.println("-----------------------------");
		System.out.println(theAccounts);
		
	
		context.close();
	}

}
