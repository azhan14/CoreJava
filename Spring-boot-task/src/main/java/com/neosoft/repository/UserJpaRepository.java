package com.neosoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.UserJpa;

public interface UserJpaRepository extends JpaRepository<UserJpa, Long>{
	
	List<UserJpa> findByUname(String uname);
}
