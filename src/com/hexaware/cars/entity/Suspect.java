package com.hexaware.cars.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Suspect {
	private int suspectID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String contactInformation; // e.g., Address, Phone Number

	// Default Constructor
	public Suspect(int i, String string, int j, String string2, String string3) {
	}

	// Parameterized Constructor
	public Suspect(int suspectID, String firstName, String lastName, Date dateOfBirth, String gender,
			String contactInformation) {
		this.suspectID = suspectID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contactInformation = contactInformation;
	}

	// Getters and Setters
	public int getSuspectID() {
		return suspectID;
	}

	public void setSuspectID(int suspectID) {
		this.suspectID = suspectID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(String contactInformation) {
		this.contactInformation = contactInformation;
	}

}
