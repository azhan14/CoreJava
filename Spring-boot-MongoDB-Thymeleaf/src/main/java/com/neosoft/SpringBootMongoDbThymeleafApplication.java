package com.neosoft;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.neosoft.model.Reservation;
import com.neosoft.service.ReservationService;
import com.neosoft.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootMongoDbThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbThymeleafApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(ReservationService reservationService, SequenceGeneratorService sequenceGeneratorService) {
		return (args) -> {
			log.info("Generating sample data");
			reservationService.deleteAllReservations();
			List<List<String>> reservations = Arrays.asList(Arrays.asList("Bob","Marley","9090123445","bob.marley@gmail.com","Ohio","Kansas")
					,Arrays.asList("David","Dobrik","9876123450","david.d@gmail.com","California","LA"));
			reservations.forEach(reservation -> 
					reservationService.saveReservation(Reservation.builder()
							.id(sequenceGeneratorService.generateSequence(Reservation.SEQUENCE_NAME))
							.firstName(reservation.get(0))
							.lastName(reservation.get(1))
							.mobileNumber(reservation.get(2))
							.emailId(reservation.get(3))
							.state(reservation.get(4))
							.city(reservation.get(5))
							.date(LocalDateTime.now())
							.build()));
			
			reservationService.getAllReservations().forEach(reservation -> 
			log.info("RESERVATION --> " + reservation.getFirstName() + " ID: " + reservation.getId()));
		};
	}

}
