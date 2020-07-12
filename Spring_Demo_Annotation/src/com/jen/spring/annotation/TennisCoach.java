package com.jen.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {
//	@Autowired
//	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	@Value("${jen.email}")
	private String email;
	
	@Value("${jen.team}")
	private String team;
	
	
//	@Autowired
//	//@Qualifier("happyFortuneService")
//	public TennisCoach(@Qualifier("happyFortuneService") FortuneService theFortuneService)
//	{
//		fortuneService = theFortuneService;
//	}
	
	@Autowired
	@Qualifier("databaseFortuneService")
	public void setFortuneService(FortuneService theFortuneService)
	{
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volly";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getTeam()
	{
		return team;
	}


	//define my init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println("Do my start up stuff called");
	}
	
	//define my destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println("Do my cleanup stuff called");
	}
}
