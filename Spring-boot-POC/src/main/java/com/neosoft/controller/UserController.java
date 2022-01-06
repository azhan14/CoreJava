package com.neosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.User;
import com.neosoft.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUser();
	}
	
	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable Long id) {
		userService.updateUser(user, id);
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
		userService.softDelete(id);
	}
	
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable Long id) {
		userService.delete(id);
	}
}
