package com.neosoft.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Resident;

@Repository
public interface ResidentRepository extends PagingAndSortingRepository<Resident, Integer>{

}
