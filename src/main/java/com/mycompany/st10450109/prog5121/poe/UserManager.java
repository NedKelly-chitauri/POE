package com.mycompany.st10450109.prog5121.poe;
import javax.swing.JOptionPane;
import java.util.HashMap;


/**
 *
 * @author RC_Student_lab
 */
public class UserManager {
    
    private HashMap<String, String> users = new HashMap<>();

    public void registerUser(String username, String password) {
        users.put(username, password);
        JOptionPane.showMessageDialog(null, "User registered successfully!");
    }

    public boolean loginUser(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban!");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Invalid login. Try again.");
        return false;
    }
}
