package com.example.demo.web;

public class UpdateAccountRequest {

	private int id;

	private String email;

	private String firstName;

	private String lastName;

	private String mobile;

	@Override
	public String toString() {
		return "UpdateAccountRequest [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobile=" + mobile + "]";
	}

	public UpdateAccountRequest(int id, String email, String firstName, String lastName, String mobile) {
		super();
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	public UpdateAccountRequest() {
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
	
	   

}
