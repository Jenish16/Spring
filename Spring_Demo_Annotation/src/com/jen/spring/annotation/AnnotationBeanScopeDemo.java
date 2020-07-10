package com.jen.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemo {

	public static void main(String[] args) {
		
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			
		//get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		System.out.println(result);
		
		System.out.println("theCoach"+theCoach);
		
		System.out.println("alphaCOach"+alphaCoach);
		
		context.close();
	}

}
