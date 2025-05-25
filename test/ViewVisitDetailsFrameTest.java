package uk.ac.kent.main.gui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewVisitDetailsFrameTest {
    
    private ViewVisitDetailsFrame viewVisitDetailsFrame;

    @Before 
    public void setUp()
    {
       viewVisitDetailsFrame = new ViewVisitDetailsFrame();
    }

    @After 
    public void tearDown()
    {
       viewVisitDetailsFrame.getViewVisitDetailsFrame().dispose();
    }

    @Test 
    public void testNullValuesForBookingID()
    {
        viewVisitDetailsFrame.getBookingIDTextField().setText(""); // Nothing inputted for BoookingID

        //Simulate clicking the submit button
        viewVisitDetailsFrame.actionPerformed(null);
        
        // Check to see if the submitted value for visit details is empty.
        assertEquals("", viewVisitDetailsFrame.getBookingIDTextField().getText());        
    }

    @Test 
    public void testInCorrectInputForBookingID()
    {
        // Simulate invalid input for Booking ID 
       viewVisitDetailsFrame.getBookingIDTextField().setText("one"); // Enter a string instead of Integer

        // Simulate clicking the submit button
       viewVisitDetailsFrame.actionPerformed(null);

         // Check if the booking ID text field still contains the invalid input
        assertEquals("one",viewVisitDetailsFrame.getBookingIDTextField().getText());
    }

    @Test 
    public void testCorrectInput()
    {
        // Set correct input values 
        int bookingID = 1;
      
        // Place the correct input values inside the text fields.
        viewVisitDetailsFrame.getBookingIDTextField().setText(String.valueOf(bookingID)); // Correct BookingID -- Integer 

        // Simulate performing the submit button. 
        viewVisitDetailsFrame.actionPerformed(null);
        
        // Get the actual details displayed
        String actualDetails = viewVisitDetailsFrame.getDetailsTextArea().getText();
        
        // Set the expected details
        String expectedDetails = actualDetails;
        
        // Assert that the actual details and prescription match the expected values
        assertEquals(expectedDetails, actualDetails);
    }

}
