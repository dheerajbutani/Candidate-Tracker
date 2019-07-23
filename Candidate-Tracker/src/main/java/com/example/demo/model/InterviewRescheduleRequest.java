package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name = "Interview_reschedule_request")
public class InterviewRescheduleRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "interview_reschedule_sequence")
	@SequenceGenerator(name="interview_reschedule_sequence", sequenceName="interview_reschedule_sequence", allocationSize=1)
	private int id;

//	private int recruiterId;
//	
//	private int candidateId;
//
//	private int interviewerId;
	
	
	private String requestedStartTime;

	private String requestedEndTime;

	private String reason;
	@Enumerated(EnumType.STRING)
	private RescheduleStatus rescheduleStatus;
	

	
	private int interviewId;
	
//	public int getRecruiterId() {
//		return recruiterId;
//	}
//	public void setRecruiterId(int recruiterId) {
//		this.recruiterId = recruiterId;
//	}
	
	public InterviewRescheduleRequest() {
		super();
	}
	


	public int getInterviewId() {
		return interviewId;
	}



	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}



	



	public String getRequestedStartTime() {
		return requestedStartTime;
	}



	public void setRequestedStartTime(String requestedStartTime) {
		this.requestedStartTime = requestedStartTime;
	}



	public String getRequestedEndTime() {
		return requestedEndTime;
	}



	public void setRequestedEndTime(String requestedEndTime) {
		this.requestedEndTime = requestedEndTime;
	}



	


	@Override
	public String toString() {
		return "InterviewRescheduleRequest [id=" + id + ", requestedStartTime=" + requestedStartTime
				+ ", requestedEndTime=" + requestedEndTime + ", reason=" + reason + ", rescheduleStatus="
				+ rescheduleStatus + ", interviewId=" + interviewId + "]";
	}



	public InterviewRescheduleRequest(int id, String requestedStartTime, String requestedEndTime, String reason,
			RescheduleStatus rescheduleStatus, int interviewId) {
		super();
		this.id = id;
		this.requestedStartTime = requestedStartTime;
		this.requestedEndTime = requestedEndTime;
		this.reason = reason;
		this.rescheduleStatus = rescheduleStatus;
		this.interviewId = interviewId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public int getCandidateId() {
//		return candidateId;
//	}
//	public void setCandidateId(int candidateId) {
//		this.candidateId = candidateId;
//	}
//	public int getInterviewerId() {
//		return interviewerId;
//	}
//	public void setInterviewerId(int interviewerId) {
//		this.interviewerId = interviewerId;
//	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public RescheduleStatus getRescheduleStatus() {
		return rescheduleStatus;
	}
	public void setRescheduleStatus(RescheduleStatus rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}

	
}
