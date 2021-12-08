package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Renter;

public interface RenterRepository extends JpaRepository<Renter, Integer>{
	
	Renter findByEmail(String email);
}
