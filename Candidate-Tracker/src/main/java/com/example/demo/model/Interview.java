package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@ManyToOne
	private LoginUser interviewer;
	
	@ManyToOne
	private Candidate candidate;
	
	private LocalDate interviewDate;
	
	private String interviewTime;
	
	private int round;
	
	@Enumerated(EnumType.STRING)
	private InterviewStatus status;
	
	private String feedback;
	
	//boolean
	private int reschedule;

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

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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
		return "Interview [id=" + id + ", interviewer=" + interviewer + ", candidate=" + candidate + ", interviewDate="
				+ interviewDate + ", interviewTime=" + interviewTime + ", round=" + round + ", status=" + status
				+ ", feedback=" + feedback + ", reschedule=" + reschedule + "]";
	}

	public Interview(int id, LoginUser interviewer, Candidate candidate, LocalDate interviewDate, String interviewTime,
			int round, InterviewStatus status, String feedback, int reschedule) {
		super();
		this.id = id;
		this.interviewer = interviewer;
		this.candidate = candidate;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.round = round;
		this.status = status;
		this.feedback = feedback;
		this.reschedule = reschedule;
	}

	public Interview() {
		
	}

	

	
	
	
}
