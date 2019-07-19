package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			interview.setReschedule(0);
			interview.setStatus(InterviewStatus.PENDING);
			interviewRepository.save(interview);
		
		}
		
		}
		
	
	
	public List<Interview> getInterviews(int interviewer_id,InterviewStatus interviewStatus) {
	List<Interview>interviews=interviewRepository.findByInterviewerAndStatus(interviewer_id,interviewStatus);
	return interviews;
	}
	
	
	
	
	
	
	
}
