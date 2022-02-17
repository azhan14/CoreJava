package com.neosoft.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

@Data
@Document(collection = "reservations")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
	
	@Transient
	public static final String SEQUENCE_NAME = "reservations_sequence";
	
	@Id
	private Long id;
	
	@NotBlank(message = "Please Provide a first Name")
	private String firstName;
	
	@NotBlank(message = "Please Provide a last Name")
	private String lastName;
	
	@NotBlank(message = "Please Provide a 10 digit mobile number")
	@Size(max = 13, min = 10, message = "size must be between 10 and 13")
	private String mobileNumber;
	
	@NotBlank(message = "Please Provide a valid email ID")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Flag.CASE_INSENSITIVE, message = "Please Provide a valid email ID")
	private String emailId;
	
	@NotBlank(message = "Please Provide a state")
	private String state;
	
	@NotBlank(message = "Please Provide a city")
	private String city;
	
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm")
	private LocalDateTime date;
}
