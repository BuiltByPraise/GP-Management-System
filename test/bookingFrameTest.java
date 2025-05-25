package uk.ac.kent.main.gui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.Test;

public class bookingFrameTest implements ActionListener {
    private BookingFrame bookingFrame;

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is required by the ActionListener interface
    }

    @Test
    public void testValidBookingSearch() {
        // Create a new BookingFrame instance
        bookingFrame = new BookingFrame();

        // Set the month and year to a value in the test data
        bookingFrame.getMonthField().setText("March");
        bookingFrame.getYearField().setText("2024");

        // Trigger the action to simulate the user clicking the "Submit" button
        // Ensure the action command is set correctly as the actionPerformed method is checking it
        bookingFrame.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Submit"));

        // Check if the booking table is populated with the expected number of bookings
        // Assume there are 2 bookings for the test to pass, as per the provided screenshot
        assertNotNull("The table model should not be null", bookingFrame.getTableModel());
        assertEquals("The table should have 2 bookings for March 2024", 2, bookingFrame.getTableModel().getRowCount());
    }


    @Test
    public void testInvalidMonth() {
        // Create new BookingFrame instance
        bookingFrame = new BookingFrame();

        // Simulate invalid month
        bookingFrame.getMonthField().setText("InvalidMonth"); // Anything that's not a proper month 
        bookingFrame.getYearField().setText("2023"); // Correct year 
        bookingFrame.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertNotNull(bookingFrame.getTableModel()); //
        assertEquals(0, bookingFrame.getTableModel().getRowCount()); // Expecting no bookings due to invalid month
    }

    @Test
    public void testInvalidYear() {
        // Create new BookingFrame instance
        bookingFrame = new BookingFrame();

        // Simulate invalid year
        bookingFrame.getMonthField().setText("January");
        bookingFrame.getYearField().setText("InvalidYear");
        bookingFrame.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        assertNotNull(bookingFrame.getTableModel()); 
        assertEquals(0, bookingFrame.getTableModel().getRowCount()); // Expecting no bookings due to invalid year
    }
}
