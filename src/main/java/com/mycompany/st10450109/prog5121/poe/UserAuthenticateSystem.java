package com.mycompany.st10450109.prog5121.poe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */ 

public class UserAuthenticateSystem {
    private static List<Login> userList = new ArrayList<>();
    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("Welcome to EasyKanban!");

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

                    Login newUser = new Login();
                    String registrationMessage = newUser.registerUser(username, password, firstName, lastName);
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
                    for (Login user : userList) {
                        if (user.loginUser(loginUsername, loginPassword)) {
                            System.out.println(user.returnLoginStatus(true));
                            isLoggedIn = true;

                            // Start task management options after successful login
                            manageTasks(scanner);
                            break;
                        }
                    }

                    if (!isLoggedIn) {
                        System.out.println("Username or password incorrect, please try again.");
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

    // Method to manage tasks after user login
    private static void manageTasks(Scanner scanner) {
        boolean managingTasks = true;
        
        while (managingTasks) {
            System.out.println("\nPlease choose a task option:");
            System.out.println("1. Add tasks");
            System.out.println("2. Show report (Coming Soon)");
            System.out.println("3. Quit");

            System.out.print("Your choice: ");
            int taskChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (taskChoice) {
                case 1:
                    // Task addition process
                    System.out.print("How many tasks would you like to add? ");
                    int taskCount = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    for (int i = 0; i < taskCount; i++) {
                        System.out.print("Enter task name: ");
                        String taskName = scanner.nextLine();

                        System.out.print("Enter task description (max 50 characters): ");
                        String taskDescription = scanner.nextLine();

                        // Check task description length
                        Task task = new Task();
                        if (!task.checkTaskDescription()) {
                            System.out.println("Please enter a task description of less than 50 characters.");
                            continue; // Skip to next iteration if the description is too long
                        }

                        System.out.print("Enter developer's full name: ");
                        String developerDetails = scanner.nextLine();

                        System.out.print("Enter task duration (in hours): ");
                        int taskDuration = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        // Select task status
                        System.out.println("Select task status: 1. To Do  2. Doing  3. Done");
                        String taskStatus = "";
                        int statusChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                        switch (statusChoice) {
                            case 1:
                                taskStatus = "To Do";
                                break;
                            case 2:
                                taskStatus = "Doing";
                                break;
                            case 3:
                                taskStatus = "Done";
                                break;
                            default:
                                System.out.println("Invalid status selected.");
                                continue; // Skip this task addition
                        }

                        // Set task details and add to task list
                        task.setTaskDetails(taskName, i, taskDescription, developerDetails, taskDuration, taskStatus);
                        taskList.add(task);
                        JOptionPane.showMessageDialog(null, task.printTaskDetails(), "Task Added", JOptionPane.INFORMATION_MESSAGE);
                    }

                    // Calculate total hours for all tasks
                    int totalHours = taskList.stream().mapToInt(Task::getTaskDuration).sum();
                    System.out.println("Total estimated hours for all tasks: " + totalHours);
                    break;

                case 2:
                    // Show report (currently just a placeholder)
                    System.out.println("Coming Soon");
                    break;

                case 3:
                    managingTasks = false;
                    System.out.println("Exiting task management.");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
