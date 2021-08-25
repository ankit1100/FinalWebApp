package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class AccountType {
	private int accTypeId;
	
	@NotBlank(message = "Please enter valid account type!")
	private String accTypeName;

	public int getAccTypeId() {
		return accTypeId;
	}

	public void setAccTypeId(int accTypeId) {
		this.accTypeId = accTypeId;
	}

	public String getAccTypeName() {
		return accTypeName;
	}

	public void setAccTypeName(String accTypeName) {
		this.accTypeName = accTypeName;
	}
}
