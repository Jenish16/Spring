package com.jen.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.jen.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

	@Around("execution(* com.jen.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune
		(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		String method = theProceedingJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>Executing Around on method:"+method);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		try {
			
			result = theProceedingJoinPoint.proceed();
			
		}catch(Exception e) {
			
			System.out.println("=====>>>"+e.getMessage());
			
//			result = "Major Accident ! But no worries, AOP is on the way";    //To Handle Exception
			
			throw e; 	//To rethrow to main program
		}
		long end = System.currentTimeMillis();
		
		long duration = end - begin;

		System.out.println("=====>>>Duration : "+(duration/1000)+" seconds");
		
		return result;
	}
	
	
	
	
	@AfterReturning(
			pointcut = "execution(* com.jen.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint , List<Account> result) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>Executing AfterReturning on method:"+method);
		
		System.out.println("\n=====>>> Result is : "+result);
		
		convertAccountNamesToUpperCase(result);
		
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.jen.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint , Throwable theExc) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>Executing AfterThrowing on method:"+method);
		
		System.out.println("\n=====>>> Exception is : "+theExc);
	
		
	}
	
	@After("execution(* com.jen.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		System.out.println("\n=====>>>Executing After(finally) on method:"+method);
		
	
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		 
		for(Account tempAccount : result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			tempAccount.setName(theUpperName);
			
		}
	}

	@Before("com.jen.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Executing @Before advice on dao package");
		
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("=====>>>Method Signature:"+methodSign);
			
		Object[] args = theJoinPoint.getArgs();
		if(args.length > 0) {
			System.out.println("=====>>>----Arguments-----");
		}else {
			System.out.println("=====>>>----No Arguments-----");
		}
		
		for(Object tempArg : args) {
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account)tempArg;
				System.out.println("=====>>>"+theAccount.toString());
			}else {
				System.out.println("=====>>>"+tempArg);
			}
		}
		
	}
	
}
