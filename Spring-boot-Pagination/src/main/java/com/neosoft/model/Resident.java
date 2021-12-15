package com.neosoft.model;

import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.*;

@Entity
@Table(name = "resident")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Resident {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
	
    @Column(name = "full_name", nullable = false)
    String fullName;
    
    @Column(name = "age", nullable = false)
    int age;
    
    @Column(name = "gender", nullable = false)
    String gender;
    
    @Column(name = "phone_number", unique = true)
    String phoneNumber;
    
    @Column(name = "email_address", nullable = false, unique = true)
    String emailAddress;
    
    @Column(name = "date_of_birth", nullable = false)
    LocalDate dateOfBirth;
    
    @Column(name = "home_address")
    String homeAddress;
    
    @Column(name = "nationality")
    String nationality;
    
    @Column(name = "first_language")
    String firstLanguage;
}
