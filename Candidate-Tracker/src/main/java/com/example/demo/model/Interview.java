package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Table(name="Interview")
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "interview_sequence")
	@SequenceGenerator(name="interview_sequence", sequenceName="interview_sequence", allocationSize=1)
	private int id;
	
	private int recruiterId;
	
	
	
	@ManyToOne
	private LoginUser interviewer;
	
	@ManyToOne
	private Candidate candidate;
	
	private String interviewStartTime;
	
	private String interviewEndTime;
	
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



	public int getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
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
		return "Interview [id=" + id + ", recruiterId=" + recruiterId + ", interviewer=" + interviewer + ", candidate="
				+ candidate + ", interviewStartTime=" + interviewStartTime + ", interviewEndTime=" + interviewEndTime
				+ ", round=" + round + ", status=" + status + ", feedback=" + feedback + ", reschedule=" + reschedule
				+ "]";
	}

	public Interview(int id, int recruiterId, LoginUser interviewer, Candidate candidate, String interviewStartTime,
			String interviewEndTime, int round, InterviewStatus status, String feedback, int reschedule) {
		super();
		this.id = id;
		this.recruiterId = recruiterId;
		this.interviewer = interviewer;
		this.candidate = candidate;
		this.interviewStartTime = interviewStartTime;
		this.interviewEndTime = interviewEndTime;
		this.round = round;
		this.status = status;
		this.feedback = feedback;
		this.reschedule = reschedule;
	}

	public Interview() {
		
	}

	

	
	
	
}
