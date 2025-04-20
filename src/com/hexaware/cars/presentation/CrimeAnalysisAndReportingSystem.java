package com.hexaware.cars.presentation;
import com.hexaware.cars.dao.ICrimeAnalysisDao;
import com.hexaware.cars.dao.ICrimeAnalysisDaoImpl;
import com.hexaware.cars.entity.LawEnforcementAgency;
import com.hexaware.cars.entity.Officer;
import com.hexaware.cars.entity.Suspect;
import com.hexaware.cars.entity.Victim;
import com.hexaware.cars.service.ICrimeAnalysisServiceImpl;
import com.hexaware.cars.service.ICrimeAnalysisService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class CrimeAnalysisAndReportingSystem {
	private static ICrimeAnalysisService service;

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/cars";
        String username = "root";
        String password = "Vins@5545";

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Initialize DAO implementation
            ICrimeAnalysisDao dao = new ICrimeAnalysisDaoImpl(connection);

            // Initialize Service implementation with the DAO
            service = new ICrimeAnalysisServiceImpl(dao);

            while (true) {
                // Show the menu to the user
                showMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();   // Consume the newline character

                switch (choice) {
                    case 1:
                        insertVictim(scanner);
                        break;
                    case 2:
                        retrieveVictim(scanner);
                        break;
                    case 3:
                        updateVictim(scanner);
                        break;
                    case 4:
                        insertSuspect(scanner);
                        break;
                    case 5:
                        retrieveSuspect(scanner);
                        break;
                    case 6:
                        insertAgency(scanner);
                        break;
                    case 7:
                        retrieveAgency(scanner);
                        break;
                    case 8:
                        insertOfficer(scanner);
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Display the menu options
    private static void showMenu() {
        System.out.println("\n--- Crime Analysis System ---");
        System.out.println("1. Insert Victim");
        System.out.println("2. Retrieve Victim by ID");
        System.out.println("3. Update Victim");
        System.out.println("4. Insert Suspect");
        System.out.println("5. Retrieve Suspect by ID");
        System.out.println("6. Insert Law Enforcement Agency");
        System.out.println("7. Retrieve Law Enforcement Agency by ID");
        System.out.println("8. Insert Officer");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void insertVictim(Scanner scanner) {
        System.out.print("Enter Victim's First Name: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }

        System.out.print("Enter Victim's Last Name: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        System.out.print("Enter Victim's Date of Birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine().trim();
        java.sql.Date dob;
        try {
            dob = java.sql.Date.valueOf(dobString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
            return;
        }

        System.out.print("Enter Victim's Gender (Male/Female/Other): ");
        String gender = scanner.nextLine().trim();
        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))) {
            System.out.println("Invalid gender. Please enter Male, Female, or Other.");
            return;
        }

        System.out.print("Enter Victim's Contact Information: ");
        String contactInformation = scanner.nextLine().trim();
        if (contactInformation.isEmpty()) {
            System.out.println("Contact information cannot be empty.");
            return;
        }

        Victim victim = new Victim(0, firstName, lastName, dob, gender, contactInformation); // Assuming VictimID is auto-generated
        try {
            service.insertVictim(victim);
            System.out.println("Victim inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting victim: " + e.getMessage());
        }
    }

    // Retrieve Victim by ID
    private static void retrieveVictim(Scanner scanner) {
        System.out.print("Enter Victim's ID to retrieve: ");
        int victimId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            Victim victim = service.getVictimById(victimId);
            if (victim != null) {
                System.out.println("Victim Details: ID=" + victim.getVictimID() + ", Name=" + victim.getFirstName() + ", Last Name=" + victim.getLastName() + ", DOB=" + victim.getDateOfBirth() + ", Gender=" + victim.getGender() + ", Contact=" + victim.getContactInformation());
            } else {
                System.out.println("No Victim found with ID: " + victimId);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving victim: " + e.getMessage());
        }
    }

    // Update Victim
    private static void updateVictim(Scanner scanner) {
        System.out.print("Enter Victim's ID to update: ");
        int victimId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            Victim victim = service.getVictimById(victimId);
            if (victim != null) {
                System.out.print("Enter new First Name: ");
                String newFirstName = scanner.nextLine();
                System.out.print("Enter new Last Name: ");
                String newLastName = scanner.nextLine();
                System.out.print("Enter new Date of Birth (YYYY-MM-DD): ");
                String newDobString = scanner.nextLine();
                java.sql.Date newDob = java.sql.Date.valueOf(newDobString);
                System.out.print("Enter new Gender: ");
                String newGender = scanner.nextLine();
                System.out.print("Enter new Contact Information: ");
                String newContactInformation = scanner.nextLine();

                victim.setFirstName(newFirstName);
                victim.setLastName(newLastName);
                victim.setDateOfBirth(newDob);
                victim.setGender(newGender);
                victim.setContactInformation(newContactInformation);
                service.updateVictim(victim);
                System.out.println("Victim details updated successfully.");
            } else {
                System.out.println("No Victim found with ID: " + victimId);
            }
        } catch (Exception e) {
            System.err.println("Error updating victim: " + e.getMessage());
        }
    }

    // Insert Suspect
    private static void insertSuspect(Scanner scanner) {
        System.out.print("Enter Suspect's First Name: ");
        String firstName = scanner.nextLine().trim();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }

        System.out.print("Enter Suspect's Last Name: ");
        String lastName = scanner.nextLine().trim();
        if (lastName.isEmpty()) {
            System.out.println("Last name cannot be empty.");
            return;
        }

        System.out.print("Enter Suspect's Date of Birth (YYYY-MM-DD): ");
        String dobString = scanner.nextLine().trim();
        java.sql.Date dob;
        try {
            dob = java.sql.Date.valueOf(dobString);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid date format. Please enter in YYYY-MM-DD format.");
            return;
        }

        System.out.print("Enter Suspect's Gender: ");
        String gender = scanner.nextLine().trim();
        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("Other"))) {
            System.out.println("Invalid gender. Please enter Male, Female, or Other.");
            return;
        }

        System.out.print("Enter Suspect's Contact Information: ");
        String contactInformation = scanner.nextLine().trim();
        if (contactInformation.isEmpty()) {
            System.out.println("Contact information cannot be empty.");
            return;
        }

        Suspect suspect = new Suspect(0, firstName, lastName, dob, gender, contactInformation); // SuspectID is auto-generated.
        try {
            service.insertSuspect(suspect);
            System.out.println("Suspect inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting suspect: " + e.getMessage());
        }
    }


    // Retrieve Suspect by ID
    private static void retrieveSuspect(Scanner scanner) {
        System.out.print("Enter Suspect's ID to retrieve: ");
        int suspectId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            Suspect suspect = service.getSuspectById(suspectId);
            if (suspect != null) {
                System.out.println("Suspect Details: ID=" + suspect.getSuspectID() + ", Name=" + suspect.getFirstName() + ", Last Name=" + suspect.getLastName() + ", DOB=" + suspect.getDateOfBirth() + ", Gender=" + suspect.getGender() + ", Contact=" + suspect.getContactInformation());
            } else {
                System.out.println("No Suspect found with ID: " + suspectId);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving suspect: " + e.getMessage());
        }
    }

    // Insert Law Enforcement Agency
    private static void insertAgency(Scanner scanner) {
        System.out.print("Enter Agency Name: ");
        String agencyName = scanner.nextLine();
        System.out.print("Enter Agency Jurisdiction: ");
        String jurisdiction = scanner.nextLine();
        System.out.print("Enter Agency Contact Information: ");
        String contactInformation = scanner.nextLine();

        LawEnforcementAgency agency = new LawEnforcementAgency(0, agencyName, jurisdiction, contactInformation);  // AgencyID is auto-generated
        try {
            service.insertAgency(agency);
            System.out.println("Law Enforcement Agency inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting agency: " + e.getMessage());
        }
    }

    // Retrieve Law Enforcement Agency by ID
    private static void retrieveAgency(Scanner scanner) {
        System.out.print("Enter Agency's ID to retrieve: ");
        int agencyId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try {
            LawEnforcementAgency agency = service.getAgencyById(agencyId);
            if (agency != null) {
                System.out.println("Agency Details: ID=" + agency.getAgencyID() + ", Name=" + agency.getAgencyName() + ", Jurisdiction=" + agency.getJurisdiction() + ", Contact=" + agency.getContactInformation());
            } else {
                System.out.println("No Agency found with ID: " + agencyId);
            }
        } catch (Exception e) {
            System.err.println("Error retrieving agency: " + e.getMessage());
        }
    }

    // Insert Officer
    private static void insertOfficer(Scanner scanner) {
        System.out.print("Enter Officer's First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Officer's Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Officer's Badge Number: ");
        String badgeNumber = scanner.nextLine();
        System.out.print("Enter Officer's Rank: ");
        String rank = scanner.nextLine();
        System.out.print("Enter Officer's Contact Information: ");
        String contactInformation = scanner.nextLine();
        System.out.print("Enter Officer's Agency ID: ");
        int agencyID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        
        Officer officer = new Officer(0, firstName, lastName, badgeNumber, rank, contactInformation, agencyID); // OfficerID is auto-generated
        try {
            service.insertOfficer(officer);
            System.out.println("Officer inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error inserting officer: " + e.getMessage());
        }
    }
}

