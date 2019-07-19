package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Candidate")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String mobile;
	
	private String address;
	
	private String currentLocation;
	
	private String preferredLocation;
	
	private Double currentCtc;
	
	private Double expectedCtc;

	private int round;
	@Enumerated(EnumType.STRING)
	private CandidateStatus candidateStatus;
	 LocalDate profileCreationDate;

	@JsonIgnore
	@ManyToOne
	private LoginUser loginUser;
	

	

	

	public Candidate(int id, String email, String firstName, String lastName, String mobile, String address,
			String currentLocation, String preferredLocation, Double currentCtc, Double expectedCtc, int round,
			CandidateStatus candidateStatus, LocalDate profileCreationDate, LoginUser loginUser) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.address = address;
		this.currentLocation = currentLocation;
		this.preferredLocation = preferredLocation;
		this.currentCtc = currentCtc;
		this.expectedCtc = expectedCtc;
		this.round = round;
		this.candidateStatus = candidateStatus;
		this.profileCreationDate = profileCreationDate;
		this.loginUser = loginUser;
		
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobile=" + mobile + ", address=" + address + ", currentLocation=" + currentLocation
				+ ", preferredLocation=" + preferredLocation + ", currentCtc=" + currentCtc + ", expectedCtc="
				+ expectedCtc + ", round=" + round + ", candidateStatus=" + candidateStatus + ", profileCreationDate="
				+ profileCreationDate + ", loginUser=" + loginUser +  "]";
	}

	public Candidate() {
	
	}



	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}


	public CandidateStatus getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(CandidateStatus candidateStatus) {
		this.candidateStatus = candidateStatus;
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

	
	public LocalDate getProfileCreationDate() {
		return profileCreationDate;
	}

	public void setProfileCreationDate(LocalDate profileCreationDate) {
		this.profileCreationDate = profileCreationDate;
	}

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}

	
	

}

//{
//    "loginuser": {
//        "id": 0,
//        "email": "draj@gmail.com",
//        "password": "abcd",
//        "role": "ROOT",
//        "accountStatus": "ACTIVE",
//        "lastLogin": "",
//        "lastIpAddr": "",
//        "creationDate": null,
//        "childrens": [],
//        "parents": []
//    },
//    "parentid": {
//        "parentid": 1
//    }
//}