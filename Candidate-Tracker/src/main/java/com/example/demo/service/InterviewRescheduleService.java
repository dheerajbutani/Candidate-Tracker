package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.InterviewRescheduleView;
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
	public List<InterviewRescheduleView> getRescheduleRequests(List<Interview>interviews){
	List<InterviewRescheduleRequest>requests=this.loadRescheduleRequests();
		
		
		
		List<InterviewRescheduleView>myRequests=new ArrayList<>();
		requests.stream()
		.filter((request)->{
			return 		interviews.stream().anyMatch((x)->{ return x.getId()==request.getInterviewId();});
		})
		.forEach((request)->{
			InterviewRescheduleView view=new InterviewRescheduleView();
			interviews.stream().filter((interview)->{
			return	interview.getId()==request.getInterviewId();
				
			}).forEach((interview)->{
				view.setCurrentDate(interview.getInterviewDate());
				view.setCurrentTime(interview.getInterviewTime());
			});;
		view.setId(request.getId());
		view.setInterviewId(request.getInterviewId());
		view.setReason(request.getReason());
		view.setRequestedDate(request.getRequestedDate());
		view.setRequestedTime(request.getRequestedTime());
		view.setRescheduleStatus(request.getRescheduleStatus());
		myRequests.add(view);
		
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
	public InterviewRescheduleRequest getRescheduleRequests(int requestId) {
		// TODO Auto-generated method stub
	return	interviewRescheduleRepository.findById(requestId).get();
		
	}
	
}
