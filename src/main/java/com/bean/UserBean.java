package com.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UserBean {
	
	private int userId;
	
	@NotBlank(message = "Please enter valid first name!")
	private String firstName;
	
	@Size(max = 10,min = 10,message = "Please enter valid mobile number!")
	private String phone;
	
	@NotBlank(message = "Please select your valid sex type!")
	private String gender;
	
	@Email(regexp = ".+@.+\\..+",message = "Please Enter Valid Email ID!")
	private String email;
	
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z]).{8,16}$",message = "Please Enter Valid Password!")
	private String password;
	
	RoleBean role;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public RoleBean getRole() {
		return role;
	}
	public void setRole(RoleBean role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", firstName=" + firstName + ", phone=" + phone + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", role=" + role + "]";
	}
}
