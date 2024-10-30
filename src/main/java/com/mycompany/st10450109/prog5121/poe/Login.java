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



/**
 * This class handles user registration and login functionalities.
 * It ensures that usernames and passwords meet specific formatting criteria.
 */
public class Login {
    private UserInfo user;

    // Constructor that accepts a UserInfo object
    public Login(UserInfo user) {
        this.user = user;
    }

    // Method to check if the username is valid
    public boolean checkUserName() {
        String username = user.getUsername();
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity() {
        String password = user.getPassword();
        if (password.length() < 8) return false;

        Pattern upperCasePattern = Pattern.compile("[A-Z]");
        Pattern digitPattern = Pattern.compile("[0-9]");
        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");

        Matcher hasUpperCase = upperCasePattern.matcher(password);
        Matcher hasDigit = digitPattern.matcher(password);
        Matcher hasSpecialChar = specialCharPattern.matcher(password);

        return hasUpperCase.find() && hasDigit.find() && hasSpecialChar.find();
    }

    // Method to register the user, providing appropriate feedback
    public String registerUser() {
        if (!checkUserName()) {
            return "Error: Username is not correctly formatted. Ensure it contains an underscore and is no more than 5 characters.";
        }
        if (!checkPasswordComplexity()) {
            return "Error: Password must contain at least 8 characters, a capital letter, a number, and a special character.";
        }
        return "User successfully registered!";
    }

    // Method to login the user
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword);
    }

    // Method to return a login status message based on successful or failed login
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome back " + user.getFirstName() + " " + user.getLastName() + "! It’s great to see you again.";
        } else {
            return "Username or password incorrect. Please try again!";
        }
    }
}