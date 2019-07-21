package com.example.demo.dto;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.demo.model.RescheduleStatus;

public class InterviewRescheduleView {
	private int id;	
	
	private LocalDate requestedDate;

	private String requestedTime;

	private String reason;
	
	private LocalDate currentDate;
	
	private String currentTime;
	
	private RescheduleStatus rescheduleStatus;
	
	private int interviewId;

	public InterviewRescheduleView(int id, LocalDate requestedDate, String requestedTime, String reason,
			LocalDate currentDate, String currentTime, RescheduleStatus rescheduleStatus, int interviewId) {
		super();
		this.id = id;
		this.requestedDate = requestedDate;
		this.requestedTime = requestedTime;
		this.reason = reason;
		this.currentDate = currentDate;
		this.currentTime = currentTime;
		this.rescheduleStatus = rescheduleStatus;
		this.interviewId = interviewId;
	}

	@Override
	public String toString() {
		return "InterviewRescheduleView [id=" + id + ", requestedDate=" + requestedDate + ", requestedTime="
				+ requestedTime + ", reason=" + reason + ", currentDate=" + currentDate + ", currentTime=" + currentTime
				+ ", rescheduleStatus=" + rescheduleStatus + ", interviewId=" + interviewId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
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
