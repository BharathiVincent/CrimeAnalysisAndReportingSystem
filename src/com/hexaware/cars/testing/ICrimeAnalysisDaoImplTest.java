package com.hexaware.cars.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.hexaware.cars.dao.ICrimeAnalysisDaoImpl;
import com.hexaware.cars.entity.Incident;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.dao.ICrimeAnalysisDaoImpl;

class ICrimeAnalysisDaoImplTest {
	 private static Connection connection;
	    private static ICrimeAnalysisDaoImpl dao;

	    @BeforeAll
	    static void setupDatabase() throws SQLException {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars", "root", "Vins@5545");
	        dao = new ICrimeAnalysisDaoImpl(connection);
	    }

	@Test
	void testInsertVictim() {
		Victim victim = new Victim();
        victim.setFirstName("John");
        victim.setLastName("Doe");
        victim.setDateOfBirth(Date.valueOf("1990-05-15"));
        victim.setGender("Male");
        victim.setContactInformation("john.doe@example.com");

        assertDoesNotThrow(() -> dao.insertVictim(victim));
    }
	@Test
    void testInsertIncident() {
        Incident incident = new Incident(
                0, // Incident ID auto-generated
                "Theft",
                Date.valueOf("2024-10-10"),
                "Downtown",
                "Reported phone theft near bus stop",
                "Open",
                1, // Make sure this VictimID exists
                1, // Make sure this SuspectID exists
                1  // Make sure this OfficerID exists
        );

        assertDoesNotThrow(() -> dao.insertIncident(incident));
    }
	@Test
    void testUpdateIncident() {
        Incident updatedIncident = new Incident(
                1, // Existing Incident ID to update
                "Assault",
                Date.valueOf("2024-11-11"),
                "City Center",
                "Altercation at the subway station",
                "Under Investigation",
                1, // Existing VictimID
                1, // Existing SuspectID
                1  // Existing OfficerID
        );

        assertDoesNotThrow(() -> dao.updateIncident(updatedIncident));
    }


	  @AfterAll
	    static void tearDown() throws SQLException {
	        connection.close();
	    }

}
