package com.example.demo.web;

import java.time.LocalDate;

public class InterviewRequest {

	private int recruiterId;
	private int candidateId;
	private int interviewerId;

	private String interviewStartTime;
	private String interviewEndTime;


	

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

	public String getInterviewStartTime() {
		return interviewStartTime;
	}

	public void setInterviewStartTime(String interviewStartTime) {
		this.interviewStartTime = interviewStartTime;
	}

	public String getInterviewEndTime() {
		return interviewEndTime;
	}

	public void setInterviewEndTime(String interviewEndTime) {
		this.interviewEndTime = interviewEndTime;
	}

	public InterviewRequest(int recruiterId, int candidateId, int interviewerId, String interviewStartTime,
			String interviewEndTime) {
		super();
		this.recruiterId = recruiterId;
		this.candidateId = candidateId;
		this.interviewerId = interviewerId;
		this.interviewStartTime = interviewStartTime;
		this.interviewEndTime = interviewEndTime;
	}

	@Override
	public String toString() {
		return "InterviewRequest [recruiterId=" + recruiterId + ", candidateId=" + candidateId + ", interviewerId="
				+ interviewerId + ", interviewStartTime=" + interviewStartTime + ", interviewEndTime="
				+ interviewEndTime + "]";
	}



}
