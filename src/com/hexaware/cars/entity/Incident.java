package com.hexaware.cars.entity;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Incident {
	private int incidentID;
    private String incidentType;
    private Date incidentDate;
    private String location; // Geospatial: Latitude and Longitude as String or separate fields
    private String description;
    private String status; // e.g., Open, Closed, Under Investigation
    private int victimID;
    private int suspectID;
    private int officerID;

    // Default Constructor
    public Incident(int i, String string, String string2, LocalDateTime localDateTime, String string3, int j) {
    }

    // Parameterized Constructor
    public Incident(int incidentID, String incidentType, Date incidentDate, String location,
                    String description, String status, int victimID, int suspectID, int officerID) {
        this.incidentID = incidentID;
        this.incidentType = incidentType;
        this.incidentDate = incidentDate;
        this.location = location;
        this.description = description;
        this.status = status;
        this.victimID = victimID;
        this.suspectID = suspectID;
        this.officerID = officerID;
    }

    // Getters and Setters
    public int getIncidentID() {
        return incidentID;
    }

    public void setIncidentID(int incidentID) {
        this.incidentID = incidentID;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public  Date getIncidentDate() {
        return  incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVictimID() {
        return victimID;
    }

    public void setVictimID(int victimID) {
        this.victimID = victimID;
    }

    public int getSuspectID() {
        return suspectID;
    }

    public void setSuspectID(int suspectID) {
        this.suspectID = suspectID;
    }

    public int getOfficerID() {
        return officerID;
    }

    public void setOfficerID(int officerID) {
        this.officerID = officerID;
    }

	
}



