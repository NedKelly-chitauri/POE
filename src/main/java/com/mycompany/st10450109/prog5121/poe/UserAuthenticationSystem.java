/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10450109.prog5121.poe;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class UserAuthenticationSystem {
    // Store registered users
    private static HashMap<String, String> users = new HashMap<>();
    
    // Method to validate password criteria
    private static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        // Check for digit and special character
        if (!password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*()_+].*")) {
            return false;
        }
        return true;
    }
    
    // Method to register a new user
    private static void registerUser(Scanner scanner) {
        System.out.println("Register New User");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        
        // Check if username already exists
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try another one.");
            return;
        }
        
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        // Validate password
        if (!isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters long and contain at least one digit and one special character.");
            return;
        }
        
        // Store the new user
        users.put(username, password);
        System.out.println("Registration successful!");
    }  ;
}
