package com.bean;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

public class AccountBean {
	private int accountId;
	
	@NotBlank(message ="Please enter valid account name!")
	private String accountName;
	
	@Max(value=(long) Double.MAX_VALUE, message="Please enter valid balance!")
    @Min(value=(long) 1D, message="Please enter valid balance!")
	private long accountBalance;
	
	private Date createdAt;
	
//	@NotBlank(message ="Please choose account type!")
	AccountType accountType;
	UserBean user;
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AccountBean [accountId=" + accountId + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + ", createdAt=" + createdAt + ", accountType=" + accountType + ", user=" + user + "]";
	}
}

	
	
	