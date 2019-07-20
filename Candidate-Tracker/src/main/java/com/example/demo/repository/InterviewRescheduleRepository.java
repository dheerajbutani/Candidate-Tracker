package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InterviewRescheduleRequest;

@Repository
public interface InterviewRescheduleRepository extends JpaRepository<InterviewRescheduleRequest, Integer>{

	
	
}
