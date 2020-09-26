package com.jen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//@Before("execution(public void com.jen.aopdemo.dao.AccountDAO.addAccount())")
	//@Before("execution(public void addAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution(* add*())")
	//@Before("execution(* add*(com.jen.aopdemo.Account, ..))")
	//@Before("execution(* add*(..))")
	@Before("execution(* com.jen.aopdemo.dao.*.*(..))")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
	}
}
