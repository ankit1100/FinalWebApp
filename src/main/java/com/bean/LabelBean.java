package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class LabelBean {
	private int labelId;
	
	@NotBlank(message = "Please enter valid label name!")
	private String labelName;
	int userId;
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public int getUser() {
		return userId;
	}
	public void setUser(int userId) {
		this.userId = userId;
	}
}
