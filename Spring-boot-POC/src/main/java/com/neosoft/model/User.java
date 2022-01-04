package com.neosoft.model;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@NonNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(max = 30)
	@Column(name = "name")
	private String name;
	
	@NonNull
	@Size(max = 30)
	@Column(name = "surname")
	private String surname;
	
	@NonNull
	@Size(max = 13, min = 10)
	@Column(name = "contact", unique = true)
	private String contact;
	
	@NonNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NonNull
	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	private Date dateOfBirth;
	
	@NonNull
	@Temporal(TemporalType.DATE)
	@Column(name = "joindate")
	private Date joiningDate;
	
	@NonNull
	@Size(max = 100)
	@Column(name = "address")
	private String address;
	
	@NonNull
	@Size(max = 100)
	@Column(name = "city")
	private String city;
	
	@NonNull
	@Size(max = 100)
	@Column(name = "state")
	private String state;
	
	@NonNull
	@Size(max = 100)
	@Column(name = "country")
	private String country;
	
	@NonNull
	@Size(max = 6, min = 6)
	@Column(name = "pincode")
	private String pincode;
	
	private int deleted = 0;
}
