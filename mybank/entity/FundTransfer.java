package com.mybank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fund_transfer")
public class FundTransfer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	private Long accountNumber;
	private Long toAccountNumber;
	private double amount;
	private String description;
	private Date date;
	public Long getTransactionId() {
		return transactionId;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public Long getToAccountNumber() {
		return toAccountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public String getDescription() {
		return description;
	}
	public Date getDate() {
		return date;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setToAccountNumber(Long toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
