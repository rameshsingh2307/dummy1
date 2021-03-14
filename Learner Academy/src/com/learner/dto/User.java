package com.learner.dto;

public class User {
	private String loginId;
	private String password;
	public User(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [loginId=" + loginId + ", password=" + password + "]";
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
