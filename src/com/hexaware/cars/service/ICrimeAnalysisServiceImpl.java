package com.hexaware.cars.service;
import com.hexaware.cars.dao.ICrimeAnalysisDao;
import com.hexaware.cars.entity.Evidence;
import com.hexaware.cars.entity.Incident;
import com.hexaware.cars.entity.LawEnforcementAgency;
import com.hexaware.cars.entity.Officer;
import com.hexaware.cars.entity.Report;
import com.hexaware.cars.entity.Suspect;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.exceptions.IncidentNumberNotFoundException;
import java.util.List;
public class ICrimeAnalysisServiceImpl implements ICrimeAnalysisService {
	private final ICrimeAnalysisDao crimeAnalysisDao;

    // Constructor for dependency injection
    public ICrimeAnalysisServiceImpl(ICrimeAnalysisDao crimeAnalysisDao) {
        this.crimeAnalysisDao = crimeAnalysisDao;
    }

    // Default constructor (if needed, but ensure DAO is initialized)
    public ICrimeAnalysisServiceImpl() {
        this.crimeAnalysisDao = null; // Consider how to initialize DAO properly if using this
    }

    // ------------------- Victims -------------------
    @Override
    public boolean insertVictim(Victim victim) throws Exception {
        try {
            crimeAnalysisDao.insertVictim(victim);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting victim: " + e.getMessage(), e);
        }
    }

    @Override
    public Victim getVictimById(int victimID) throws Exception {
        try {
            return crimeAnalysisDao.getVictimById(victimID);
        } catch (Exception e) {
            throw new Exception("Error retrieving victim by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Victim> getAllVictims() throws Exception {
        try {
            return crimeAnalysisDao.getAllVictims();
        } catch (Exception e) {
            throw new Exception("Error retrieving all victims: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateVictim(Victim victim) throws Exception {
        try {
            crimeAnalysisDao.updateVictim(victim);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating victim: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteVictim(int victimID) throws Exception {
        try {
            crimeAnalysisDao.deleteVictim(victimID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting victim: " + e.getMessage(), e);
        }
    }

    // ------------------- Suspects -------------------
    @Override
    public boolean insertSuspect(Suspect suspect) throws Exception {
        try {
            crimeAnalysisDao.insertSuspect(suspect);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting suspect: " + e.getMessage(), e);
        }
    }

    @Override
    public Suspect getSuspectById(int suspectID) throws Exception {
        try {
            return crimeAnalysisDao.getSuspectById(suspectID);
        } catch (Exception e) {
            throw new Exception("Error retrieving suspect by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Suspect> getAllSuspects() throws Exception {
        try {
            return crimeAnalysisDao.getAllSuspects();
        } catch (Exception e) {
            throw new Exception("Error retrieving all suspects: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateSuspect(Suspect suspect) throws Exception {
        try {
            crimeAnalysisDao.updateSuspect(suspect);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating suspect: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteSuspect(int suspectID) throws Exception {
        try {
            crimeAnalysisDao.deleteSuspect(suspectID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting suspect: " + e.getMessage(), e);
        }
    }

    // ------------------- Law Enforcement Agencies -------------------
    @Override
    public boolean insertAgency(LawEnforcementAgency agency) throws Exception {
        try {
            crimeAnalysisDao.insertAgency(agency);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting agency: " + e.getMessage(), e);
        }
    }

    @Override
    public LawEnforcementAgency getAgencyById(int agencyID) throws Exception {
        try {
            return crimeAnalysisDao.getAgencyById(agencyID);
        } catch (Exception e) {
            throw new Exception("Error retrieving agency by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<LawEnforcementAgency> getAllAgencies() throws Exception {
        try {
            return crimeAnalysisDao.getAllAgencies();
        } catch (Exception e) {
            throw new Exception("Error retrieving all agencies: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateAgency(LawEnforcementAgency agency) throws Exception {
        try {
            crimeAnalysisDao.updateAgency(agency);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating agency: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteAgency(int agencyID) throws Exception {
        try {
            crimeAnalysisDao.deleteAgency(agencyID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting agency: " + e.getMessage(), e);
        }
    }

    // ------------------- Officers -------------------
    @Override
    public boolean insertOfficer(Officer officer) throws Exception {
        try {
            crimeAnalysisDao.insertOfficer(officer);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting officer: " + e.getMessage(), e);
        }
    }

    @Override
    public Officer getOfficerById(int officerID) throws Exception {
        try {
            return crimeAnalysisDao.getOfficerById(officerID);
        } catch (Exception e) {
            throw new Exception("Error retrieving officer by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Officer> getAllOfficers() throws Exception {
        try {
            return crimeAnalysisDao.getAllOfficers();
        } catch (Exception e) {
            throw new Exception("Error retrieving all officers: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateOfficer(Officer officer) throws Exception {
        try {
            crimeAnalysisDao.updateOfficer(officer);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating officer: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteOfficer(int officerID) throws Exception {
        try {
            crimeAnalysisDao.deleteOfficer(officerID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting officer: " + e.getMessage(), e);
        }
    }

    // ------------------- Incidents -------------------
    @Override
    public boolean insertIncident(Incident incident) throws Exception {
        try {
            crimeAnalysisDao.insertIncident(incident);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting incident: " + e.getMessage(), e);
        }
    }

    @Override
    public Incident getIncidentById(int incidentID) throws Exception, IncidentNumberNotFoundException {
        try {
            return crimeAnalysisDao.getIncidentById(incidentID);
        } catch (IncidentNumberNotFoundException e) {
            throw e; // Re-throw the specific exception
        } catch (Exception e) {
            throw new Exception("Error retrieving incident by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Incident> getAllIncidents() throws Exception {
        try {
            return crimeAnalysisDao.getAllIncidents();
        } catch (Exception e) {
            throw new Exception("Error retrieving all incidents: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateIncident(Incident incident) throws Exception {
        try {
            crimeAnalysisDao.updateIncident(incident);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating incident: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteIncident(int incidentID) throws Exception {
        try {
            crimeAnalysisDao.deleteIncident(incidentID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting incident: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean createIncident(Incident incident) throws Exception {
        try {
            return crimeAnalysisDao.createIncident(incident);
        } catch (Exception e) {
            throw new Exception("Error creating incident: " + e.getMessage(), e);
        }
    }

    // ------------------- Evidence -------------------
    @Override
    public boolean insertEvidence(Evidence evidence) throws Exception {
        try {
            crimeAnalysisDao.insertEvidence(evidence);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting evidence: " + e.getMessage(), e);
        }
    }

    @Override
    public Evidence getEvidenceById(int evidenceID) throws Exception {
        try {
            return crimeAnalysisDao.getEvidenceById(evidenceID);
        } catch (Exception e) {
            throw new Exception("Error retrieving evidence by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Evidence> getAllEvidence() throws Exception {
        try {
            return crimeAnalysisDao.getAllEvidence();
        } catch (Exception e) {
            throw new Exception("Error retrieving all evidence: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateEvidence(Evidence evidence) throws Exception {
        try {
            crimeAnalysisDao.updateEvidence(evidence);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating evidence: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteEvidence(int evidenceID) throws Exception {
        try {
            crimeAnalysisDao.deleteEvidence(evidenceID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting evidence: " + e.getMessage(), e);
        }
    }

    // ------------------- Reports -------------------
    @Override
    public boolean insertReport(Report report) throws Exception {
        try {
            crimeAnalysisDao.insertReport(report);
            return true;
        } catch (Exception e) {
            throw new Exception("Error inserting report: " + e.getMessage(), e);
        }
    }

    @Override
    public Report getReportById(int reportID) throws Exception {
        try {
            return crimeAnalysisDao.getReportById(reportID);
        } catch (Exception e) {
            throw new Exception("Error retrieving report by ID: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Report> getAllReports() throws Exception {
        try {
            return crimeAnalysisDao.getAllReports();
        } catch (Exception e) {
            throw new Exception("Error retrieving all reports: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateReport(Report report) throws Exception {
        try {
            crimeAnalysisDao.updateReport(report);
            return true;
        } catch (Exception e) {
            throw new Exception("Error updating report: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteReport(int reportID) throws Exception {
        try {
            crimeAnalysisDao.deleteReport(reportID);
            return true;
        } catch (Exception e) {
            throw new Exception("Error deleting report: " + e.getMessage(), e);
        }
    }
}
