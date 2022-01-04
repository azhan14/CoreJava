package com.neosoft.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public List<User> getAllUser(){
		return userRepository.getAllUser();
	}
	
	public void updateUser(User user, Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.save(user);
		}
	}
	
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public List<User> findBySurname(String surname) {
		return userRepository.findBySurname(surname);
	}
	
	public List<User> findByPincode(String pincode) {
		return userRepository.findByPincode(pincode);
	}
	
	public List<User> getSortedUserByDob(List<User> users){
		Comparator<User> byDobComparator = Comparator.comparing(User::getDateOfBirth);
		return users.stream().sorted(byDobComparator).collect(Collectors.toList());
	}
	
	public List<User> getSortedUserByJoinDate(List<User> users){
		Comparator<User> byJoinDateComparator = Comparator.comparing(User::getJoiningDate);
		return users.stream().sorted(byJoinDateComparator).collect(Collectors.toList());
	}
	
}	
