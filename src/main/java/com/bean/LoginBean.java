package com.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class LoginBean {
	private int userId;
	
	@Email(regexp = ".+@.+\\..+",message = "Please enter a valid email.")
	private String email;
	@Length(min = 8,max = 16,message = "Length must be between 8 to 16 digit.")
	private String password;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
}
