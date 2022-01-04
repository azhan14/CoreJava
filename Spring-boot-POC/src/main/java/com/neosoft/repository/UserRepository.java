package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neosoft.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.deleted = 0")
	List<User> getAllUser();
	
	List<User> findByName(String name);
	
	List<User> findBySurname(String surname);
	
	List<User> findByPincode(String pincode);
}
