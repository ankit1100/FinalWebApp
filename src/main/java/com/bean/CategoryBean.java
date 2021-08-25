		package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class CategoryBean {
	
	@NotBlank(message = "Please enter the valid category name!")
	private String categoryName;
	private int categoryId;
	LoginBean user;
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public LoginBean getUser() {
		return user;
	}
	public void setUser(LoginBean user) {
		this.user = user;
	}
	
}
