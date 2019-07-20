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

	private int candidateId;

	private int interviewerId;

	private LocalDate requestedDate;

	private String requestedTime;

	private String reason;
	@Enumerated(EnumType.STRING)
	private RescheduleStatus rescheduleStatus;
	public InterviewRescheduleRequest(int id, int candidateId, int interviewerId, LocalDate requestedDate,
			String requestedTime, String reason, RescheduleStatus rescheduleStatus) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.interviewerId = interviewerId;
		this.requestedDate = requestedDate;
		this.requestedTime = requestedTime;
		this.reason = reason;
		this.rescheduleStatus = rescheduleStatus;
	}
	public InterviewRescheduleRequest() {
		super();
	}
	@Override
	public String toString() {
		return "InterviewRescheduleRequest [id=" + id + ", candidateId=" + candidateId + ", interviewerId="
				+ interviewerId + ", requestedDate=" + requestedDate + ", requestedTime=" + requestedTime + ", reason="
				+ reason + ", rescheduleStatus=" + rescheduleStatus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public int getInterviewerId() {
		return interviewerId;
	}
	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}
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
