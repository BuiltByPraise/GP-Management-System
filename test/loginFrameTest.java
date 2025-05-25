package uk.ac.kent.main.gui;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class loginFrameTest {
    private LoginFrame loginFrame;
    @Test
    public void testValidLogin() {
        // Create a new login Frame
        loginFrame = new LoginFrame();

        // Simulate valid login
        loginFrame.getUserTextField().setText("FreddieFrancis");
        loginFrame.getPasswordField().setText("password");
        loginFrame.actionPerformed(null);

        // Check if the login is successful
        assertEquals("Login Successful!", loginFrame.getMessage());
    }

    @Test
    public void testInvalidUsername()
    {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid username
        loginFrame.getUserTextField().setText("invalid_user"); // Enter wrong username
        loginFrame.getPasswordField().setText("password"); // Enter correct password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testInvalidPassword()
    {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid password
        loginFrame.getUserTextField().setText("FreddieFrancis"); // Enter correct username
        loginFrame.getPasswordField().setText("invalid_password"); // Enter wrong password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testEmptyUsername()
    {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid username
        loginFrame.getUserTextField().setText(""); // Enter np username
        loginFrame.getPasswordField().setText("password"); // Enter correct password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testEmptyPassword()
    {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid password
        loginFrame.getUserTextField().setText("FreddieFrancis"); // Enter correct username
        loginFrame.getPasswordField().setText(""); // Enter no password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testUsernameWithSpecialChar()
    {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid username
        loginFrame.getUserTextField().setText("FreddieFrancis@"); // Add "@" at the end of doctor
        loginFrame.getPasswordField().setText("password"); // Enter correct password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testPasswordWithSpecialChar() {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid login
        loginFrame.getUserTextField().setText("FreddieFrancis"); // Enter correct username
        loginFrame.getPasswordField().setText("pa$$word"); // Replace the "s" in password with "$"
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }

    @Test
    public void testInvalidLogin() {
        // Create new loginFrame
        loginFrame = new LoginFrame();

        // Simulate invalid login
        loginFrame.getUserTextField().setText("invalid_user"); // Enter wrong username
        loginFrame.getPasswordField().setText("invalid_password"); // Enter incorrect password
        loginFrame.actionPerformed(null); // Simulate the action of clicking the login button

        // Check if the login message is correct
        assertEquals("Invalid Username/Password", loginFrame.getMessage());
    }
}
