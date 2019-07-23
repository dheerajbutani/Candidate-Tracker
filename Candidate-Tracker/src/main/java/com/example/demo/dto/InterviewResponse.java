package com.example.demo.dto;



import com.example.demo.model.AccountDetails;
import com.example.demo.model.InterviewStatus;
import com.example.demo.model.LoginUser;

public class InterviewResponse {

	private int id; 

	private AccountDetails interviewer;

	private String interviewStartTime;

	private String interviewEndTime;

	private int round;

	private InterviewStatus status;

	private String feedback;

	// boolean
	private int reschedule;

	

	
	

	public InterviewResponse(int id, AccountDetails interviewer, String interviewStartTime, String interviewEndTime,
			int round, InterviewStatus status, String feedback, int reschedule) {
		super();
		this.id = id;
		this.interviewer = interviewer;
		this.interviewStartTime = interviewStartTime;
		this.interviewEndTime = interviewEndTime;
		this.round = round;
		this.status = status;
		this.feedback = feedback;
		this.reschedule = reschedule;
	}

	public int getRound() {
		return round;
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

	@Override
	public String toString() {
		return "InterviewResponse [id=" + id + ", interviewer=" + interviewer + ", interviewStartTime="
				+ interviewStartTime + ", interviewEndTime=" + interviewEndTime + ", round=" + round + ", status="
				+ status + ", feedback=" + feedback + ", reschedule=" + reschedule + "]";
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AccountDetails getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(AccountDetails interviewer) {
		this.interviewer = interviewer;
	}

}
