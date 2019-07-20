package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.FeedbackResponse;
import com.example.demo.model.Interview;
import com.example.demo.repository.InterviewRepository;
import com.example.demo.web.Feedback;

@Service
public class InterviewFeedbackService {

	@Autowired
	private InterviewRepository interviewRepository;

	public void feedback(int id, String feedback) {
		Optional<Interview> interview = interviewRepository.findById(id);
		interview.get().setFeedback(feedback);
		interviewRepository.save(interview.get());

	}
	
	public FeedbackResponse getFeedback(int interviewId) {
		
		Optional<Interview> interview=interviewRepository.findById(interviewId);
		FeedbackResponse feedbackResponse=new FeedbackResponse();
				feedbackResponse.setFeedback(interview.get().getFeedback());
				return feedbackResponse;
		
	}
}