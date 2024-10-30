package com.mycompany.st10450109.prog5121.poe;
import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class EasyKanbanApp {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        TaskManager taskManager = new TaskManager();
        boolean isLoggedIn = false;

        // Registration and Login
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        userManager.registerUser(username, password);
        isLoggedIn = userManager.loginUser(username, password);

        // Task Menu
        if (isLoggedIn) {
            while (true) {
                String menu = JOptionPane.showInputDialog("Select an option:\n1. Add Task\n2. Show Report\n3. Quit");
                switch (menu) {
                    case "1":
                        int taskCount = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                        for (int i = 0; i < taskCount; i++) {
                            String taskName = JOptionPane.showInputDialog("Enter task name:");
                            String description = JOptionPane.showInputDialog("Enter task description:");
                            String developer = JOptionPane.showInputDialog("Enter developer name:");
                            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
                            String status = JOptionPane.showInputDialog("Enter task status (To Do, Doing, Done):");
                            taskManager.addTask(i, taskName, description, developer, duration, status);
                        }
                        taskManager.displayTotalHours();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        return;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
}
