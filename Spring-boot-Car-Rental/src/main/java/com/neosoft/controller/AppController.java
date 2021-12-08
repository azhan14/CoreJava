package com.neosoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/renter")
	public String viewRenterPage() {
		return "renter";
	}
	
	@GetMapping("/customer")
	public String viewCustomerPage() {
		return "customer";
	}
}
