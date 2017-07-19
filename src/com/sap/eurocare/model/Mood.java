package com.sap.eurocare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mood {
	
	@Id
	@Column
	private long userId;
	
	@Column
	private long moodLevel;
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date date;

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMoodLevel() {
		return moodLevel;
	}

	public void setMoodLevel(long moodLevel) {
		this.moodLevel = moodLevel;
	}
	
	

}
