package com.sap.eurocare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	private long id;
	
	@Column
	private long userId;
	
	@Column
	private long answerId;
	
	@Column
	private String message;
	
	@Column 
	private boolean done;
	
	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	/*@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date date;
*/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

/*
	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
*/
	
	
	
}
