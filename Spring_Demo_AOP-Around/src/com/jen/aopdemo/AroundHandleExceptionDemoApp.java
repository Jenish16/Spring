package com.jen.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jen.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n Main Program AroundDemoApp");
		
		System.out.println("Calling getFortune");
	
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);
	
		System.out.println("\n My Fortune is : "+data);
	
		context.close();
	}

}
