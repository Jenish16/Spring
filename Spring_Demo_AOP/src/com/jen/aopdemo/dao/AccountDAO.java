package com.jen.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.jen.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vip) {
		
		System.out.println(getClass()+": Doing my db work");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+": doWork()");
		return false;
	}
}
