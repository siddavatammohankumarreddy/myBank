package com.mybank.dto;

import java.util.Date;

public class FundTransferDto {
	private Long toAccountNumber;
	private double amount;
	private Long accountNumber;
	private String description;
	private Date date;
	
	private Long transactionId;
	
	public FundTransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FundTransferDto(Long toAccountNumber, double amount, Long accountNumber, String description, Date date,
			Long transactionId) {
		super();
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.description = description;
		this.date = date;
		this.transactionId = transactionId;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public String getDescription() {
		return description;
	}
	public Date getDate() {
		return date;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	
}
