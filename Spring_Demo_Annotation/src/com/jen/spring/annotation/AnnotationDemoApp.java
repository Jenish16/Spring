package com.jen.spring.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
		//get the bean from spring container
		//Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		TennisCoach theCoach = context.getBean("tennisCoach",TennisCoach.class);
		
		//call a method on a bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmail());
		
		//close the context
		context.close();
		

	}

}
