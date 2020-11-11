package com.mybank.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	private Long userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private Long phoneNumber;
	private String email;
	private int age;
	private String gender;
	private String dob;
	private Long aadharNumber;
	private String panNumber;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private AccountDetails account;

	public Long getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDob() {
		return dob;
	}

	public Long getAadharNumber() {
		return aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public AccountDetails getAccount() {
		return account;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public void setAccount(AccountDetails account) {
		this.account = account;
	}

}