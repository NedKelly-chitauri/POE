/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    private String taskStatus;

    // Method to set task details
    public void setTaskDetails(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.taskID = createTaskID();  // Generate task ID based on taskName and developerDetails
    }

    // Method to ensure task description is within 50 characters
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to create and return the Task ID
    public String createTaskID() {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.length() - 3).toUpperCase();
    }

    // Method to format and return task details
    public String printTaskDetails() {
        return "Task Status: " + taskStatus + "\nDeveloper: " + developerDetails + "\nTask Number: " + taskNumber
                + "\nTask Name: " + taskName + "\nTask Description: " + taskDescription + "\nTask ID: " + taskID + "\nDuration: " + taskDuration + " hours";
    }

    // Getter for task duration to calculate total hours
    public int getTaskDuration() {
        return taskDuration;
    }
}
