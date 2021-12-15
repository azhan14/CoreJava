package com.neosoft.bootstrap;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.time.ZoneId;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.neosoft.model.Resident;
import com.neosoft.service.ResidentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class DefaultResidentLoader implements CommandLineRunner{
	private static final String[] GENDER = {"Male", "Female", "Transgender", "Not to specify"};
    private static final Random RANDOM = new Random();
 
    private final ResidentService service;
    private final Faker faker;
	
	@Override
	public void run(String... args) throws Exception {
		loadResidentsData();
	}
	
	public void loadResidentsData() {
		if (service.getResidentCount() == 0) {
            for (int x = 0; x < 100; x++) {
                service.save(createNewResident());
            }
            log.info("Default residents are successfully saved in the database.");
        } else {
            log.info("Default residents are already present in the database.");
        }
	}
	
	private Resident createNewResident() {
        final String firstName = faker.name().firstName();
        final String lastName = faker.name().lastName();
        final String emailAddress = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@company.com";
        final LocalDate birthdate = faker.date().birthday(25, 58).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        final int age = Period.between(birthdate, LocalDate.now()).getYears();
        final String gender = GENDER[RANDOM.nextInt(GENDER.length)];
 
        return Resident.builder()
                .fullName(firstName + " " + lastName)
                .age(age)
                .gender(gender)
                .phoneNumber(faker.phoneNumber().cellPhone())
                .emailAddress(emailAddress)
                .dateOfBirth(birthdate)
                .homeAddress(faker.address().fullAddress())
                .nationality(faker.nation().nationality())
                .firstLanguage(faker.nation().language())
                .build();
    }

}
