package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FeedbackResponse;
import com.example.demo.service.InterviewFeedbackService;
@CrossOrigin("*")
@RestController
public class InterviewFeedbackController {

	@Autowired
	private InterviewFeedbackService interviewFeedbackService;
	
	@RequestMapping(value="/interviewfeedback",method=RequestMethod.PATCH)
	public void feedback(@RequestBody Feedback feedback) {
		interviewFeedbackService.feedback(feedback.getInterviewid(), feedback.getFeedback());
	}
	
	@RequestMapping(value="/getfeedback/{interviewId}",method=RequestMethod.GET)
	public FeedbackResponse getFeedback(@PathVariable int interviewId) {
		
		return interviewFeedbackService.getFeedback(interviewId);
		
	}
}
