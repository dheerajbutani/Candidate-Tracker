package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.AccountStatus;
import com.example.demo.model.Candidate;
import com.example.demo.model.Interview;
import com.example.demo.model.InterviewStatus;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Role;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.InterviewRepository;
import com.example.demo.repository.UserRepository;

public class InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;
	@Autowired
	private CandidateRepository candidateRepository;

	public void addInterview(Interview interview) {

		Optional<Candidate> candidate = candidateRepository.findById(interview.getCandidate().getId());
		if (candidate.isPresent()) {
			candidate.get().setRound(candidate.get().getRound() + 1);
			candidateRepository.save(candidate.get());
			interview.setRound(candidate.get().getRound());
			interview.setReschedule(0);
			interview.setStatus(InterviewStatus.PENDING);
			interviewRepository.save(interview);
		}
	}
}
