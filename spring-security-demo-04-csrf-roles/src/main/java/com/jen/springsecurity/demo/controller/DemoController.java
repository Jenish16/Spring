package com.jen.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
//		return "plain-login";
		return "fency-login";
	}
}
