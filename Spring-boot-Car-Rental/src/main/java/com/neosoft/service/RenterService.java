package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Renter;
import com.neosoft.repository.RenterRepository;

@Service
public class RenterService {
	
	@Autowired
	private RenterRepository renterRepository;
	
	public Renter saveRenter(Renter renter) {
		return renterRepository.save(renter);
	}
	
	public Renter getRenterByEmail(String email) {
		return renterRepository.findByEmail(email);
	}
}
