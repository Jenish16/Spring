package com.jen.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
