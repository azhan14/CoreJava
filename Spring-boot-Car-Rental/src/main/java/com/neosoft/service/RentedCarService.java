package com.neosoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.RentedCar;
import com.neosoft.model.Status;
import com.neosoft.repository.RentedCarRepository;

@Service
public class RentedCarService {
	
	@Autowired
	private RentedCarRepository rentedCarRepository;
	
	public RentedCar saveRentedCar(RentedCar rentedCar) {
		return rentedCarRepository.save(rentedCar);
	}
	
	public List<RentedCar> getRentedCar(){
		return rentedCarRepository.findByReturnstatus(Status.NO);
	}
	
	public RentedCar getRentedCarByNumber(String number) {
		return rentedCarRepository.findById(number).get();
	}
}
