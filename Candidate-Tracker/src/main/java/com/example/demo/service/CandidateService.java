package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateStatus;

import com.example.demo.model.LoginUser;
import com.example.demo.model.UserManager;
import com.example.demo.repository.CandidateRepository;
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

	public List<Candidate> loadMyCandidates(int parentId) {
		
		
		List<Candidate> candidates = new ArrayList<>();
		
		List<UserManager> userManagers = userManagerRepository.findByParentId(parentId);
	
		System.out.println(userManagers);
		for (UserManager userManager : userManagers) {
			if(candidateRepository.findByLoginUserId(userManager.getChildId()).size()!=0) {
				candidates.addAll(candidateRepository.findByLoginUserId(userManager.getChildId()));	
			
			}
		}
		System.out.println(candidates);
		return candidates;
	}

}
