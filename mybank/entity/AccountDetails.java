package com.mybank.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountDetails {
	@Id
	private Long accountId;
	private String accountHolderName;
	private Long accountNumber;
	private String accountType;
	private double openingBalance;
	private double currentBalance;
	
	private String openingDate;
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userId", nullable = false)
	private User user;
	public Long getAccountId() {
		return accountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public double getCurrentBalance() {
		return currentBalance;
	}
	public String getOpeningDate() {
		return openingDate;
	}
	public User getUser() {
		return user;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	public void setOpeningDate(String openingDate) {
		this.openingDate = openingDate;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
