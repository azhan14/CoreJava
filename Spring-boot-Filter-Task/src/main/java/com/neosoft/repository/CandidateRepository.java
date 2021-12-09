package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}
