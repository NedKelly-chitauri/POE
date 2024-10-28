/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
/**
 * This class stores basic user information like username, password, first name, and last name.
 */
public class UserInfo {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Constructor to initialize the user's information
    public UserInfo(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Method to check if username is valid
    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if password meets complexity standards
    public boolean checkPasswordComplexity() {
        return password.length() >= 8 && 
               password.matches(".*[A-Z].*") &&    // Check for at least one uppercase letter
               password.matches(".*[0-9].*") &&    // Check for at least one digit
               password.matches(".*[!@#$%^&*].*");  // Check for at least one special character
    }

    // Method to register a new user and return appropriate message
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        } else if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.";
        } else {
            return "User successfully registered!";
        }
    }

    // Method to validate login
    public boolean loginUser(String loginUsername, String loginPassword) {
        return this.username.equals(loginUsername) && this.password.equals(loginPassword);
    }

    // Getters for firstName and lastName to display after login
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
