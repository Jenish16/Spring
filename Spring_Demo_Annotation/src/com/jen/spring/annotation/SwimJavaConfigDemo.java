package com.jen.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemo {

	public static void main(String[] args) {
		//read spring config java  class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
	
		//get the bean from spring container
		Coach theCoach = context.getBean("swimCoach",Coach.class);
		
		//call a method on a bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
	//	System.out.println(theCoach.getEmail());
		
		//close the context
		context.close();
		

	}

}
