  package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.InterviewRescheduleView;
import com.example.demo.model.Interview;
import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.service.InterviewRescheduleService;
import com.example.demo.service.InterviewService;

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
	interviewService.setInterviewReschedule(interviewRescheduleRequest.getInterviewId());
	}
	
	
	@RequestMapping(value="/getinterviewreschedulerequests/{recruiterid}",method=RequestMethod.GET)
	public List<InterviewRescheduleView> getreschedulerequests(@PathVariable int recruiterid) {
	List<Interview>interviews=interviewService.getInterviews(recruiterid);
	
	return	interviewRescheduleService.getRescheduleRequests(interviews);
		
	}	
	@RequestMapping(value="/approverequest/{requestId}",method=RequestMethod.PATCH)
	public void approveRequest(@PathVariable int requestId) {
	interviewRescheduleService.approveRequest(requestId);	
InterviewRescheduleRequest interviewRescheduleRequest=	interviewRescheduleService.getRescheduleRequests(requestId);
	interviewRescheduleService.approveRequest(interviewRescheduleRequest.getId());
	int interviewId=interviewRescheduleService.getInterviewId(requestId);
		interviewService.resetInterviewReschedule(interviewId);
	}
	 
	@RequestMapping(value="/rejectrequest/{requestId}",method=RequestMethod.PATCH)
	public void rejectRequest(@PathVariable int requestId) {
		interviewRescheduleService.rejectRequest(requestId);	
		int interviewId=interviewRescheduleService.getInterviewId(requestId);
		interviewService.resetInterviewReschedule(interviewId);
		
	}

}
