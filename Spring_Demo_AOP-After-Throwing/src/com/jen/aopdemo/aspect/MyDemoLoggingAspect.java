package com.jen.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
