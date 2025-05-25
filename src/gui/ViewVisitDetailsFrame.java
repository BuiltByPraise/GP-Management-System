package uk.ac.kent.main.gui;

import uk.ac.kent.main.db.DBManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewVisitDetailsFrame implements ActionListener {
    
    private final JFrame ViewVisitDetailsFrame;
    private final JTextField bookingIDTextField;
    private final JTextArea detailsTextArea;
    private final JFrame menuFrame; 
    
    public ViewVisitDetailsFrame()
    {
        ViewVisitDetailsFrame = new JFrame();
        ViewVisitDetailsFrame.setTitle("View Visit Details");
        ViewVisitDetailsFrame.setLayout(null);
        ViewVisitDetailsFrame.setSize(700, 300);
        ViewVisitDetailsFrame.setResizable(false);

        // BookingID 
        JLabel bookingIDLabel = new JLabel("Enter BookingID");
        bookingIDLabel.setBounds(20, 70, 100, 25);
        ViewVisitDetailsFrame.add(bookingIDLabel);

        bookingIDTextField = new JTextField(20);
        bookingIDTextField.setBounds(130, 70, 165, 25);
        ViewVisitDetailsFrame.add(bookingIDTextField);

        // JTextArea to display details
        detailsTextArea = new JTextArea(); 
        detailsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(detailsTextArea);
        scrollPane.setBounds(20, 150, 500, 50);
        ViewVisitDetailsFrame.add(scrollPane);

        // Submit Button 
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(20, 110, 80, 25);
        submitButton.addActionListener(this);
        ViewVisitDetailsFrame.add(submitButton);

        JButton backButton = new JButton("Main Menu");
        backButton.setBounds(120, 110, 100, 25); // Adjust position and size as needed
        ViewVisitDetailsFrame.add(backButton); // Make sure to add the button to the frame

        ViewVisitDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        menuFrame = new JFrame();

        backButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Dispose the current frame
            ViewVisitDetailsFrame.dispose();
            
            // Create and display the main menu frame
            new MenuFrame();
        }
    });
        ViewVisitDetailsFrame.setVisible(true);   
    }
     // Getter method for bookingID
    public JTextField getBookingIDTextField() {
        return bookingIDTextField;
    }
    // Getter method for menuFrame
    public JFrame getMenuFrame() {
        return menuFrame;
    }

    // Getter method for viewVisitDetails frame
    public JFrame getViewVisitDetailsFrame()
    {
        return ViewVisitDetailsFrame;
    }

    // Getter method for details text area
    public JTextArea getDetailsTextArea()
    {
        return detailsTextArea;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {

        String bookingIDString = bookingIDTextField.getText();
        if (bookingIDString.isEmpty()) {
            JOptionPane.showMessageDialog(ViewVisitDetailsFrame, "BookingID cannot be empty. Please provide a bookingID", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if visit details is empty
        }

         // Validate booking ID
         if (!bookingIDString.matches("\\d+")) {
            JOptionPane.showMessageDialog(ViewVisitDetailsFrame, "Invalid booking ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit the method if the booking ID is invalid
        }
        int bookingID = Integer.parseInt(bookingIDString);

        DBManager dbManager = new DBManager();
        ResultSet resultSet = dbManager.ViewVisitDetails(bookingID);
       // Display details if ResultSet is not null
    if (resultSet != null) {
        try {
            if (resultSet.next()) {
                // Retrieve details and prescription from the ResultSet
                String details = resultSet.getString("details");
                String prescription = resultSet.getString("prescriptions");
                
                // Concatenate details and prescription
                String fullDetails = "Details: " + details + "\nPrescriptions: " + prescription;
                
                // Display the concatenated details in the JTextArea
                detailsTextArea.setText(fullDetails);
            } else {
                JOptionPane.showMessageDialog(ViewVisitDetailsFrame, "No details found for the given booking ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    } else {
        JOptionPane.showMessageDialog(ViewVisitDetailsFrame, "Failed to retrieve details from the database.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
}
