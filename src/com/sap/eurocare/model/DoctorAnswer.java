package com.sap.eurocare.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorAnswer {
	
	@Id
	private long userId;
	
	@Column
	private String message;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date date;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

}
