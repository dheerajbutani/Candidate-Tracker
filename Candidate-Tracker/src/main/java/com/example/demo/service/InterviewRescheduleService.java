package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.model.RescheduleStatus;
import com.example.demo.repository.InterviewRescheduleRepository;

@Service
public class InterviewRescheduleService {

	@Autowired
	private InterviewRescheduleRepository interviewRescheduleRepository;
	

	
	public void requestReschedule(InterviewRescheduleRequest interviewRescheduleRequest) {
		interviewRescheduleRequest.setRescheduleStatus(RescheduleStatus.AWAITINGRESPONSE);
		interviewRescheduleRepository.save(interviewRescheduleRequest);
		
	}
	
	
}
