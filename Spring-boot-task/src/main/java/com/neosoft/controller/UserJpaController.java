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

import com.neosoft.model.UserJpa;
import com.neosoft.service.UserJpaService;

@RestController
public class UserJpaController {
	
	@Autowired
	private UserJpaService userJpaService;
	
	@GetMapping("/jpa/users")
	public List<UserJpa> getAllUsers(){
		return userJpaService.getAll();
	}
	
	@GetMapping("/jpa/user/{id}")
	public UserJpa getUserById(@PathVariable Long id) {
		return userJpaService.getUserById(id);
	}
	
	@GetMapping("/jpa/user/uname/{uname}")
	public List<UserJpa> getUserByUname(@PathVariable String uname) {
		return userJpaService.getUserByUname(uname);
	}
	
	@PostMapping("/jpa/users")
	public UserJpa addUser(@RequestBody UserJpa user) {
		return userJpaService.addUser(user);
	}
	
	@PutMapping("/jpa/user/{id}")
	public void updateUser(@PathVariable Long id, @RequestBody UserJpa user) {
		userJpaService.updateUser(user,id);
	}
	
	@DeleteMapping("/jpa/user/{id}")
	public void deletUser(@PathVariable Long id) {
		userJpaService.deleteUser(id);
	}
	
	@GetMapping("/jpa/users/sortByUname")
	public List<UserJpa> getUserSortByUname(){
		List<UserJpa> users = userJpaService.getAll();
		return userJpaService.getUsersSortByUname(users);
	}
	
	@GetMapping("/jpa/users/sortByUpass")
	public List<UserJpa> getUserSortByUpass(){
		List<UserJpa> users = userJpaService.getAll();
		return userJpaService.getUsersSortByUpass(users);
	}
}
