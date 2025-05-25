package uk.ac.kent.main.gui;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.awt.event.ActionEvent;


public class menuFrameTest {

    private LoginFrame loginFrame;
    private MenuFrame menuFrame;

    @Before
    public void setUp() {
        loginFrame = new LoginFrame();
        loginFrame.getUserTextField().setText("FreddieFrancis");
        loginFrame.getPasswordField().setText("password");
        loginFrame.actionPerformed(null);
    }

    @Test
    public void testLogoutButton() {
        // Create MenuFrame instance after login
        menuFrame = new MenuFrame();

        // Simulate clicking the Logout button
        ActionEvent logoutEvent = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Logout");
        menuFrame.actionPerformed(logoutEvent);

        // Verify that the LoginFrame is displayed after logging out
        assertNotNull(loginFrame);
        assertEquals("Login", loginFrame.getLoginFrame().getTitle());
    }
}
