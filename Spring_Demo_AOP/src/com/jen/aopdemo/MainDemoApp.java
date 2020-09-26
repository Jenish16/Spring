package com.jen.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jen.aopdemo.dao.AccountDAO;
import com.jen.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccoutDao = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDao = context.getBean("membershipDAO", MembershipDAO.class);
		
		Account theAccount = new Account();	
		
		
		theAccoutDao.addAccount(theAccount, false);
		
		theAccoutDao.doWork();
		
		theMembershipDao.addAccount();
		
		theMembershipDao.addSilly();
		
		theMembershipDao.gotoSleep();
		context.close();
	}

}
