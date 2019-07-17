package com.example.demo.web;

public class DeactivateRequest {

	private String email;
	private int parentId;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public DeactivateRequest(String email, int parentId) {
		super();
		this.email = email;
		this.parentId = parentId;
	}
	public DeactivateRequest() {
		super();
	}
	@Override
	public String toString() {
		return "DeactivateRequest [email=" + email + ", parentId=" + parentId + "]";
	}
	
}
