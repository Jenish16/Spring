package com.jen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.jen.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.jen.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.jen.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on dao package");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		
		System.out.println("\n=====>>> Performing API Analytics");
	}
	
	
}
