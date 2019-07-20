package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.service.InterviewRescheduleService;

@CrossOrigin("*")
@RestController
public class InterviewRescheduleController {

	@Autowired
	private InterviewRescheduleService interviewRescheduleService;
	
	@RequestMapping(value="/interviewreschedulerequest",method=RequestMethod.POST)
	public void requestReschedule(@RequestBody InterviewRescheduleRequest interviewRescheduleRequest) {
		interviewRescheduleService.requestReschedule(interviewRescheduleRequest);
	}
	

}
