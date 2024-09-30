import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */ 

/**
 * Main class to run the user authentication system.
 * Manages user registration and login functionalities.
 */
public class UserAuthenticateSystem {
    private static List<UserInfo> userList = new ArrayList<>();  // List to store registered users

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to the User Authentication System!");

        while (isRunning) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Register a new user");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    // Registration process
                    System.out.print("Enter a username: ");
                    String username = scanner.nextLine();

                    System.out.print("Enter a password: ");
                    String password = scanner.nextLine();

                    System.out.print("Enter your first name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();

                    UserInfo newUser = new UserInfo(username, password, firstName, lastName);
                    String registrationMessage = newUser.registerUser();

                    System.out.println(registrationMessage);

                    if (registrationMessage.equals("User successfully registered!")) {
                        userList.add(newUser);  // Add the registered user to the list
                    } else {
                        System.out.println("Registration failed. Please try again.");
                    }
                    break;

                case 2:
                    // Login process
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    boolean isLoggedIn = false;

                    // Loop through userList to find a matching username and password
                    for (UserInfo user : userList) {
                        if (user.loginUser(loginUsername, loginPassword)) {
                            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName() + ", it's great to see you again.");
                            isLoggedIn = true;
                            break;
                        }
                    }

                    if (!isLoggedIn) {
                        System.out.println("Username or password incorrect, please try again.");
                    }
                    break;

                case 3:
                    // Exit the system
                    isRunning = false;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}
