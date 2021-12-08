package com.neosoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Car;
import com.neosoft.model.Status;
import com.neosoft.service.CarService;
import com.neosoft.service.CustomerService;

@Controller
public class CarController {
		
	@Autowired
	private CarService carService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/addcarform")
	public String createAddCarForm(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		
		return "addcarform";
	}
	
	@PostMapping("/addcar")
	public String addCar(@ModelAttribute("car") Car car) {
		if(carService.findByNumber(car.getNumber()) == 0) {
			carService.saveCar(car);
			return "redirect:/viewcar";
		} else {
			return "addcarunsuccess";
		}
	}
	
	@GetMapping("/viewcar")
	public String viewCar(Model model) {
		model.addAttribute("cars", carService.getAllCars());
		
		return "viewcar";
	}
	
	@GetMapping("/car/edit/{id}")
	public String editCarForm(@PathVariable String id, Model model) {
		model.addAttribute("car",carService.findCarByNumber(id));
		Car car = carService.findCarByNumber(id);
		if(car.getStatus() == Status.YES) {
			return "editcaryesform";
		} else {
			return "editcarnoform";
		}
	}
	
	@PostMapping("/editcar/{id}")
	public String updateCar(@PathVariable String id, Model model, 
			@ModelAttribute("car") Car car) {
		Car existingCar = carService.findCarByNumber(id);
		existingCar.setNumber(id);
		existingCar.setName(car.getName());
		existingCar.setMf(car.getMf());
		existingCar.setYear(car.getYear());
		existingCar.setPrice(car.getPrice());
		existingCar.setStatus(car.getStatus());
		
		carService.updateCar(existingCar);
		
		return "redirect:/viewcar";
	}
	
	@GetMapping("/car/delete/{id}")
	public String deleteCar(@PathVariable String id) {
		carService.deleteCarById(id);
		return "redirect:/viewcar";
	}
	
	@GetMapping("/rentcar")
	public String showAvailableCar(Model model) {
		model.addAttribute("cars", carService.getAvailableCar());
		return "rentcar";
	}
	
	@GetMapping("/customerlogout")
	public String logoutCustomer(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:";
	}
	
	@GetMapping("/car/rent/{id}")
	public String rentCar(@PathVariable String id, Model model, HttpSession session) {
		model.addAttribute("car", carService.findCarByNumber(id));
		int custid = (int) session.getAttribute("savedcustomerid");
		model.addAttribute("customer", customerService.getCustomerById(custid));
		return "rentcarform";
	}
	
}
