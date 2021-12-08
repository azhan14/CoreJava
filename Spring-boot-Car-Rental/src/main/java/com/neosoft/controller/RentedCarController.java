package com.neosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neosoft.model.Car;
import com.neosoft.model.Customer;
import com.neosoft.model.RentedCar;
import com.neosoft.model.Status;
import com.neosoft.service.CarService;
import com.neosoft.service.RentedCarService;

@Controller
public class RentedCarController {
	
	@Autowired
	private RentedCarService rentedCarService;
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/addrentedcar")
	public String addRentedCar(@ModelAttribute("car") Car car, @ModelAttribute("customer") Customer customer) {
		RentedCar rentedCar = new RentedCar();
		rentedCar.setNumber(car.getNumber());
		rentedCar.setId(customer.getId());
		rentedCar.setName(customer.getName());
		rentedCar.setPrice(car.getPrice());
		
		rentedCarService.saveRentedCar(rentedCar);
		
		Car oldCar = carService.findCarByNumber(car.getNumber());
		Car updateCar = new Car();
		updateCar.setNumber(oldCar.getNumber());
		updateCar.setName(oldCar.getName());
		updateCar.setMf(oldCar.getMf());
		updateCar.setYear(oldCar.getYear());
		updateCar.setPrice(oldCar.getPrice());
		updateCar.setStatus(Status.NO);
		carService.saveCar(updateCar);
		return "rentcarsuccess";
	}
	
	@GetMapping("/rentedcar")
	public String getRentedCar(Model model) {
		model.addAttribute("rentedcars", rentedCarService.getRentedCar());
		return "rentedcar";
	}
	
	@GetMapping("/car/return/{id}")
	public String returnCar(@PathVariable String id) {
		RentedCar rentedCar = rentedCarService.getRentedCarByNumber(id);
		RentedCar updateRentedCar = new RentedCar();
		updateRentedCar.setId(rentedCar.getId());
		updateRentedCar.setName(rentedCar.getName());
		updateRentedCar.setNumber(rentedCar.getNumber());
		updateRentedCar.setPrice(rentedCar.getPrice());
		updateRentedCar.setReturnstatus(Status.YES);
		rentedCarService.saveRentedCar(updateRentedCar);
		
		Car car = carService.findCarByNumber(id);
		Car updateCar = new Car();
		updateCar.setNumber(car.getNumber());
		updateCar.setName(car.getName());
		updateCar.setMf(car.getMf());
		updateCar.setYear(car.getYear());
		updateCar.setPrice(car.getPrice());
		updateCar.setStatus(Status.YES);
		carService.saveCar(updateCar);
		
		return "redirect:/rentedcar";
	}
}
