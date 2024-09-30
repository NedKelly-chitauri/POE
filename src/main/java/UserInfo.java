/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class UserInfo {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor
    public UserInfo(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters for each field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Validation method for username (contains an underscore and is no more than 5 characters long)
    public static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Validation method for password (length, capital letter, number, special character)
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        // Check for at least one capital letter, one number, and one special character
        if (!password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()_+].*")) {
            return false;
        }
        return true;
    }
}

