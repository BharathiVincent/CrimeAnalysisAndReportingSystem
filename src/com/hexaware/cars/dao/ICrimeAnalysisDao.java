package com.hexaware.cars.dao;

import com.hexaware.cars.entity.Evidence;
import com.hexaware.cars.entity.Incident;
import com.hexaware.cars.entity.LawEnforcementAgency;
import com.hexaware.cars.entity.Officer;
import com.hexaware.cars.entity.Report;
import com.hexaware.cars.entity.Suspect;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.exceptions.IncidentNumberNotFoundException;
import java.util.List;

public interface ICrimeAnalysisDao {
	// ------------------- Victims -------------------
	void insertVictim(Victim victim);

	Victim getVictimById(int victimID);

	List<Victim> getAllVictims();

	void updateVictim(Victim victim);

	void deleteVictim(int victimID);

	// ------------------- Suspects -------------------
	void insertSuspect(Suspect suspect);

	Suspect getSuspectById(int suspectID);

	List<Suspect> getAllSuspects();

	void updateSuspect(Suspect suspect);

	void deleteSuspect(int suspectID);

	// ------------------- Law Enforcement Agencies -------------------
	void insertAgency(LawEnforcementAgency agency);

	LawEnforcementAgency getAgencyById(int agencyID);

	List<LawEnforcementAgency> getAllAgencies();

	void updateAgency(LawEnforcementAgency agency);

	void deleteAgency(int agencyID);

	// ------------------- Officers -------------------
	void insertOfficer(Officer officer);

	Officer getOfficerById(int officerID);

	List<Officer> getAllOfficers();

	void updateOfficer(Officer officer);

	void deleteOfficer(int officerID);

	// ------------------- Incidents -------------------
	void insertIncident(Incident incident);

	Incident getIncidentById(int incidentID) throws IncidentNumberNotFoundException;

	List<Incident> getAllIncidents();

	void updateIncident(Incident incident);

	void deleteIncident(int incidentID);

	// ------------------- Evidence -------------------
	void insertEvidence(Evidence evidence);

	Evidence getEvidenceById(int evidenceID);

	List<Evidence> getAllEvidence();

	void updateEvidence(Evidence evidence);

	void deleteEvidence(int evidenceID);

	// ------------------- Reports -------------------
	void insertReport(Report report);

	Report getReportById(int reportID);

	List<Report> getAllReports();

	void updateReport(Report report);

	void deleteReport(int reportID);

	boolean createIncident(Incident incident);

}
