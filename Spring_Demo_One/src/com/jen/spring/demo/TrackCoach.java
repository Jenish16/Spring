package com.jen.spring.demo;

public class TrackCoach implements Coach {

	
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("Track coach insatance created");
	}
	
	public TrackCoach() {
		System.out.println("Track coach insatance created");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It : " + fortuneService.getFortune();
	}
	
	//add an init method
	public void doMyStartupStuff()
	{
		System.out.println("TrackCoach: inside doMyStartupStuff");
	}
	//add a destroy method
	public void doMyCleanupStuff()
	{
		System.out.println("TrackCoach: inside doMyCleanupStuff");
	}
}
