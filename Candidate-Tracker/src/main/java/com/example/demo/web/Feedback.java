package com.example.demo.web;

public class Feedback {

	private int interviewid;
	private String feedback;
	public int getInterviewid() {
		return interviewid;
	}
	public void setInterviewid(int interviewid) {
		this.interviewid = interviewid;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Feedback(int interviewid, String feedback) {
		super();
		this.interviewid = interviewid;
		this.feedback = feedback;
	}
	public Feedback() {
		super();
	}
	@Override
	public String toString() {
		return "Feedback [interviewid=" + interviewid + ", feedback=" + feedback + "]";
	}
	
}
