package com.example.demo.web;

import com.example.demo.model.LoginUser;

public class AccountRequest {

	
	private LoginUser loginuser;
	private ParentId parentid;
	public LoginUser getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(LoginUser loginuser) {
		this.loginuser = loginuser;
	}
	public ParentId getParentid() {
		return parentid;
	}
	public void setParentid(ParentId parentid) {
		this.parentid = parentid;
	}
	@Override
	public String toString() {
		return "AccountRequest [loginuser=" + loginuser + ", parentid=" + parentid + "]";
	}
	public AccountRequest(LoginUser loginuser, ParentId parentid) {
		super();
		this.loginuser = loginuser;
		this.parentid = parentid;
	}
	public AccountRequest() {
		super();
	}
	
}
