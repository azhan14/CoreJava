package com.neosoft.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.neosoft.controller.ReservationThymeleafController;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.model.Reservation;
import com.neosoft.service.ReservationService;
import com.neosoft.service.SequenceGeneratorService;

@WebMvcTest(value = ReservationThymeleafController.class)
public class ReservationThymeleafControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ReservationService reservationService;
	
	@MockBean
	private SequenceGeneratorService sequenceGeneratorService;
	
	@Test
	void contextLoads() {
	}
	
	Reservation reservation1 = new Reservation(1L, "Drake", "Bell", "1234123412", 
			"drake.bell@gmail.com", "Wisconsin", "Texas", LocalDateTime.now());
	
	Reservation reservation2 = new Reservation(2L, "Miley", "Cyrus", "1234561234", 
			"miley.cyrus@gmail.com", "Dadar", "Mumbai", LocalDateTime.now());
	
	Reservation reservation3 = new Reservation(3L, "Manhat", "tan", "12341567812", 
			"manhat.tan@gmail.com", "Kulumbi", "kerala", LocalDateTime.now());
	
	@Test
	public void getAllRecords() throws Exception{
		List<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(reservation1);
		reservations.add(reservation2);
		reservations.add(reservation3);
		
		Mockito.when(reservationService.getAllReservations()).thenReturn(reservations);
		
		mockMvc.perform(get("/reservations-ui"))
		.andExpect(status().isOk())
		.andExpect(view().name("reservations"))
		.andExpect(model().attribute("reservations", reservations));
	}
	
	@Test
	public void deleteReservationById() throws Exception {
		List<Reservation> reservations = new ArrayList<Reservation>();
		reservations.add(reservation2);
		reservations.add(reservation3);
		
		Mockito.when(reservationService.findReservationById(reservation1.getId()))
			.thenReturn(Optional.of(reservation1));
		
		Mockito.when(reservationService.getAllReservations()).thenReturn(reservations);
		
		mockMvc.perform(get("/delete-reservation/1"))
		.andExpect(status().isOk())
		.andExpect(view().name("reservations"))
		.andExpect(model().attribute("reservations", reservations));
		
	}
	
	@Test
	public void deleteReservationById_NotFound() throws Exception{
		mockMvc.perform(get("/delete-reservation/4"))
		.andExpect(status().isNotFound())
		.andExpect(result -> 
		assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
		.andExpect(result -> 
		assertEquals("Reservation with ID : 4 Not Found", result.getResolvedException().getMessage()));
		
	}
	
	@Test
	public void editReservationById_NotFound() throws Exception{
		mockMvc.perform(get("/edit-add-reservation/4"))
		.andExpect(status().isNotFound())
		.andExpect(result -> 
		assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
		.andExpect(result -> 
		assertEquals("Reservation with ID : 4 Not Found", result.getResolvedException().getMessage()));
	}
}
