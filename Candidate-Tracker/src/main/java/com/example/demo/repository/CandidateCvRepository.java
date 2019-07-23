package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CandidateCv;

@Repository
public interface CandidateCvRepository extends JpaRepository<CandidateCv, Integer>{

	List<CandidateCv> findByCandidateId(int id);

	List<CandidateCv> findByEmail(String email);

}
