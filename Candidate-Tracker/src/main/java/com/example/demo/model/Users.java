package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login",schema = "hr")
public class Users {
	
	@Id
	private int id;
	
	private String email;
	
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ACCOUNTSTATUS")
	private AccountStatus accountStatus;
	@Column(name = "LASTLOGIN")
	private String lastLogin;
	@Column(name = "LASTIPADDRESS")
	private String lastIpAddr;
	@Column(name = "CREATIONDATE")
	private LocalDate creationDate;

	
	public Users(int id, String email, String password, Role role, AccountStatus accountStatus, String lastLogin,
			String lastIpAddr, LocalDate creationDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.accountStatus = accountStatus;
		this.lastLogin = lastLogin;
		this.lastIpAddr = lastIpAddr;
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role + ", accountStatus="
				+ accountStatus + ", lastLogin=" + lastLogin + ", lastIpAddr=" + lastIpAddr + ", creationDate="
				+ creationDate + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLastIpAddr() {
		return lastIpAddr;
	}

	public void setLastIpAddr(String lastIpAddr) {
		this.lastIpAddr = lastIpAddr;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
	
	public Users() {
		
	}
	
	

}
