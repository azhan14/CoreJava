package com.neosoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Customer;
import com.neosoft.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customerregister")
	public String createCustomerForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customerregisterform";
	}
	
	@PostMapping("/customeradd")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customerregistersuccess";
	}
	
	@GetMapping("/customerregistersuccess")
	public String customerRegisterSuccess(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customerregistersuccess";
	}
	
	@GetMapping("/customerloginform")
	public String createCustomerLoginForm(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customerlogin";
	}
	
	@GetMapping("/customerloginunsuccess")
	public String customerLoginUnsuccess(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customerloginunsuccess";
	}
	
	@PostMapping("/customerloginauth")
	public String loginCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {
		Customer savedCustomer = customerService.getCustomerByEmail(customer.getEmail());
		if(savedCustomer.getPassword().equals(customer.getPassword())) {
			request.getSession().setAttribute("savedcustomerid", savedCustomer.getId());
			return "customerhome";
		} else {
			return "redirect:/customerloginunsuccess";
		}
	}
	
	@GetMapping("/customerhome")
	public String customerHome() {
		return "customerhome";
	}
	
	@GetMapping("/showprofile")
	public String showProfile(HttpSession session, Model model) {
		int id = (int) session.getAttribute("savedcustomerid");
		model.addAttribute("customer", customerService.getCustomerById(id));
		
		return "showprofile";
	}
	
	@GetMapping("/editcustomerform")
	public String editCustomerForm(Model model, HttpSession session) {
		int id = (int) session.getAttribute("savedcustomerid");
		model.addAttribute("customer", customerService.getCustomerById(id));
		
		return "editcustform";
	}
	
	@PostMapping("/editcust")
	public String editCustomer(@ModelAttribute("customer") Customer customer) {
		Customer updateCustomer = new Customer();
		updateCustomer.setId(customer.getId());
		updateCustomer.setName(customer.getName());
		updateCustomer.setEmail(customer.getEmail());
		updateCustomer.setPassword(customer.getPassword());
		updateCustomer.setContact(customer.getContact());
		customerService.updateCustomer(updateCustomer);
		return "redirect:/showprofile";
	}
}
