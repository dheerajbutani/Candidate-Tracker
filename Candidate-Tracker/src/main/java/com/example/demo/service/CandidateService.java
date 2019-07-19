package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CandidateResponse;
import com.example.demo.dto.InterviewResponse;
import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateStatus;
import com.example.demo.model.Interview;
import com.example.demo.model.LoginUser;
import com.example.demo.model.UserManager;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.InterviewRepository;
import com.example.demo.repository.UserManagerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.web.ParentId;

@Service
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserManagerRepository userManagerRepository;

	@Autowired
	private InterviewRepository InterviewRepository;
	@Transactional
	public void createCandidate(Candidate candidate, ParentId parentid) {

		candidate.setRound(0);
		candidate.setCandidateStatus(CandidateStatus.REGISTERED);
		candidate.setProfileCreationDate(LocalDate.now());
		System.out.println(parentid.getParentid());
		Optional<LoginUser> loginUser = userRepository.findById(parentid.getParentid());

		System.out.println(loginUser);
		candidate.setLoginUser(loginUser.get());
		candidateRepository.save(candidate);

	}

	public List<CandidateResponse> loadMyCandidates(int parentId) {
		
		
		
		
		
		
		
		List<CandidateResponse> candidateResponses=new ArrayList<>();
		
		List<Candidate> candidates = new ArrayList<>();
		
		
		
		List<UserManager> userManagers = userManagerRepository.findByParentId(parentId);
	
		System.out.println(userManagers);
		for (UserManager userManager : userManagers) {
			if(candidateRepository.findByLoginUserId(userManager.getChildId()).size()!=0) {
				candidates.addAll(candidateRepository.findByLoginUserId(userManager.getChildId()));	
			
			}
		}
		System.out.println(candidates);
		for(Candidate candidate:candidates) {
			CandidateResponse candidateResponse=new CandidateResponse();
			candidateResponse.setId(candidate.getId());
			candidateResponse.setAddress(candidate.getAddress());
			candidateResponse.setCurrentCtc(candidate.getCurrentCtc());
			candidateResponse.setCurrentLocation(candidate.getCurrentLocation());
			candidateResponse.setEmail(candidate.getEmail());
			candidateResponse.setExpectedCtc(candidate.getExpectedCtc());
			candidateResponse.setFirstName(candidate.getFirstName());
		
			List<InterviewResponse>interviewResponses=new ArrayList<>();
			for(Interview interview:InterviewRepository.findAllByCandidateId(candidate.getId())) {
				InterviewResponse interviewResponse=new InterviewResponse();
				interviewResponse.setFeedback(interview.getFeedback());
				interviewResponse.setId(interview.getId());
				interviewResponse.setInterviewDate(interview.getInterviewDate());
				interviewResponse.setInterviewTime(interview.getInterviewTime());
				interviewResponse.setInterviewer(interview.getInterviewer());
				interviewResponse.setReschedule(interview.getReschedule());
				interviewResponse.setRound(interview.getRound());
				interviewResponse.setStatus(interview.getStatus());
				
				interviewResponses.add(interviewResponse);
			}
			candidateResponse.setInterviewResponses(interviewResponses);

			candidateResponses.add(candidateResponse);
		}
		return candidateResponses;
	}

}
