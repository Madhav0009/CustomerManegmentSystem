package com.example.CMS.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.entity.Customer;
import com.example.CMS.service.CustomerService;



@RestController
public class CustomerController {
	
	CustomerService cService;
	
	public CustomerController(CustomerService cService) {
		super();
		this.cService = cService;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Customer cus) {
//		System.out.println(cus);
		if(cService.validate(cus))
			return "login success!";
		else
			return "login fail";
	}
	
	@PostMapping("/register")
	public String register(@RequestBody Customer cus) {
		return cService.addUser(cus);
	}
}