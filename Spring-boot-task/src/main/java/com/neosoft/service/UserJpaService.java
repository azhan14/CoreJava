package com.neosoft.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.UserJpa;
import com.neosoft.repository.UserJpaRepository;

@Service
public class UserJpaService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	public List<UserJpa> getAll(){
		return userJpaRepository.findAll();
	}
	
	public UserJpa getUserById(Long id) {
		return userJpaRepository.findById(id).get();
	}
	
	public List<UserJpa> getUserByUname(String uname) {
		return userJpaRepository.findByUname(uname);
	}
	
	public UserJpa addUser(UserJpa user) {
		return userJpaRepository.save(user);
	}
	
	public void updateUser(UserJpa user, Long id) {
		userJpaRepository.save(user);
	}
	
	public void deleteUser(Long id) {
		userJpaRepository.deleteById(id);
	}
	
	public List<UserJpa> getUsersSortByUname(List<UserJpa> users){
		Comparator<UserJpa> byUnameComparator = Comparator.comparing(UserJpa::getUname);
		return users.stream().sorted(byUnameComparator).collect(Collectors.toList());
	}
	
	public List<UserJpa> getUsersSortByUpass(List<UserJpa> users){
		Comparator<UserJpa> byUnameComparator = Comparator.comparing(UserJpa::getUpass);
		return users.stream().sorted(byUnameComparator).collect(Collectors.toList());
	}
}
