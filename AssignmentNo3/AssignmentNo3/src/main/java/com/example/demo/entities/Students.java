package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
	private long id;
	private String title;
	private String description;
	private String dateOfAdmission;
	private long phoneNumber;

	public Students() {
		super();
	}

	public Students(long id, String title, String description, String dateOfAdmission, long phoneNumber) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.dateOfAdmission = dateOfAdmission;
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", title=" + title + ", description=" + description + ", dateOfAdmission="
				+ dateOfAdmission + ", phoneNumber=" + phoneNumber + "]";
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
