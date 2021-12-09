package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.neosoft.model.Candidate;
import com.neosoft.repository.CandidateRepository;

@RestController
public class CandidateController {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@GetMapping("/candidates")
	public MappingJacksonValue getAllCandidates() {
		List<Candidate> candidates = candidateRepository.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		FilterProvider filters = new SimpleFilterProvider().addFilter("CandidateBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(candidates);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/candidates/personal")
	public MappingJacksonValue getPersonalData() {
		List<Candidate> candidates = candidateRepository.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("cid","name","age");
		FilterProvider filters = new SimpleFilterProvider().addFilter("CandidateBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(candidates);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/candidates/address")
	public MappingJacksonValue getAddressData() {
		List<Candidate> candidates = candidateRepository.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("cid","city","state","country","pin");
		FilterProvider filters = new SimpleFilterProvider().addFilter("CandidateBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(candidates);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@PostMapping("/candidates/add")
	public void addCandidate(@RequestBody Candidate candidate) {
		candidateRepository.save(candidate);
	}
}
