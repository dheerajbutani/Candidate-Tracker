package com.example.demo.web;

import java.time.LocalDate;

public class InterviewRequest {

	private int recruiterId;
	private int candidateId;
	private int interviewerId;

	private String interviewTime;
	private LocalDate interviewDate;


	public InterviewRequest(int recruiterId,int candidateId, int interviewerId, LocalDate interviewDate, String interviewTime) {
		super();
		this.recruiterId=recruiterId;
		this.candidateId = candidateId;
		this.interviewerId = interviewerId;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
	}

	public InterviewRequest() {

	}

	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
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

	@Override
	public String toString() {
		return "InterviewRequest [candidateId=" + candidateId + ", interviewerId=" + interviewerId + ", interviewDate="
				+ interviewDate + ", interviewTime=" + interviewTime + "]";
	}

}
