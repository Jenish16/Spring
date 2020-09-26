package com.jen.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		
		System.out.println(getClass()+": Doing my db work");
	}
	
	public boolean addSilly() {
		
		System.out.println(getClass()+": Doing my db work");
		return true;
	}
	public void gotoSleep() {
		System.out.println(getClass()+":I am going to sleep");
	}
}
