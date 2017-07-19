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

	public long getUser() {
		return userId;
	}

	public void setUser(long userId) {
		this.userId = userId;
	}

	public long getMoodLevel() {
		return moodLevel;
	}

	public void setMoodLevel(long moodLevel) {
		this.moodLevel = moodLevel;
	}
	
	

}
