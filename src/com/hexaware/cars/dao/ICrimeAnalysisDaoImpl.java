package com.hexaware.cars.dao;

import com.hexaware.cars.entity.Evidence;
import com.hexaware.cars.entity.Incident;
import com.hexaware.cars.entity.LawEnforcementAgency;
import com.hexaware.cars.entity.Officer;
import com.hexaware.cars.entity.Report;
import com.hexaware.cars.entity.Suspect;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.exceptions.IncidentNumberNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ICrimeAnalysisDaoImpl implements ICrimeAnalysisDao {
	private Connection connection;

	// Constructor to establish connection
	public ICrimeAnalysisDaoImpl(Connection connection) {
	        this.connection = connection;
	    }

	public ICrimeAnalysisDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	// ------------------- Victims -------------------
	@Override
	public void insertVictim(Victim victim) {
        String sql = "INSERT INTO Victims (FirstName, LastName, DateOfBirth, Gender, ContactInformation) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, victim.getFirstName());
            stmt.setString(2, victim.getLastName());
            stmt.setDate(3, victim.getDateOfBirth());
            stmt.setString(4, victim.getGender());
            stmt.setString(5, victim.getContactInformation());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public Victim getVictimById(int victimID) {
		String sql = "SELECT * FROM victims WHERE victimID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, victimID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				 return new Victim(rs.getInt("VictimID"), rs.getString("FirstName"), rs.getString("LastName"),
	                        rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("ContactInformation"));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Victim> getAllVictims() {
		List<Victim> victims = new ArrayList<>();
		String sql = "SELECT * FROM victims";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				 victims.add(new Victim(rs.getInt("VictimID"), rs.getString("FirstName"), rs.getString("LastName"),
	                        rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("ContactInformation")));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return victims;
	}

	@Override
	public void updateVictim(Victim victim) {
        String sql = "UPDATE Victims SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, ContactInformation = ? WHERE VictimID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			 stmt.setString(1, victim.getFirstName());
	            stmt.setString(2, victim.getLastName());
	            stmt.setDate(3, victim.getDateOfBirth());
	            stmt.setString(4, victim.getGender());
	            stmt.setString(5, victim.getContactInformation());
	            stmt.setInt(6, victim.getVictimID());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVictim(int victimID) {
		String sql = "DELETE FROM victims WHERE victimID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, victimID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Suspects -------------------
	@Override
	public void insertSuspect(Suspect suspect) {
		  String sql = "INSERT INTO Suspects (FirstName, LastName, DateOfBirth, Gender, ContactInformation) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, suspect.getFirstName());
	            stmt.setString(2, suspect.getLastName());
	            stmt.setDate(3, suspect.getDateOfBirth());
	            stmt.setString(4, suspect.getGender());
	            stmt.setString(5, suspect.getContactInformation());
	            stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Suspect getSuspectById(int suspectID) {
		String sql = "SELECT * FROM suspects WHERE SuspectID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, suspectID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				 return new Suspect(rs.getInt("SuspectID"), rs.getString("FirstName"), rs.getString("LastName"),
	                        rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("ContactInformation"));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Suspect> getAllSuspects() {
		List<Suspect> suspects = new ArrayList<>();
		String sql = "SELECT * FROM suspects";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				 suspects.add(new Suspect(rs.getInt("SuspectID"), rs.getString("FirstName"), rs.getString("LastName"),
	                        rs.getDate("DateOfBirth"), rs.getString("Gender"), rs.getString("ContactInformation")));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return suspects;
	}

	@Override
	public void updateSuspect(Suspect suspect) {
		 String sql = "UPDATE Suspects SET FirstName = ?, LastName = ?, DateOfBirth = ?, Gender = ?, ContactInformation = ? WHERE SuspectID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, suspect.getFirstName());
	            stmt.setString(2, suspect.getLastName());
	            stmt.setDate(3, suspect.getDateOfBirth());
	            stmt.setString(4, suspect.getGender());
	            stmt.setString(5, suspect.getContactInformation());
	            stmt.setInt(6, suspect.getSuspectID());
	            stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteSuspect(int suspectID) {
		String sql = "DELETE FROM Suspects WHERE SuspectID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, suspectID);
            stmt.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Law Enforcement Agencies -------------------
	@Override
	public void insertAgency(LawEnforcementAgency agency) {
		String sql = "INSERT INTO LawEnforcementAgencies (AgencyName, Jurisdiction, ContactInformation) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, agency.getAgencyName());
            stmt.setString(2, agency.getJurisdiction());
            stmt.setString(3, agency.getContactInformation());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public LawEnforcementAgency getAgencyById(int agencyID) {
		String sql = "SELECT * FROM LawEnforcementAgencies WHERE AgencyID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, agencyID);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				 return new LawEnforcementAgency(rs.getInt("AgencyID"), rs.getString("AgencyName"),
	                        rs.getString("Jurisdiction"), rs.getString("ContactInformation"));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	 public List<LawEnforcementAgency> getAllAgencies() {
        List<LawEnforcementAgency> agencies = new ArrayList<>();
        String sql = "SELECT * FROM LawEnforcementAgencies";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                agencies.add(new LawEnforcementAgency(rs.getInt("AgencyID"), rs.getString("AgencyName"),
                        rs.getString("Jurisdiction"), rs.getString("ContactInformation")));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return agencies;
	}

	@Override
	public void updateAgency(LawEnforcementAgency agency) {
		String sql = "UPDATE LawEnforcementAgencies SET AgencyName = ?, Jurisdiction = ?, ContactInformation = ? WHERE AgencyID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, agency.getAgencyName());
            stmt.setString(2, agency.getJurisdiction());
            stmt.setString(3, agency.getContactInformation());
            stmt.setInt(4, agency.getAgencyID());
            stmt.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAgency(int agencyID) {
		String sql = "DELETE FROM LawEnforcementAgencies WHERE AgencyID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, agencyID);
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Officers -------------------
	@Override
	public void insertOfficer(Officer officer) {
		String sql = "INSERT INTO Officers (FirstName, LastName, BadgeNumber, `Rank`, ContactInformation, AgencyID) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, officer.getFirstName());
            stmt.setString(2, officer.getLastName());
            stmt.setString(3, officer.getBadgeNumber());
            stmt.setString(4, officer.getRank());
            stmt.setString(5, officer.getContactInformation());
            stmt.setInt(6, officer.getAgencyID());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Officer getOfficerById(int officerID) {
		 String sql = "SELECT * FROM Officers WHERE OfficerID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, officerID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Officer(rs.getInt("OfficerID"), rs.getString("FirstName"), rs.getString("LastName"),
	                        rs.getString("BadgeNumber"), rs.getString("Rank"), rs.getString("ContactInformation"),
	                        rs.getInt("AgencyID"));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Officer> getAllOfficers() {
		List<Officer> officers = new ArrayList<>();
		String sql = "SELECT * FROM officers";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				officers.add(new Officer(rs.getInt("OfficerID"), rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("BadgeNumber"), rs.getString("Rank"), rs.getString("ContactInformation"),
                        rs.getInt("AgencyID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return officers;
	}

	@Override
	public void updateOfficer(Officer officer) {
		 String sql = "UPDATE Officers SET FirstName = ?, LastName = ?, BadgeNumber = ?, `Rank` = ?, ContactInformation = ?, AgencyID = ? WHERE OfficerID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, officer.getFirstName());
	            stmt.setString(2, officer.getLastName());
	            stmt.setString(3, officer.getBadgeNumber());
	            stmt.setString(4, officer.getRank());
	            stmt.setString(5, officer.getContactInformation());
	            stmt.setInt(6, officer.getAgencyID());
	            stmt.setInt(7, officer.getOfficerID());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOfficer(int officerID) {
		String sql = "DELETE FROM Officers WHERE OfficerID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, officerID);
            stmt.executeUpdate();
        }  catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Incidents -------------------
	@Override
	public void insertIncident(Incident incident) {
		 String sql = "INSERT INTO Incidents (IncidentType, IncidentDate, Location, Description, Status, VictimID, SuspectID, OfficerID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setString(1, incident.getIncidentType());
	            stmt.setDate(2, incident.getIncidentDate());
	            stmt.setString(3, incident.getLocation());
	            stmt.setString(4, incident.getDescription());
	            stmt.setString(5, incident.getStatus());
	            stmt.setInt(6, incident.getVictimID());
	            stmt.setInt(7, incident.getSuspectID());
	            stmt.setInt(8, incident.getOfficerID());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Incident getIncidentById(int incidentID) throws IncidentNumberNotFoundException {
		String sql = "SELECT * FROM Incidents WHERE IncidentID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, incidentID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Incident(
                        rs.getInt("IncidentID"),
                        rs.getString("IncidentType"),
                        rs.getDate("IncidentDate"),
                        rs.getString("Location"),
                        rs.getString("Description"),
                        rs.getString("Status"),
                        rs.getInt("VictimID"),
                        rs.getInt("SuspectID"),
                        rs.getInt("OfficerID"));
            }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new IncidentNumberNotFoundException("Incident ID not found: " + incidentID);
		}
		return null;
	}

	@Override
	public List<Incident> getAllIncidents() {
		List<Incident> incidents = new ArrayList<>();
		String sql = "SELECT * FROM Incidents";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				incidents.add(
				   new Incident(
                           rs.getInt("IncidentID"),
                           rs.getString("IncidentType"),
                           rs.getDate("IncidentDate"),
                           rs.getString("Location"),
                           rs.getString("Description"),
                           rs.getString("Status"),
                           rs.getInt("VictimID"),
                           rs.getInt("SuspectID"),
                           rs.getInt("OfficerID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return incidents;
	}

	@Override
	public void updateIncident(Incident incident) {
		String sql = "UPDATE Incidents SET IncidentType = ?, IncidentDate = ?, Location = ?, Description = ?, Status = ?, VictimID = ?, SuspectID = ?, OfficerID = ? WHERE IncidentID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, incident.getIncidentType());
            stmt.setDate(2, incident.getIncidentDate());
            stmt.setString(3, incident.getLocation());
            stmt.setString(4, incident.getDescription());
            stmt.setString(5, incident.getStatus());
            stmt.setInt(6, incident.getVictimID());
            stmt.setInt(7, incident.getSuspectID());
            stmt.setInt(8, incident.getOfficerID());
            stmt.setInt(9, incident.getIncidentID());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteIncident(int incidentID) {
		  String sql = "DELETE FROM Incidents WHERE IncidentID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, incidentID);
	            stmt.executeUpdate();
	        }catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Evidence -------------------
	@Override
	public void insertEvidence(Evidence evidence) {
		String sql = "INSERT INTO Evidence (Description, LocationFound, IncidentID) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, evidence.getDescription());
            stmt.setString(2, evidence.getLocationFound());
            stmt.setInt(3, evidence.getIncidentID());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Evidence getEvidenceById(int evidenceID) {
		String sql = "SELECT * FROM evidence WHERE EvidenceID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, evidenceID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Evidence(
                        rs.getInt("EvidenceID"),
                        rs.getString("Description"),
                        rs.getString("LocationFound"),
                        rs.getInt("IncidentID"));
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Evidence> getAllEvidence() {
		List<Evidence> evidenceList = new ArrayList<>();
		String sql = "SELECT * FROM evidence";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				 evidenceList.add(
	                        new Evidence(
	                                rs.getInt("EvidenceID"),
	                                rs.getString("Description"),
	                                rs.getString("LocationFound"),
	                                rs.getInt("IncidentID")));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return evidenceList;
	}

	@Override
	public void updateEvidence(Evidence evidence) {
		String sql = "UPDATE Evidence SET Description = ?, LocationFound = ?, IncidentID = ? WHERE EvidenceID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, evidence.getDescription());
            stmt.setString(2, evidence.getLocationFound());
            stmt.setInt(3, evidence.getIncidentID());
            stmt.setInt(4, evidence.getEvidenceID());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEvidence(int evidenceID) {
		 String sql = "DELETE FROM Evidence WHERE EvidenceID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, evidenceID);
	            stmt.executeUpdate();
	        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ------------------- Reports -------------------
	@Override
	public void insertReport(Report report) {
		String sql = "INSERT INTO Reports (IncidentID, ReportingOfficerID, ReportDate, ReportDetails, Status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, report.getIncidentID());
            stmt.setInt(2, report.getReportingOfficerID());
            stmt.setDate(3, report.getReportDate());
            stmt.setString(4, report.getReportDetails());
            stmt.setString(5, report.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Report getReportById(int reportID) {
		   String sql = "SELECT * FROM Reports WHERE ReportID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, reportID);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return new Report(
	                        rs.getInt("ReportID"),
	                        rs.getInt("IncidentID"),
	                        rs.getInt("ReportingOfficerID"),
	                        rs.getDate("ReportDate"),
	                        rs.getString("ReportDetails"),
	                        rs.getString("Status"));
	            }
	        } catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Report> getAllReports() {
		List<Report> reports = new ArrayList<>();
		String sql = "SELECT * FROM reports";
		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				   reports.add(
	                        new Report(
	                                rs.getInt("ReportID"),
	                                rs.getInt("IncidentID"),
	                                rs.getInt("ReportingOfficer"),
	                                rs.getDate("ReportDate"),
	                                rs.getString("ReportDetails"),
	                                rs.getString("Status")));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reports;
	}

	@Override
	public void updateReport(Report report) {
		 String sql = "UPDATE Reports SET IncidentID = ?, ReportingOfficerID = ?, ReportDate = ?, ReportDetails = ?, Status = ? WHERE ReportID = ?";
	        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	            stmt.setInt(1, report.getIncidentID());
	            stmt.setInt(2, report.getReportingOfficerID());
	            stmt.setDate(3, report.getReportDate());
	            stmt.setString(4, report.getReportDetails());
	            stmt.setString(5, report.getStatus());
	            stmt.setInt(6, report.getReportID());
	            stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteReport(int reportID) {
		String sql = "DELETE FROM reports WHERE ReportID = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, reportID);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private final Map<Integer, Incident> incidentMap = new HashMap<>();

	// Create Incident
	@Override
	public boolean createIncident(Incident incident) {
		if (incident == null || incident.getIncidentID() <= 0) {
			return false; // Invalid incident or invalid incidentID (assuming non-positive IDs are
							// invalid)
		}

		// Check if the incident already exists using the incident ID
		if (incidentMap.containsKey(incident.getIncidentID())) {
			return false; // Incident with the same ID already exists
		}

		// Add the new incident to the map using the incident's ID as the key
		incidentMap.put(incident.getIncidentID(), incident);
		return true; // Incident successfully created
	}

	public void setConnection(Connection Connection) {
		// TODO Auto-generated method stub
		this.connection=connection;
	}
}
