package com.jen.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm()
	{
		return "helloWorldForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm()
	{
		return "helloWorld";
	}
	
	
	  @RequestMapping("/processFormVersionTwo")
	  public String letsShoutDude(HttpServletRequest request, Model model) 
	  { 
		  String theName = request.getParameter("studentName");
	  
		  theName = "Yo! " + theName.toUpperCase();
	  
		  model.addAttribute("message", theName);
	  
		  return "helloWorld"; 
	  }
	 
	
	
	  @RequestMapping("/processFormVersionThree") 
	  public String letsShoutDude(@RequestParam("studentName") String theName, Model model)
	  {
		  
		  theName = "Yo! " + theName.toUpperCase();
		  
		  model.addAttribute("message", theName);
		  
		  return "helloWorld"; 
	  }
	 
}
