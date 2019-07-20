package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "login_user",schema = "hr")
public class LoginUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String email;
	
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "accountStatus")
	private AccountStatus accountStatus;
	@Column(name = "lastLogin")
	private String lastLogin;
	@Column(name = "lastIpAddress")
	private String lastIpAddr;
	@Column(name = "creationDate")
	private LocalDate creationDate;

	private String firstName;
	
	private String lastName;
	
	private String mobile;

	
	@JsonIgnore
	@Transient
	@OneToMany(mappedBy="loginUser")
	private List<Candidate> candidates;
	
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





	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}



	public LoginUser(int id, String email, String password, Role role, AccountStatus accountStatus, String lastLogin,
			String lastIpAddr, LocalDate creationDate, String firstName, String lastName, String mobile,
			List<Candidate> candidates) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.accountStatus = accountStatus;
		this.lastLogin = lastLogin;
		this.lastIpAddr = lastIpAddr;
		this.creationDate = creationDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.candidates = candidates;
	}



	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", accountStatus=" + accountStatus + ", lastLogin=" + lastLogin + ", lastIpAddr=" + lastIpAddr
				+ ", creationDate=" + creationDate + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
				+ mobile + ", candidates=" + candidates + "]";
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
	
	
	public LoginUser() {
		this.creationDate=LocalDate.now();
		this.lastIpAddr="";
		this.lastLogin="";
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