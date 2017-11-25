package com.sap.eurocare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	private long userId;
	
	@Column(nullable = false)
	private String name;
	
	@Column
	private String gender;
	
	@Column
	private boolean unstable;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date birthDate;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date diagnosalDate;
	
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

	public java.sql.Date getDiagnosalDate() {
		return diagnosalDate;
	}

	public void setDiagnosalDate(java.sql.Date diagnosalDate) {
		this.diagnosalDate = diagnosalDate;
	}
	
	public boolean isUnstable() {
		return unstable;
	}

	public void setUnstable(boolean unstable) {
		this.unstable = unstable;
	}


}
