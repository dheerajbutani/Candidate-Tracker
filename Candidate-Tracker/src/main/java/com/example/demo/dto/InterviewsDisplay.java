package com.example.demo.dto;

import java.time.LocalDate;

import com.example.demo.model.InterviewStatus;

public class InterviewsDisplay {

	private int id;

	private int candidateId;
	
	private String firstName;
	
	private String lastName;
	private String email;
	private String mobile;

	private LocalDate interviewDate;

	private String interviewTime;

	private int round;

	private InterviewStatus status;

	private String feedback;

	// boolean
	private int reschedule;

	

	public InterviewsDisplay(int id, int candidateId, String firstName, String lastName, String email, String mobile,
			LocalDate interviewDate, String interviewTime, int round, InterviewStatus status, String feedback,
			int reschedule) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.round = round;
		this.status = status;
		this.feedback = feedback;
		this.reschedule = reschedule;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "InterviewsDisplay [id=" + id + ", candidateId=" + candidateId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", mobile=" + mobile + ", interviewDate="
				+ interviewDate + ", interviewTime=" + interviewTime + ", round=" + round + ", status=" + status
				+ ", feedback=" + feedback + ", reschedule=" + reschedule + "]";
	}

	public InterviewsDisplay() {
		
	}

}
