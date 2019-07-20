package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Interview_reschedule_request")
public class InterviewRescheduleRequest {

	@Id
	private int id;

//	private int recruiterId;
//	
//	private int candidateId;
//
//	private int interviewerId;
//
	private LocalDate requestedDate;

	private String requestedTime;

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



	public InterviewRescheduleRequest(int id, LocalDate requestedDate, String requestedTime, String reason,
		RescheduleStatus rescheduleStatus, int interview) {
	super();
	this.id = id;
	this.requestedDate = requestedDate;
	this.requestedTime = requestedTime;
	this.reason = reason;
	this.rescheduleStatus = rescheduleStatus;
	this.interviewId = interview;
}



	@Override
	public String toString() {
		return "InterviewRescheduleRequest [id=" + id + ", requestedDate=" + requestedDate + ", requestedTime="
				+ requestedTime + ", reason=" + reason + ", rescheduleStatus=" + rescheduleStatus + ", interview="
				+ interviewId + "]";
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
	public LocalDate getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(LocalDate requestedDate) {
		this.requestedDate = requestedDate;
	}
	public String getRequestedTime() {
		return requestedTime;
	}
	public void setRequestedTime(String requestedTime) {
		this.requestedTime = requestedTime;
	}
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
