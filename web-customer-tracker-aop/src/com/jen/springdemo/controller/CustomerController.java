package com.jen.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jen.springdemo.entity.Customer;
import com.jen.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customer Service
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder databinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		
		databinder.registerCustomEditor(String.class, ste);
	}
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers", customers);
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult ) {
		
		if(theBindingResult.hasErrors()) {
			
			return "customer-form";
			
		}else {
			customerService.saveCustomer(theCustomer);
			
			return "redirect:/customer/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theId,
			Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID") int theId,
			Model theModel) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
