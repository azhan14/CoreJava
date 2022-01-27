package com.neosoft.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.exception.InvalidRequestException;
import com.neosoft.model.User;
import com.neosoft.repository.UserRepository;
import com.neosoft.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) {
		if(user == null || user.getId() == null) {
			throw new InvalidRequestException("User or Id must not be null!");
		}
		Optional<User> optionalUser = userService
				.findById(id);
		if(!optionalUser.isPresent()) {
			throw new InvalidRequestException("User with ID " + 
        			user.getId() + " does not exist.");
		}
		User existingUser = optionalUser.get();
		existingUser.setName(user.getName());
		existingUser.setSurname(user.getSurname());
		existingUser.setContact(user.getContact());
		existingUser.setGender(user.getGender());
		existingUser.setDateOfBirth(user.getDateOfBirth());
		existingUser.setJoiningDate(user.getJoiningDate());
		existingUser.setAddress(user.getAddress());
		existingUser.setCity(user.getCity());
		existingUser.setState(user.getState());
		existingUser.setCountry(user.getCountry());
		existingUser.setPincode(user.getPincode());
		
		return userService.updateUser(existingUser);
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/user/name/{name}")
	public List<User> getUserByName(@PathVariable String name) {
		return userService.findByName(name);
	}
	
	@GetMapping("/user/surname/{surname}")
	public List<User> getUserBySurname(@PathVariable String surname) {
		return userService.findBySurname(surname);
	}
	
	@GetMapping("/user/pincode/{pincode}")
	public List<User> getUserByPincode(@PathVariable String pincode) {
		return userService.findByPincode(pincode);
	}
	
	@GetMapping("/users/sortbydob")
	public List<User> getUserSortByDob(){
		List<User> users = userService.getAllUser();
		return userService.getSortedUserByDob(users);
	}
	
	@GetMapping("/users/sortbyjoindate")
	public List<User> getUserSortByJoinDate(){
		List<User> users = userService.getAllUser();
		return userService.getSortedUserByJoinDate(users);
	}
	
	@PutMapping("/user/softdelete/{id}")
	public void softDeleteUser(@PathVariable Long id) {
		if(!userService.findById(id).isPresent()) {
			throw new InvalidRequestException("User with ID " + 
        			id + " does not exist.");
		}
		userRepository.softDelete(id);
	}
	
	@DeleteMapping("/users/delete/{id}")
	public void delete(@PathVariable Long id) {
		if(!userService.findById(id).isPresent()) {
			throw new InvalidRequestException("User with ID " + 
        			id + " does not exist.");
		}
		userRepository.deleteById(id);
	}
}
