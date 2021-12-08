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
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/user/uname/{uname}")
	public User getUserByUname(@PathVariable String uname) {
		return userService.getUserByUname(uname);
	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@PutMapping("/user/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(user, id);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/user/sortByUname")
	public List<User> getUserSortByUname(){
		return userService.getUserSortByUname();
	}
	
	@GetMapping("/user/sortByUpass")
	public List<User> getUserSortByUpass(){
		return userService.getUserSortByUpass();
	}
}
