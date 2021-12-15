package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootPaginationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootPaginationApplication.class, args);
		log.info("Springboot Pagination with Thymeleaf application is started successfully .");
	}

}
