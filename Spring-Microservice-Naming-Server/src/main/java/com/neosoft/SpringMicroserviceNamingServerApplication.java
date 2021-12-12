package com.neosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringMicroserviceNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroserviceNamingServerApplication.class, args);
	}

}
