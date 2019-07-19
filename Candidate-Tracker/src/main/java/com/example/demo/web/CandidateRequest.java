package com.example.demo.web;

import com.example.demo.model.Candidate;

public class CandidateRequest {

	private Candidate candidate;
	private ParentId parentid;
	public CandidateRequest(Candidate candidate, ParentId parentid) {
		super();
		this.candidate = candidate;
		this.parentid = parentid;
	}
	public CandidateRequest() {
		
	}
	@Override
	public String toString() {
		return "CandidateRequest [candidate=" + candidate + ", recruiterid=" + parentid + "]";
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public ParentId getParentid() {
		return parentid;
	}
	public void setParentid(ParentId parentid) {
		this.parentid = parentid;
	}
	
}
