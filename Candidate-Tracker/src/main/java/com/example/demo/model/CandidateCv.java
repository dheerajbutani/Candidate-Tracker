package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_cv")
public class CandidateCv {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "candidate_cv_sequence")
	@SequenceGenerator(name = "candidate_cv_sequence",sequenceName = "candidate_cv_sequence",allocationSize = 1)
	private int id;
	
	private int candidateId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int fileVersion;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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



	public int getFileVersion() {
		return fileVersion;
	}

	public void setFileVersion(int fileVersion) {
		this.fileVersion = fileVersion;
	}

	


	@Override
	public String toString() {
		return "CandidateCv [id=" + id + ", candidateId=" + candidateId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", fileVersion=" + fileVersion + "]";
	}

	public CandidateCv(int id, int candidateId, String firstName, String lastName, String email, int fileVersion) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.fileVersion = fileVersion;
	}

	public CandidateCv() {
		super();
	}
	
	
}
