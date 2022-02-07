package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neosoft.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.deleted = 0")
	List<User> getAllUser();
	
	@Query("SELECT u FROM User u WHERE u.deleted = 0 AND u.name = ?1")
	List<User> findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.deleted = 0 AND u.surname = ?1")
	List<User> findBySurname(String surname);
	
	@Query("SELECT u FROM User u WHERE u.deleted = 0 AND u.pincode = ?1")
	List<User> findByPincode(String pincode);
	
	@Transactional
	@Modifying
	@Query("UPDATE User u SET u.deleted = 1 WHERE u.id = ?1")
	void softDelete(Long id);
}
