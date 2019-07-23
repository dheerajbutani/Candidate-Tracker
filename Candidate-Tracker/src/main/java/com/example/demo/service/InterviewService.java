package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.InterviewsDisplay;
import com.example.demo.model.Candidate;
import com.example.demo.model.CandidateStatus;
import com.example.demo.model.Interview;
import com.example.demo.model.InterviewRescheduleRequest;
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
	@Transactional
	public void addInterview(InterviewRequest interviewRequest) {

		Interview interview=new Interview();
		Optional<LoginUser> interviewer=userRepository.findById(interviewRequest.getInterviewerId());
		
		Optional<Candidate> candidate = candidateRepository.findById(interviewRequest.getCandidateId());
		if (candidate.isPresent()) {
			candidate.get().setRound(candidate.get().getRound() + 1);
			candidate.get().setCandidateStatus(CandidateStatus.UNDERINTERVIEW);
			candidateRepository.save(candidate.get());
			interview.setRecruiterId(interviewRequest.getRecruiterId());
			interview.setCandidate(candidate.get());
			interview.setInterviewer(interviewer.get());
			interview.setRound(candidate.get().getRound());
			interview.setInterviewStartTime(interviewRequest.getInterviewStartTime());
			interview.setInterviewEndTime(interviewRequest.getInterviewEndTime());
			interview.setReschedule(0);
			interview.setStatus(InterviewStatus.PENDING);
			interviewRepository.save(interview);
		
		}
		
		}
		
	
	
	public List<InterviewsDisplay> getMyInterviews(int interviewer_id) {
	List<Interview>interviews=interviewRepository.findByInterviewerId(interviewer_id);
	
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
		interviewsDisplay.setRecruiterId(interview.getRecruiterId());
		interviewsDisplay.setInterviewStartTime(interview.getInterviewStartTime());
		interviewsDisplay.setInterviewEndTime(interview.getInterviewEndTime());
		interviewsDisplay.setReschedule(interview.getReschedule());
		interviewsDisplay.setRound(interview.getRound());
		interviewsDisplay.setStatus(interview.getStatus());
		interviewsDisplayList.add(interviewsDisplay);
	}
	
	
	
	System.out.println(interviews);
	return interviewsDisplayList;
	}
	
	
	
	
	@Transactional
	public void setInterviewReschedule(int interviewid) {
		System.out.println("kegmgd");
Optional<Interview> interview=		interviewRepository.findById(interviewid);
Interview inter=interview.get();
System.out.println(inter);
//interview.get().setInterviewEndTime(sdf.format((interview.get().getInterviewEndTime()).toString()));
//interview.get().setInterviewEndTime(sdf.format(interview.get().getInterviewStartTime()).toString());
//System.out.println("time:"+interview.get());
	inter.setReschedule(1);
	interviewRepository.save(inter);
	}
	
//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yy hh:mm:ss");
	@Transactional
	public void resetInterviewReschedule(int interviewid) {
		Optional<Interview> interview=		interviewRepository.findById(interviewid);
			interview.get().setReschedule(0);
//			interview.get().setInterviewEndTime(sdf.format((interview.get().getInterviewEndTime()).toString()));
//			interview.get().setInterviewEndTime(sdf.format(interview.get().getInterviewStartTime()).toString());
			System.out.println("time:"+interview.get());
			interviewRepository.save(interview.get());
			
			
			}


	public List<Interview> getInterviews(int recruiterid) {
	return	interviewRepository.findAllByRecruiterId(recruiterid);
	}
	
//	@Transactional
//	public void approveRequest(InterviewRescheduleRequest interviewRescheduleRequest) {
//	Optional<Interview> interview=	interviewRepository.findById(interviewRescheduleRequest.getInterviewId());
//		interview.get().setInterviewStartTime(interviewRescheduleRequest.getRequestedStartTime());
//		interview.get().setInterviewEndTime(interviewRescheduleRequest.getRequestedEndTime());
////		interviewRepository.save(interview.get());
//	}
//	
	public String getInterviewerName(int id) {
		return interviewRepository.findById(id).get().getInterviewer().getFirstName();
	}
	public String getCandidateName(int id) {
		return interviewRepository.findById(id).get().getCandidate().getFirstName();
	}
}
