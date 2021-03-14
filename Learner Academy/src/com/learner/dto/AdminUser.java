package com.learner.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class AdminUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String name;	
	private String loginId;
	private String password;	
	private String role;
	
	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public AdminUser(String name, String loginId, String password, String role) {
		super();
		this.name = name;
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getUserID() {
		return userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "AdminUser [userId=" + userId + ", name=" + name + ", loginId=" + loginId + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
