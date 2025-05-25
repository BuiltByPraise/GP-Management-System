package uk.ac.kent.main.gui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class EnterVisitDetailsAndPrescriptionsFrame implements ActionListener {
    private JFrame menuFrame;
    private JDialog visitDetailsDialog; // Added attribute for the visit details dialog
    private JTextField visitDetailsField;
    private JTextField prescriptionsField;
    private final JButton mainMenuButton;

    public EnterVisitDetailsAndPrescriptionsFrame() {
        menuFrame = new JFrame("Enter Visit Details And Prescriptions");
        menuFrame.setSize(300, 400);
        menuFrame.setLayout(null);

        mainMenuButton = new JButton("Main Menu");
        mainMenuButton.setBounds(20, 300, 150, 25);
        mainMenuButton.addActionListener(this);
        menuFrame.add(mainMenuButton);

        // Button initialization and adding goes here...
        JButton enterVisitDetailsButton = new JButton("Enter Visit Details");
        enterVisitDetailsButton.setBounds(20, 270, 150, 25);
        enterVisitDetailsButton.addActionListener(this);
        menuFrame.add(enterVisitDetailsButton);

        menuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose only this frame
        menuFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Enter Visit Details")) {
            enterVisitDetails();
        } else if (e.getSource() == mainMenuButton) {
            // Dispose the current frame and open the main menu
            menuFrame.dispose();
            new MenuFrame(); // Make sure to have the MenuFrame class in your project
        }
    }

    private void enterVisitDetails() {
        // Create a dialog for entering visit details and prescriptions
        visitDetailsDialog = new JDialog(menuFrame, "Enter Visit Details", true);
        visitDetailsDialog.setSize(400, 200);
        visitDetailsDialog.setLayout(new GridLayout(3, 2));

        JLabel visitDetailsLabel = new JLabel("Visit Details:");
        visitDetailsField = new JTextField();
        JLabel prescriptionsLabel = new JLabel("Prescriptions:");
        prescriptionsField = new JTextField();
        JButton confirmButton = new JButton("Confirm");

        visitDetailsDialog.add(visitDetailsLabel);
        visitDetailsDialog.add(visitDetailsField);
        visitDetailsDialog.add(prescriptionsLabel);
        visitDetailsDialog.add(prescriptionsField);
        visitDetailsDialog.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // After confirmation, send confirmation messages
                sendConfirmationToPatient(visitDetailsField.getText(), prescriptionsField.getText());
                sendConfirmationToDoctor(visitDetailsField.getText(), prescriptionsField.getText());
                visitDetailsDialog.dispose();
            }
        });

        visitDetailsDialog.setVisible(true);
    }

    private void sendConfirmationToPatient(String visitDetails, String prescriptions) {
        // Implement logic to send confirmation message to the patient
        // Example: Sending an email or SMS confirmation to the patient
        System.out.println("Confirmation message sent to patient.");
        System.out.println("Visit Details: " + visitDetails);
        System.out.println("Prescriptions: " + prescriptions);
    }

    private void sendConfirmationToDoctor(String visitDetails, String prescriptions) {
        // Implement logic to send confirmation message to the doctor
        // Example: Sending an email or SMS confirmation to the doctor
        System.out.println("Confirmation message sent to doctor.");
        System.out.println("Visit Details: " + visitDetails);
        System.out.println("Prescriptions: " + prescriptions);
    }

    // Getter method for menuFrame
    public JFrame getMenuFrame() {
        return menuFrame;
    }

    // Getter method for visitDetailsDialog
    public JDialog getVisitDetailsDialog() {
        return visitDetailsDialog;
    }
}
