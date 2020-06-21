package com.jen.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope_applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class );
		
		Coach alphaCoach = context.getBean("myCoach",Coach.class );

		boolean result = theCoach == alphaCoach;
		System.out.println("Is same: "+ result);
		
		System.out.println("Location theCoach:"+theCoach);
		
		System.out.println("Location alphaCoach:"+alphaCoach);

		context.close();
	}

}
