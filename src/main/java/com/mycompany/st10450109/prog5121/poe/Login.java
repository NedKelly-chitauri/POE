package com.mycompany.st10450109.prog5121.poe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */

public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Check if the username contains an underscore and is no more than 5 characters
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Check password complexity
    public boolean checkPasswordComplexity(String password) {
        if (password.length() < 8) return false;

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");

        Matcher hasUpperCase = upperCasePattern.matcher(password);
        Matcher hasDigit = digitPattern.matcher(password);
        Matcher hasSpecialChar = specialCharPattern.matcher(password);

        return hasUpperCase.find() && hasDigit.find() && hasSpecialChar.find();
    }

    // Register a user, returns registration status message
    public String registerUser(String username, String password, String firstName, String lastName) {
        if (!checkUserName(username)) {
            return "Error: Username is not correctly formatted. Ensure it contains an underscore and is no more than 5 characters.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Error: Password is not correctly formatted. Ensure it contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        
        return "User successfully registered!";
    }

    // Login the user by verifying username and password
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    // Return login status message based on successful or failed login
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome back " + firstName + " " + lastName + "! It’s great to see you again.";
        } else {
            return "Username or password incorrect. Please try again!";
        }
    }
}
