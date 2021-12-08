package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Car;
import com.neosoft.model.Status;

public interface CarRepository extends JpaRepository<Car, String>{
		
	List<Car> findByStatus(Status status);
}
