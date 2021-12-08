package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.RentedCar;
import com.neosoft.model.Status;

public interface RentedCarRepository extends JpaRepository<RentedCar, String>{
	
	List<RentedCar> findByReturnstatus(Status status);
}
