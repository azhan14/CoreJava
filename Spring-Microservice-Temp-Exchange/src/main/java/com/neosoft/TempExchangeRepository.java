package com.neosoft;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempExchangeRepository extends JpaRepository<TempExchange, Long>{
	
	TempExchange findByFromAndTo(String from, String to);
}
