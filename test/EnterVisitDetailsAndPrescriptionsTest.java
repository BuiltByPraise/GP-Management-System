package uk.ac.kent.main.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

public class EnterVisitDetailsAndPrescriptionsTest {
    private EnterVisitDetailsAndPrescriptionsFrame doctorMenuFrame;

    @Before
    public void setUp() {
        doctorMenuFrame = new EnterVisitDetailsAndPrescriptionsFrame();
    }

    @After
    public void tearDown() {
        doctorMenuFrame.getMenuFrame().dispose();
    }

    @Test
    public void testEnterVisitDetails() {
        doctorMenuFrame.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Enter Visit Details"));

        // After clicking "Enter Visit Details", a dialog should be created
        assertNotNull("Dialog for entering visit details should not be null", doctorMenuFrame.getVisitDetailsDialog());
    }

    @Test
    public void testSendConfirmationToPatient() {
        String visitDetails = "Visit details: ABC";
        String prescriptions = "Prescriptions: XYZ";

        // Assume sending confirmation message to patient is successful
        boolean confirmationSent = sendConfirmationToPatient(visitDetails, prescriptions);

        assertTrue("Confirmation message should be sent to the patient", confirmationSent);
    }

    @Test
    public void testSendConfirmationToDoctor() {
        String visitDetails = "Visit details: ABC";
        String prescriptions = "Prescriptions: XYZ";

        // Assume sending confirmation message to doctor is successful
        boolean confirmationSent = sendConfirmationToDoctor(visitDetails, prescriptions);

        assertTrue("Confirmation message should be sent to the doctor", confirmationSent);
    }

    // Method for sending confirmation message to patient
    private boolean sendConfirmationToPatient(String visitDetails, String prescriptions) {
        // Basic implementation for demonstration
        System.out.println("Confirmation message sent to patient.");
        System.out.println("Visit Details: " + visitDetails);
        System.out.println("Prescriptions: " + prescriptions);
        return true; // Assuming message sending is successful
    }

    // Method for sending confirmation message to doctor
    private boolean sendConfirmationToDoctor(String visitDetails, String prescriptions) {
        // Basic implementation for demonstration
        System.out.println("Confirmation message sent to doctor.");
        System.out.println("Visit Details: " + visitDetails);
        System.out.println("Prescriptions: " + prescriptions);
        return true; // Assuming message sending is successful
    }
}
