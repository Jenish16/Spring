package com.jen.spring.annotation;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "DatabaseFortuneService:Your Database is awesome";
	}

}
