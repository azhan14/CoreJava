package com.neosoft.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.neosoft.model.User;

@Service
public class UserService {
	
	private List<User> users = new ArrayList<User>(Arrays.asList(
			new User(101,"sree","sree123"),
			new User(102,"mak","mak123"),
			new User(103,"prat","prat123"),
			new User(104,"amaan","amaan123"),
			new User(105,"sam","aatyubbc")
			));
	
	
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUser(int id) {
		return users.stream().filter(u -> u.getId() == id).findFirst().get();
	}
	
	public User getUserByUname(String uname) {
		return users.stream().filter(u -> u.getUname().equals(uname)).findFirst().get();
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public void deleteUser(int id) {
		users.removeIf(u -> u.getId() == id);
	}
	
	public void updateUser(User user, int id) {
		users.replaceAll(u -> {
			if(u.getId() == id)
				u = user;
			return u;
		});
	}
	
	public List<User> getUserSortByUname() {
		Comparator<User> byUnameComparator = Comparator.comparing(User::getUname);
		return users.stream().sorted(byUnameComparator).collect(Collectors.toList());
	}
	
	public List<User> getUserSortByUpass() {
		Comparator<User> byUpassComparator = Comparator.comparing(User::getUpass);
		return users.stream().sorted(byUpassComparator).collect(Collectors.toList());
	}
}
