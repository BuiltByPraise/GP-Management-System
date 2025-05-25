package uk.ac.kent.main.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    // Test function for the database which worked correctly.
    private void testConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users");
            while (resultSet.next())
                System.out.println(resultSet.getInt("UserID") + " - " + resultSet.getString("Username") + " - " + resultSet.getString("Password") + " - " + resultSet.getString("Role"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Used in the LoginFrame
    public boolean login(String userID, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from users where username = '" + userID + "' AND password = '" + password + "'");
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ResultSet viewOwnPatients(String doctorId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            String query = "SELECT * FROM patients WHERE fk_doctorID_patients = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(doctorId));
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }



    public ResultSet showPatients(String month, String year){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM bookings WHERE YEAR(bookingDate) =" + year + " AND MONTH(bookingDate) = " + month);
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Gets the patient name by their unique patientID
    public String getNameByPatiendId(String id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM patients WHERE patientID = " + id);
            if(resultSet.next()){
                return resultSet.getString("name"); // Assuming you have a column named 'name' now
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Return all patients (Used for The system should allow a doctor to view all patients (not only own patients) with their summary information, e.g. name, phone number.)
    public ResultSet getAllPatients(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM patients");
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updateVisitDetails(int bookingID, String visitDetails, String newPrescription)
    {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
    
            // Establish a connection to the database
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
    
            // Construct the update query with placeholders
            String query = "UPDATE bookings SET details = ?, prescriptions = ? WHERE bookingID = ?";
    
            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);
    
            // Set parameter values
            preparedStatement.setString(1, visitDetails);
            preparedStatement.setString(2, newPrescription);
            preparedStatement.setInt(3, bookingID);
    
            // Execute the update query
            int rowsUpdated = preparedStatement.executeUpdate();
    
            // Close the PreparedStatement and Connection
            preparedStatement.close();
            connection.close();
    
            // Return true if at least one row was updated, otherwise false
            return rowsUpdated > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet getAllDoctors(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM doctors");
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean updatePatientDoctor(String patientID, String doctorID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            String query = "UPDATE patients SET fk_doctorID_patients = ? WHERE patientID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, Integer.parseInt(doctorID));
            preparedStatement.setInt(2, Integer.parseInt(patientID));

            int updateRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return updateRows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Helper method used for login and UserLogger.
    public int getUserIDByUsername(String username){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + username + "'");
            if(resultSet.next()){
                return resultSet.getInt("userID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // If they do not exist for some reason, should never be hit though
    }

    public ResultSet ViewVisitDetails(int bookingID){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            statement = connection.createStatement();
            String query = "SELECT * FROM bookings WHERE bookingID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookingID); // Set the parameter value
        
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean logAction(int userID, String action){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://dragon.kent.ac.uk/ff247", "ff247", "rnf5inm");
            String query = "INSERT INTO access_logs (userID, action, timestamp) VALUES (?, ?, NOW())";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, userID);
            preparedStatement.setString(2, action);

            int insertRows = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            return insertRows > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
