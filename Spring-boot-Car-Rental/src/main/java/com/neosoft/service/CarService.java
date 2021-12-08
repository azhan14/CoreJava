package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Car;
import com.neosoft.model.Status;
import com.neosoft.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}
	
	public Car findCarByNumber(String  number) {
		return carRepository.findById(number).get();
	}
	
	public int findByNumber(String number) {
		int status = 0;
		if(carRepository.existsById(number))
			status = 1;
		return status;
	}
	
	public List<Car> getAllCars(){
		return carRepository.findAll();
	}
	
	public Car updateCar(Car car) {
		return carRepository.save(car);
	}
	
	public void deleteCarById(String number) {
		carRepository.deleteById(number);
	}
	
	public List<Car> getAvailableCar() {
		return carRepository.findByStatus(Status.YES);
	}
}
