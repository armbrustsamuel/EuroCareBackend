package com.sap.eurocare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	private long userId;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String gender;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date birthDate;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date registrationDate;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public java.sql.Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.sql.Date birthDate) {
		this.birthDate = birthDate;
	}

	public java.sql.Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.sql.Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
