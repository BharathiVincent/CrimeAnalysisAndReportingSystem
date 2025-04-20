package com.hexaware.cars.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Report {
	private int reportID;
	private int incidentID; // Foreign Key linking to Incidents
	private int reportingOfficerID; // Foreign Key linking to Officers
	private Date reportDate;
	private String reportDetails;
	private String status; // e.g., Draft, Finalized

	// Default Constructor
	public Report(int i, LocalDateTime localDateTime, String string, int j, int k) {
	}

	// Parameterized Constructor
	public Report(int reportID, int incidentID, int reportingOfficerID, Date reportDate, String reportDetails,
			String status) {
		this.reportID = reportID;
		this.incidentID = incidentID;
		this.reportingOfficerID = reportingOfficerID;
		this.reportDate = reportDate;
		this.reportDetails = reportDetails;
		this.status = status;
	}

	// Getters and Setters
	public int getReportID() {
		return reportID;
	}

	public void setReportID(int reportID) {
		this.reportID = reportID;
	}

	public int getIncidentID() {
		return incidentID;
	}

	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public int getReportingOfficerID() {
		return reportingOfficerID;
	}

	public void setReportingOfficerID(int reportingOfficerID) {
		this.reportingOfficerID = reportingOfficerID;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportDetails() {
		return reportDetails;
	}

	public void setReportDetails(String reportDetails) {
		this.reportDetails = reportDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
