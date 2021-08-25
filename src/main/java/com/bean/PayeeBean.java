package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class PayeeBean {
	private int payeeId;
	
	@NotBlank(message = "Please enter valid payee name!")
	private String payeeName;
	int userId;

	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "PayeeBean [payeeId=" + payeeId + ", payeeName=" + payeeName + ", userId=" + userId + "]";
	}
	
}
