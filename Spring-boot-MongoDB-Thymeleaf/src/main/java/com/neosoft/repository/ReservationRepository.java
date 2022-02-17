package com.neosoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>{

}
