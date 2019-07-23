package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private UserAccountService userAccountService;
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

	List<CandidateResponse> loadOnlyMyCandidates(int parentId)
	{
		List<CandidateResponse> candidateResponses = new ArrayList<>();

		List<Candidate> candidates = new ArrayList<>();
		
		
		candidates.addAll(candidateRepository.findByLoginUserId(parentId));
		for (Candidate candidate : candidates) {
			CandidateResponse candidateResponse = new CandidateResponse();
			candidateResponse.setId(candidate.getId());
			candidateResponse.setAddress(candidate.getAddress());
			candidateResponse.setCurrentCtc(candidate.getCurrentCtc());
			candidateResponse.setCurrentLocation(candidate.getCurrentLocation());
			candidateResponse.setEmail(candidate.getEmail());
			candidateResponse.setExpectedCtc(candidate.getExpectedCtc());
			candidateResponse.setFirstName(candidate.getFirstName());
			candidateResponse.setCandidateStatus(candidate.getCandidateStatus());

			candidateResponse.setLastName(candidate.getLastName());
			candidateResponse.setMobile(candidate.getMobile());
			candidateResponse.setPreferredLocation(candidate.getPreferredLocation());
			
			List<InterviewResponse> interviewResponses = new ArrayList<>();
			for (Interview interview : InterviewRepository.findAllByCandidateId(candidate.getId())) {
				InterviewResponse interviewResponse = new InterviewResponse();
				interviewResponse.setFeedback(interview.getFeedback());
				interviewResponse.setId(interview.getId());
				interviewResponse.setInterviewStartTime(interview.getInterviewStartTime());
				interviewResponse.setInterviewEndTime(interview.getInterviewEndTime());
				interviewResponse
						.setInterviewer(userAccountService.getMyAccountDetails(interview.getInterviewer().getId()));
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
	
	
	public List<CandidateResponse> loadMyCandidates(int parentId) {
		List<CandidateResponse> candidateResponses = new ArrayList<>();

		List<Candidate> candidates = new ArrayList<>();

		List<UserManager> userManagers = userManagerRepository.findByParentId(parentId);

		System.out.println(userManagers);
		for (UserManager userManager : userManagers) {
			if (candidateRepository.findByLoginUserId(userManager.getChildId()).size() != 0) {
				candidates.addAll(candidateRepository.findByLoginUserId(userManager.getChildId()));

			}
		}
		System.out.println(candidates);
		for (Candidate candidate : candidates) {
			CandidateResponse candidateResponse = new CandidateResponse();
			candidateResponse.setId(candidate.getId());
			candidateResponse.setAddress(candidate.getAddress());
			candidateResponse.setCurrentCtc(candidate.getCurrentCtc());
			candidateResponse.setCurrentLocation(candidate.getCurrentLocation());
			candidateResponse.setEmail(candidate.getEmail());
			candidateResponse.setExpectedCtc(candidate.getExpectedCtc());
			candidateResponse.setFirstName(candidate.getFirstName());
			candidateResponse.setCandidateStatus(candidate.getCandidateStatus());

			candidateResponse.setLastName(candidate.getLastName());
			candidateResponse.setMobile(candidate.getMobile());
			candidateResponse.setPreferredLocation(candidate.getPreferredLocation());
			
			
			List<InterviewResponse> interviewResponses = new ArrayList<>();
			for (Interview interview : InterviewRepository.findAllByCandidateId(candidate.getId())) {
				InterviewResponse interviewResponse = new InterviewResponse();
				interviewResponse.setFeedback(interview.getFeedback());
				interviewResponse.setId(interview.getId());
				interviewResponse.setInterviewStartTime(interview.getInterviewStartTime());
				interviewResponse.setInterviewEndTime(interview.getInterviewEndTime());
				interviewResponse
						.setInterviewer(userAccountService.getMyAccountDetails(interview.getInterviewer().getId()));
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

	@Transactional
	public void offer(int candidateId) {
		Optional<Candidate> candidate = candidateRepository.findById(candidateId);
		candidate.get().setCandidateStatus(CandidateStatus.OFFER);
	}

	@Transactional
	public void reject(int candidateId) {
		Optional<Candidate> candidate = candidateRepository.findById(candidateId);
		candidate.get().setCandidateStatus(CandidateStatus.REJECT);
	}

	@Transactional
	public void hold(int candidateId) {
		Optional<Candidate> candidate = candidateRepository.findById(candidateId);
		candidate.get().setCandidateStatus(CandidateStatus.HOLD);
	}

	public Map<String, Long> getStats(int userId) {
		Map<String, Long> stats = new HashMap<String, Long>();

		List<CandidateResponse> candidates = this.loadMyCandidates(userId);
		long myCandidatesHold = candidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.HOLD);
		}).count();

		long myCandidatesUnderInterview = candidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.UNDERINTERVIEW);
		}).count();

		long myCandidatesRegistered = candidates.size();
		long myCandidatesOffered = candidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.OFFER);
		}).count();

		long myCandidatesRejected = candidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.REJECT);
		}).count();

		List<Candidate> allCandidates = candidateRepository.findAll();

		long totalCandidatesHold = allCandidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.HOLD);
		}).count();

		long totalCandidatesUnderInterview = allCandidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.UNDERINTERVIEW);
		}).count();

		long totalCandidatesRegistered = allCandidates.size();

		long totalCandidatesOffered = candidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.OFFER);
		}).count();

		long totalCandidatesRejected = allCandidates.stream().filter((candidate) -> {
			return candidate.getCandidateStatus().equals(CandidateStatus.REJECT);
		}).count();

		stats.put("Number Of My Candidates", myCandidatesRegistered);
		stats.put("Number Of My Candidates On Hold", myCandidatesHold);
		stats.put("Number Of My Candidates Under Interview", myCandidatesUnderInterview);
		stats.put("Number Of My Candidates Offered", myCandidatesOffered);
		stats.put("Number Of My Registered Rejected", myCandidatesRejected);
		stats.put("Total Number Of Candidates", totalCandidatesRegistered);
		stats.put("Total Number Of Candidates On Hold", totalCandidatesHold);
		stats.put("Total Number Of Candidates Under Interview", totalCandidatesUnderInterview);
		stats.put("Total Number Of Candidates Offered", totalCandidatesOffered);
		stats.put("Total Number Of Registered Rejected", totalCandidatesRejected);

		return stats;
	}

	
	
	@Transactional
	public void updateCandidate(Candidate candidateinput) {
	
	Candidate candidate=candidateRepository.findById(candidateinput.getId()).get();
	candidate.setAddress(candidateinput.getAddress());
	candidate.setCurrentCtc(candidateinput.getCurrentCtc());
	candidate.setCurrentLocation(candidateinput.getCurrentLocation());
	
	candidate.setExpectedCtc(candidateinput.getExpectedCtc());
	candidate.setFirstName(candidateinput.getFirstName());
	candidate.setId(candidateinput.getId());
	candidate.setLastName(candidateinput.getLastName());
	candidate.setMobile(candidateinput.getMobile());
	candidate.setPreferredLocation(candidateinput.getPreferredLocation());
	candidateRepository.save(candidate);
	
	}
	
	public Candidate getCandidate(int id) {
	return	candidateRepository.findById(id).get();
	}
}
