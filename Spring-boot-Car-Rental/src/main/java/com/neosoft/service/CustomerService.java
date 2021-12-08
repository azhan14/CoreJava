package com.neosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Customer;
import com.neosoft.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
}
