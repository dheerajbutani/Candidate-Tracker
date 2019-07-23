package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.CandidateStatus;



public class CandidateResponse {

    private int id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String mobile;
	
	private String address;
	
	private String currentLocation;
	
	private String preferredLocation;
	
	private CandidateStatus candidateStatus;
	
	private Double currentCtc;
	
	private Double expectedCtc;

	
	private List<InterviewResponse>interviewResponses;
	
	
	
	public CandidateResponse() {
		super();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
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



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCurrentLocation() {
		return currentLocation;
	}



	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}



	public String getPreferredLocation() {
		return preferredLocation;
	}



	public void setPreferredLocation(String preferredLocation) {
		this.preferredLocation = preferredLocation;
	}



	public Double getCurrentCtc() {
		return currentCtc;
	}



	public void setCurrentCtc(Double currentCtc) {
		this.currentCtc = currentCtc;
	}



	public Double getExpectedCtc() {
		return expectedCtc;
	}



	public void setExpectedCtc(Double expectedCtc) {
		this.expectedCtc = expectedCtc;
	}



	public List<InterviewResponse> getInterviewResponses() {
		return interviewResponses;
	}



	public void setInterviewResponses(List<InterviewResponse> interviewResponses) {
		this.interviewResponses = interviewResponses;
	}



	@Override
	public String toString() {
		return "CandidateResponse [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobile=" + mobile + ", address=" + address + ", currentLocation=" + currentLocation
				+ ", preferredLocation=" + preferredLocation + ", candidateStatus=" + candidateStatus + ", currentCtc="
				+ currentCtc + ", expectedCtc=" + expectedCtc + ", interviewResponses=" + interviewResponses + "]";
	}



	public CandidateResponse(int id, String email, String firstName, String lastName, String mobile, String address,
			String currentLocation, String preferredLocation, CandidateStatus candidateStatus, Double currentCtc,
			Double expectedCtc, List<InterviewResponse> interviewResponses) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.currentLocation = currentLocation;
		this.preferredLocation = preferredLocation;
		this.candidateStatus = candidateStatus;
		this.currentCtc = currentCtc;
		this.expectedCtc = expectedCtc;
		this.interviewResponses = interviewResponses;
	}



	public CandidateStatus getCandidateStatus() {
		return candidateStatus;
	}



	public void setCandidateStatus(CandidateStatus candidateStatus) {
		this.candidateStatus = candidateStatus;
	}



	

	
}
