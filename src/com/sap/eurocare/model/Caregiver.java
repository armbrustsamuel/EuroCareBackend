package com.sap.eurocare.model;

import javax.persistence.Column;

public class Caregiver extends User{
	
	@Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private java.sql.Date registrationDate;
	
	public java.sql.Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(java.sql.Date date) {
		this.registrationDate = date;
	}
}
