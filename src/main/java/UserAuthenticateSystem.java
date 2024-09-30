import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */ 

public class UserAuthenticateSystem {

    // List to store registered users
    private static List<UserInfo> users = new ArrayList<>();
    
    // Method to Register a new user
    private static void registerUser(Scanner scanner) {
        System.out.println("Welcome to the User Registration System");

        // Username input and validation
        System.out.print("Please enter a suitable Username: ");
        String username = scanner.nextLine();
        if (!UserInfo.isValidUsername(username)) {
            System.out.println("Username is not correctly formatted. Ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        } else {
            System.out.println("Username successfully captured.");
        }

        // Password input and validation
        System.out.print("Now, please enter your Password: ");
        String password = scanner.nextLine();
        if (!UserInfo.isValidPassword(password)) {
            System.out.println("Password is not correctly formatted. Ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            return;
        } else {
            System.out.println("Password successfully captured.");
        }

        // First name and last name input
        System.out.print("Enter your First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your Last Name: ");
        String lastName = scanner.nextLine();

        // Creating user object with the captured information
        UserInfo newUser = new UserInfo(username, password, firstName, lastName);
        users.add(newUser);  // Store the user in the list
        System.out.println("Registration complete!! Welcome, " + newUser.getFirstName() + " " + newUser.getLastName() + ". Your account has been successfully created.");
    }

        // Method for logging in an existing user
    private static void loginUser(Scanner scanner) {
        System.out.println("Welcome to the User Login System");

        // Username input
        System.out.print("Please enter your Username: ");
        String username = scanner.nextLine();

        // Password input
        System.out.print("Please enter your Password: ");
        String password = scanner.nextLine();

        // Validate user credentials
        for (UserInfo user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Welcome " + user.getFirstName() + ", " + user.getLastName() + ", it is great to see you again.");
                return; // User logged in successfully
            }
        }
        System.out.println("Username or password incorrect, please try again.");
    }
    
    
    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu for registration && login
        while (true) {
            System.out.println("=== User Authentication System ===");
            System.out.println("1. Register a New Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit the System");
            System.out.print("Please select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // To consume the newline character

            switch (choice) {
                case 1:
                    registerUser(scanner);  // Calls the registerUser method
                    break;
                case 2:
                    loginUser(scanner);      // Calls the loginUser method
                    break;
                case 3:
                    System.out.println("Thank you for using our system. Goodbye!");
                    scanner.close();
                    return;  // Exiting the system
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

