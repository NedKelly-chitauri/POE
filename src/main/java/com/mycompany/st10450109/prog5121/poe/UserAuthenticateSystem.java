package com.mycompany.st10450109.prog5121.poe;

import javax.swing.*;
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

/**
 * Main class to run the user authentication system.
 * Manages user registration and login functionalities.
 */
public class UserAuthenticateSystem {
    private static List<UserInfo> userList = new ArrayList<>();
    private static List<Task> taskList = new ArrayList<>();  // List to store tasks

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
            scanner.nextLine();  // Consume newline

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
                    Login newLogin = new Login(newUser);
                    String registrationMessage = newLogin.registerUser();
                    System.out.println(registrationMessage);

                    if (registrationMessage.equals("User successfully registered!")) {
                        userList.add(newUser);
                    }
                    break;

                case 2:
                    // Login process
                    System.out.print("Enter your username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    boolean isLoggedIn = false;

                    for (UserInfo user : userList) {
                        Login login = new Login(user);
                        isLoggedIn = login.loginUser(loginUsername, loginPassword);
                        System.out.println(login.returnLoginStatus(isLoggedIn));

                        if (isLoggedIn) {
                            // Open task menu in JOptionPane after successful login
                            manageTasks(user);
                            break;
                        }
                    }

                    if (!isLoggedIn) {
                        System.out.println("Username or password incorrect. Please try again.");
                    }
                    break;

                case 3:
                    isRunning = false;
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }

    // Method to manage tasks using JOptionPane
    private static void manageTasks(UserInfo user) {
        boolean isManagingTasks = true;

        while (isManagingTasks) {
            String menu = "Welcome to EasyKanban\n\nSelect an option:\n1) Add Task\n2) Show Report\n3) Quit";
            String input = JOptionPane.showInputDialog(menu);

            if (input == null) {
                isManagingTasks = false;  // Handle cancel button
                break;
            }

            int taskChoice = Integer.parseInt(input);

            switch (taskChoice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    showReport();
                    break;
                case 3:
                    isManagingTasks = false;
                    JOptionPane.showMessageDialog(null, "Exiting EasyKanban.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    // Method to prompt user for task details and add a task
    private static void addTask () {
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");

        String developerName = JOptionPane.showInputDialog("Enter Developer's Full Name:");
        String taskDurationStr = JOptionPane.showInputDialog("Enter Task Duration in hours:");
        int taskDuration = Integer.parseInt(taskDurationStr);

        Task newTask = new Task(taskName, taskDescription, developerName, taskDuration);

        if (newTask.isDescriptionValid()) {
            taskList.add(newTask);
            JOptionPane.showMessageDialog(null, "Task successfully captured.\n" + newTask.getTaskSummary());
        } else {
            JOptionPane.showMessageDialog(null, "Task description is too long. Please enter a description of 50 characters or less.");
        }
    }

    // Method to show a report of all tasks
    private static void showReport() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
        } else {
            StringBuilder report = new StringBuilder("Task Report:\n\n");
            for (Task task : taskList) {
                report.append(task.getTaskSummary()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, report.toString());
        }
    }
}