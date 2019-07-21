package com.example.demo.model;

import java.time.LocalDate;

public class AccountDetails {
	private int id;

	private String email;

	private Role role;

	private AccountStatus accountStatus;
	private LocalDate creationDate;

	private String firstName;

	private String lastName;

	private String mobile;

	@Override
	public String toString() {
		return "AccountDetails [id=" + id + ", email=" + email + ", role=" + role
				+ ", accountStatus=" + accountStatus 
				+ ", creationDate=" + creationDate + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
				+ mobile + "]";
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


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}


	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
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

	public AccountDetails(int id, String email, Role role, AccountStatus accountStatus,
		 LocalDate creationDate, String firstName, String lastName,
			String mobile) {
		super();
		this.id = id;
		this.email = email;
		this.role = role;
		this.accountStatus = accountStatus;
		this.creationDate = creationDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
	}

	public AccountDetails() {
		super();
	}

	
}
