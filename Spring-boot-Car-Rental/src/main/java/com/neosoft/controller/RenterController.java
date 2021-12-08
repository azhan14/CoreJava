package com.neosoft.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Renter;
import com.neosoft.service.RenterService;

@Controller
public class RenterController {
	
	@Autowired
	private RenterService renterService;
	
	@GetMapping("/renterregister")
	public String createRenterForm(Model model) {
		Renter renter = new Renter();
		model.addAttribute("renter", renter);
		
		return "renterregisterform";
	}
	
	@PostMapping("/renteradd")
	public String addRenter(@ModelAttribute("renter") Renter renter) {
		renterService.saveRenter(renter);
		return "redirect:/renterregistersuccess";
	}
	
	@GetMapping("/renterregistersuccess")
	public String renterRegisterSuccess(Model model) {
		Renter renter = new Renter();
		model.addAttribute(renter);
		
		return "renterregistersuccess";
	}
	
	@GetMapping("/renterloginform")
	public String createRenterLoginForm(Model model) {
		Renter renter = new Renter();
		model.addAttribute(renter);
		
		return "renterlogin";
	}
	
	@GetMapping("/renterloginunsuccess")
	public String renterLoginUnsuccess(Model model) {
		Renter renter = new Renter();
		model.addAttribute(renter);
		
		return "renterloginunsuccess";
	}
	
	@PostMapping("/renterloginauth")
	public String loginRenter(@ModelAttribute("renter2") Renter renter, HttpServletRequest request) {
		Renter savedRenter = renterService.getRenterByEmail(renter.getEmail());
		if(savedRenter.getPassword().equals(renter.getPassword())) {
			request.getSession();
			return "renterhome";
		}
		else {
			return "redirect:/renterloginunsuccess";
		}
	}
	
	@GetMapping("/renterhome")
	public String renterHome() {
		return "renterhome";
	}
	
	@GetMapping("/renterlogout")
	public String logoutRenter(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:";
	}
}
