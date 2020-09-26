package com.jen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	
	@Pointcut("execution(* com.jen.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}

	@Pointcut("execution(* com.jen.aopdemo.dao.*.get*(..))")
	public void getter() {}

	@Pointcut("execution(* com.jen.aopdemo.dao.*.set*(..))")
	public void setter() {}

	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
}
