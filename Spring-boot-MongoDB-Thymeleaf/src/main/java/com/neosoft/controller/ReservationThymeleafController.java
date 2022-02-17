package com.neosoft.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neosoft.model.Reservation;
import com.neosoft.service.ReservationService;
import com.neosoft.service.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ReservationThymeleafController {
	private ReservationService reservationService;
	
	@Autowired
    public ReservationThymeleafController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/reservations-ui")
    public String reservations(Model model) {
		log.info("GET : /reservations-ui (getAllReservations() service called) --> Called");
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }
	
	@GetMapping("/delete-reservation/{id}")
    public String removeReservation(@PathVariable("id") Long id, Model model) {
		log.info("GET : /delete-reservation/{"+id+"} --> Called");
        reservationService.deleteReservationById(id);
        log.info("DELETED : Reservation with ID : "+id+"");
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "reservations";
    }

    @GetMapping(value = {"/edit-add-reservation/{id}", "/edit-add-reservation"})
    public String editReservation(@PathVariable("id") Optional<Long> id, Model model) {
    	log.info("GET : /edit-add-reservation/{"+id+"} --> Called");
        Reservation reservation = id.isPresent() ?
                reservationService.findReservationById(id.get()).get() : new Reservation();
        model.addAttribute("reservation", reservation);
        return "add-edit";
    }

    @PostMapping("/save-reservation")
    public String editReservation(@ModelAttribute("reservation") @Valid Reservation reservation,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-edit";
        }
        log.info("POST : /save-reservation --> Called");
        if(reservation.getId() == null) {
        	reservation.setId(sequenceGeneratorService.generateSequence(Reservation.SEQUENCE_NAME));
        }
        reservation.setDate(LocalDateTime.now());
        reservationService.saveReservation(reservation);
        return "redirect:reservations-ui";
    }
    
    @PostMapping(value = "/search")
    public String search(Model model, @RequestParam String search) {
    	model.addAttribute("reservations",reservationService.searchReservation(search));
    	model.addAttribute("search", search);
    	return "reservations";
    }
}
