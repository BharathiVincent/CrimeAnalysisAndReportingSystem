package com.hexaware.cars.service;

import com.hexaware.cars.entity.Evidence;
import com.hexaware.cars.entity.Incident;
import com.hexaware.cars.entity.LawEnforcementAgency;
import com.hexaware.cars.entity.Officer;
import com.hexaware.cars.entity.Report;
import com.hexaware.cars.entity.Suspect;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.exceptions.IncidentNumberNotFoundException;
import java.util.List;

public interface ICrimeAnalysisService {
	// ------------------- Victims -------------------
	boolean insertVictim(Victim victim) throws Exception;

	Victim getVictimById(int victimID) throws Exception;

	List<Victim> getAllVictims() throws Exception;

	boolean updateVictim(Victim victim) throws Exception;

	boolean deleteVictim(int victimID) throws Exception;

	// ------------------- Suspects -------------------
	boolean insertSuspect(Suspect suspect) throws Exception;

	Suspect getSuspectById(int suspectID) throws Exception;

	List<Suspect> getAllSuspects() throws Exception;

	boolean updateSuspect(Suspect suspect) throws Exception;

	boolean deleteSuspect(int suspectID) throws Exception;

	// ------------------- Law Enforcement Agencies -------------------
	boolean insertAgency(LawEnforcementAgency agency) throws Exception;

	LawEnforcementAgency getAgencyById(int agencyID) throws Exception;

	List<LawEnforcementAgency> getAllAgencies() throws Exception;

	boolean updateAgency(LawEnforcementAgency agency) throws Exception;

	boolean deleteAgency(int agencyID) throws Exception;

	// ------------------- Officers -------------------
	boolean insertOfficer(Officer officer) throws Exception;

	Officer getOfficerById(int officerID) throws Exception;

	List<Officer> getAllOfficers() throws Exception;

	boolean updateOfficer(Officer officer) throws Exception;

	boolean deleteOfficer(int officerID) throws Exception;

	// ------------------- Incidents -------------------
	boolean insertIncident(Incident incident) throws Exception;

	Incident getIncidentById(int incidentID) throws Exception, IncidentNumberNotFoundException;

	List<Incident> getAllIncidents() throws Exception;

	boolean updateIncident(Incident incident) throws Exception;

	boolean deleteIncident(int incidentID) throws Exception;

	boolean createIncident(Incident incident) throws Exception;

	// ------------------- Evidence -------------------
	boolean insertEvidence(Evidence evidence) throws Exception;

	Evidence getEvidenceById(int evidenceID) throws Exception;

	List<Evidence> getAllEvidence() throws Exception;

	boolean updateEvidence(Evidence evidence) throws Exception;

	boolean deleteEvidence(int evidenceID) throws Exception;

	// ------------------- Reports -------------------
	boolean insertReport(Report report) throws Exception;

	Report getReportById(int reportID) throws Exception;

	List<Report> getAllReports() throws Exception;

	boolean updateReport(Report report) throws Exception;

	boolean deleteReport(int reportID) throws Exception;
}
