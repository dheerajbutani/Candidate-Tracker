package com.example.demo.dto;

import java.time.LocalDate;


import com.example.demo.model.InterviewStatus;
import com.example.demo.model.LoginUser;

public class InterviewResponse {

	private int id;

	private LoginUser interviewer;

	private LocalDate interviewDate;

	private String interviewTime;

	private int round;

	private InterviewStatus status;

	private String feedback;

	// boolean
	private int reschedule;

	public InterviewResponse(int id, LoginUser interviewer, LocalDate interviewDate, String interviewTime, int round,
			InterviewStatus status, String feedback, int reschedule) {
		super();
		this.id = id;
		this.interviewer = interviewer;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.round = round;
		this.status = status;
		this.feedback = feedback;
		this.reschedule = reschedule;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoginUser getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(LoginUser interviewer) {
		this.interviewer = interviewer;
	}

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		this.interviewTime = interviewTime;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public InterviewStatus getStatus() {
		return status;
	}

	public void setStatus(InterviewStatus status) {
		this.status = status;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getReschedule() {
		return reschedule;
	}

	public void setReschedule(int reschedule) {
		this.reschedule = reschedule;
	}

	public InterviewResponse() {
		super();
	}

}
