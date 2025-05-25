package uk.ac.kent.main.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EditVisitDetailsFrameTest {
    
    private EditVisitDetailsFrame editVisitDetailsFrame; 

    @Before 
    public void setUp()
    {
        editVisitDetailsFrame = new EditVisitDetailsFrame();
    }

    @After 
    public void tearDown()
    {
        editVisitDetailsFrame.EditVisitDetailsFrame().dispose();
    }

    @Test 
    public void testInCorrectInputForBookingID()
    {
        // Simulate invalid input for Booking ID 
        editVisitDetailsFrame.getBookingIDTextField().setText("one"); // Enter a string instead of Integer
        editVisitDetailsFrame.getVisitDetailsTextField().setText("aaaaaaaa"); // Enter correct input
        editVisitDetailsFrame.getnewPrescriptionTextField().setText("bbbbbbb"); //Enter correct input

        // Simulate clicking the submit button
        editVisitDetailsFrame.actionPerformed(null);

         // Check if the booking ID text field still contains the invalid input
        assertEquals("one", editVisitDetailsFrame.getBookingIDTextField().getText());
    }

    @Test 
    public void testNullValuesForVisitDetails()
    {
        editVisitDetailsFrame.getBookingIDTextField().setText("1"); // Corect value for BookingID
        editVisitDetailsFrame.getVisitDetailsTextField().setText(""); // Empty value for visitDetails
        editVisitDetailsFrame.getnewPrescriptionTextField().setText("bbbbbb"); // Correct value for new Prescription
        
        //Simulate clicking the submit button
        editVisitDetailsFrame.actionPerformed(null);

        // Check to see if the submitted value for visit details is empty.
        assertEquals("", editVisitDetailsFrame.getVisitDetailsTextField().getText());        
    }

    @Test
    public void testNullValuesForNewPrescription()
    {
        editVisitDetailsFrame.getBookingIDTextField().setText("1"); // Correct value for bookingID
        editVisitDetailsFrame.getVisitDetailsTextField().setText("aaaaaa"); // Correct value for visitDetails
        editVisitDetailsFrame.getnewPrescriptionTextField().setText(""); // Empty value for newPrescription.

        // Simulate clicking the submmit button 
        editVisitDetailsFrame.actionPerformed(null);

        // Check to see if the submitted text for new Prescription is empty.
        assertEquals("", editVisitDetailsFrame.getnewPrescriptionTextField().getText());
    }

    @Test 
    public void testCorrectInput()
    {
        // Set correct input values 
        int bookingID = 1;
        String visitDetails = "aaaaaa";
        String newPrescription = "bbbbbb";

        // Place the correct input values inside the text fields.
        editVisitDetailsFrame.getBookingIDTextField().setText(String.valueOf(bookingID)); // Corect BookingID -- Integer 
        editVisitDetailsFrame.getVisitDetailsTextField().setText(visitDetails); // Correct String input for visit details
        editVisitDetailsFrame.getnewPrescriptionTextField().setText(newPrescription); // Correct String input for prescription

        // Simulate pefroming the submit button. 
        editVisitDetailsFrame.actionPerformed(null);

        // Check if the visit details and new prescription fields are updated correctly
        assertEquals(visitDetails, editVisitDetailsFrame.getVisitDetailsTextField().getText());
        assertEquals(newPrescription, editVisitDetailsFrame.getnewPrescriptionTextField().getText());
    }
}
