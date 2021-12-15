package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.neosoft.model.Resident;
import com.neosoft.repository.ResidentRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResidentService {
	
	@Autowired
	private ResidentRepository residentRepository;
	
	public long getResidentCount() {
		log.info("Finding the total count of residents from the dB.");
        return residentRepository.count();
	}
	
	public void save(final Resident resident) {
		residentRepository.save(resident);
	}
	
	public Page<Resident> getPaginatedResidents(final int pageNumber, final int pageSize) {
        log.info("Fetching the paginated residents from the dB.");
        final Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return residentRepository.findAll(pageable);
    }
}
