package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Interview;
import com.example.demo.model.InterviewRescheduleRequest;
import com.example.demo.model.RescheduleStatus;
import com.example.demo.repository.InterviewRescheduleRepository;

@Service
public class InterviewRescheduleService {

	@Autowired
	private InterviewRescheduleRepository interviewRescheduleRepository;
	

	
	public void requestReschedule(InterviewRescheduleRequest interviewRescheduleRequest) {
		interviewRescheduleRequest.setRescheduleStatus(RescheduleStatus.AWAITINGRESPONSE);
		interviewRescheduleRepository.save(interviewRescheduleRequest);
		
	}
	public List<InterviewRescheduleRequest> loadRescheduleRequests() {
	List<InterviewRescheduleRequest>requests=interviewRescheduleRepository.findAllByRescheduleStatus(RescheduleStatus.AWAITINGRESPONSE);
		return requests;
	}
	public List<InterviewRescheduleRequest> getRescheduleRequests(List<Interview>interviews){
	List<InterviewRescheduleRequest>requests=this.loadRescheduleRequests();
		
		
		
		List<InterviewRescheduleRequest>myRequests=new ArrayList<>();
		requests.stream()
		.filter((request)->{
			return 		interviews.stream().anyMatch((x)->{ return x.getId()==request.getInterviewId();});
		})
		.forEach((request)->{
		myRequests.add(request);
		
		});
		
	return myRequests;
	}
	public void approveRequest(int requestId) {
	Optional<InterviewRescheduleRequest> request=	interviewRescheduleRepository.findById(requestId);
		request.get().setRescheduleStatus(RescheduleStatus.APPROVED);
	interviewRescheduleRepository.save(request.get());

	}

	public void rejectRequest(int requestId) {
		Optional<InterviewRescheduleRequest> request=	interviewRescheduleRepository.findById(requestId);
			request.get().setRescheduleStatus(RescheduleStatus.REJECTED);
		interviewRescheduleRepository.save(request.get());
		}
	public  int getInterviewId(int requestId) {
	
	return	interviewRescheduleRepository.findById(requestId).get().getInterviewId();
	}
	
}
