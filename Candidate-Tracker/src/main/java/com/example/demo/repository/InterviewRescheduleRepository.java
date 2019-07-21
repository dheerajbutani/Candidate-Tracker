package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.model.RescheduleStatus;

@Repository
public interface InterviewRescheduleRepository extends JpaRepository<InterviewRescheduleRequest, Integer>{


	List<InterviewRescheduleRequest> findAllByRescheduleStatus(RescheduleStatus awaitingresponse);

	
	
}
