package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.model.LoginUser;
import com.example.demo.service.InterviewRescheduleService;
import com.example.demo.service.InterviewService;
import com.example.demo.service.UserAccountService;

@CrossOrigin("*")
@RestController
public class InterviewRescheduleController {

	@Autowired
	private InterviewRescheduleService interviewRescheduleService;
	
	@Autowired
private InterviewService interviewService;
	
	@RequestMapping(value="/interviewreschedulerequest",method=RequestMethod.POST)
	public void requestReschedule(@RequestBody InterviewRescheduleRequest interviewRescheduleRequest) {
		interviewRescheduleService.requestReschedule(interviewRescheduleRequest);
	interviewService.toggleInterviewReschedule(interviewRescheduleRequest.getInterviewId());
	}
	@RequestMapping(value="/getinterviewreschedulerequests/{recruiterid}",method=RequestMethod.GET)
	public void getreschedulerequests(@PathVariable int recruiterid) {
		
		
	}

}
