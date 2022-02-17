package com.neosoft.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.neosoft.model.Reservation;
import com.neosoft.repository.ReservationRepository;

@Service
public class ReservationService {
	private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
    
    @Autowired
    MongoTemplate mongoTemplate;

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public Iterable<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public void deleteAllReservations(){
        reservationRepository.deleteAll();
    }

    public void deleteReservationById(Long id){
        reservationRepository.deleteById(id);
    }

    public Optional<Reservation> findReservationById(Long id){
        return reservationRepository.findById(id);
    }
    
    public Iterable<Reservation> searchReservation(String text){
    	return mongoTemplate.find(Query.query(new Criteria()
    			.orOperator(Criteria.where("firstName").regex(text,"i"), 
    					Criteria.where("lastName").regex(text,"i"),
    					Criteria.where("mobileNumber").regex(text, "i"),
    					Criteria.where("emailId").regex(text,"i"))
    			), Reservation.class);
    }
}
