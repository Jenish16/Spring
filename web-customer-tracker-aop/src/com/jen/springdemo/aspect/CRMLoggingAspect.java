package com.jen.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.jen.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.jen.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.jen.springdemo.dao.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage() ")
	private void appFlow() {}
	
	@Before("appFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("===>> in @Before : calling method : " + method);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object tempArgs : args) {
			
			myLogger.info("===>> Argument : " + tempArgs);
		}
	}
	
	@AfterReturning(pointcut="appFlow()",returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		String method = theJoinPoint.getSignature().toShortString();
		
		myLogger.info("===>> in @AfterReturning : from method : " + method);
		
		myLogger.info("===>> result : " + theResult);
		
		
	}
}
