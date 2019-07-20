package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InterviewsDisplay;
import com.example.demo.model.Candidate;
import com.example.demo.model.Interview;
import com.example.demo.model.InterviewStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.InterviewRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.InterviewRequest;

@Service
public class InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;
	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private UserRepository userRepository;
	public void addInterview(InterviewRequest interviewRequest) {

		Interview interview=new Interview();
		Optional<LoginUser> interviewer=userRepository.findById(interviewRequest.getInterviewerId());
		
		Optional<Candidate> candidate = candidateRepository.findById(interviewRequest.getCandidateId());
		if (candidate.isPresent()) {
			candidate.get().setRound(candidate.get().getRound() + 1);
			candidateRepository.save(candidate.get());
			interview.setCandidate(candidate.get());
			interview.setInterviewer(interviewer.get());
			interview.setRound(candidate.get().getRound());
			interview.setInterviewDate(LocalDate.now());
			interview.setReschedule(0);
			interview.setStatus(InterviewStatus.PENDING);
			interviewRepository.save(interview);
		
		}
		
		}
		
	
	
	public List<InterviewsDisplay> getInterviews(int interviewer_id,InterviewStatus interviewStatus) {
	List<Interview>interviews=interviewRepository.findByInterviewerIdAndStatus(interviewer_id,interviewStatus);
	
	List<InterviewsDisplay> interviewsDisplayList=new ArrayList<>();
	
	for(Interview interview:interviews) {
		InterviewsDisplay interviewsDisplay=new InterviewsDisplay();

		interviewsDisplay.setCandidateId(interview.getCandidate().getId());
		interviewsDisplay.setEmail(interview.getCandidate().getEmail());
		interviewsDisplay.setFirstName(interview.getCandidate().getFirstName());
		interviewsDisplay.setLastName(interview.getCandidate().getLastName());
		interviewsDisplay.setMobile(interview.getCandidate().getMobile());
		interviewsDisplay.setFeedback(interview.getFeedback());
		interviewsDisplay.setId(interview.getId());
		interviewsDisplay.setInterviewDate(interview.getInterviewDate());
		interviewsDisplay.setInterviewTime(interview.getInterviewTime());
		interviewsDisplay.setReschedule(interview.getReschedule());
		interviewsDisplay.setRound(interview.getRound());
		interviewsDisplay.setStatus(interview.getStatus());
		interviewsDisplayList.add(interviewsDisplay);
	}
	
	
	
	System.out.println(interviews);
	return interviewsDisplayList;
	}
	
	
	
	
	
	
	
}
