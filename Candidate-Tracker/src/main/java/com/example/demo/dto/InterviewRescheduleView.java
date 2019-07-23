package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.model.RescheduleStatus;

public class InterviewRescheduleView {
	private int id;	
	
	private String requestedStartTime;

	private String requestedEndTime;

	private String reason;
	
	private String currentStartTime;
	
	private String currentEndTime;
	
	private RescheduleStatus rescheduleStatus;
	
	private int interviewId;
	
	private String interviewerName;
	
	private String candidateName;
	

	


	
	


	public InterviewRescheduleView(int id, String requestedStartTime, String requestedEndTime, String reason,
			String currentStartTime, String currentEndTime, RescheduleStatus rescheduleStatus, int interviewId,
			String interviewerName, String candidateName) {
		super();
		this.id = id;
		this.requestedStartTime = requestedStartTime;
		this.requestedEndTime = requestedEndTime;
		this.reason = reason;
		this.currentStartTime = currentStartTime;
		this.currentEndTime = currentEndTime;
		this.rescheduleStatus = rescheduleStatus;
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.candidateName = candidateName;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "InterviewRescheduleView [id=" + id + ", requestedStartTime=" + requestedStartTime
				+ ", requestedEndTime=" + requestedEndTime + ", reason=" + reason + ", currentStartTime="
				+ currentStartTime + ", currentEndTime=" + currentEndTime + ", rescheduleStatus=" + rescheduleStatus
				+ ", interviewId=" + interviewId + ", interviewerName=" + interviewerName + ", candidateName="
				+ candidateName + "]";
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	

	public String getCurrentStartTime() {
		return currentStartTime;
	}

	public void setCurrentStartTime(String currentStartTime) {
		this.currentStartTime = currentStartTime;
	}

	public String getCurrentEndTime() {
		return currentEndTime;
	}

	public void setCurrentEndTime(String currentEndTime) {
		this.currentEndTime = currentEndTime;
	}

	public RescheduleStatus getRescheduleStatus() {
		return rescheduleStatus;
	}

	public void setRescheduleStatus(RescheduleStatus rescheduleStatus) {
		this.rescheduleStatus = rescheduleStatus;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public InterviewRescheduleView() {
		super();
	}
	
}
