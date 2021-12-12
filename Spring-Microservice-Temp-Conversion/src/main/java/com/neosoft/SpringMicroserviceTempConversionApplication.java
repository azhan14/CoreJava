package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringMicroserviceTempConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceTempConversionApplication.class, args);
	}

}
