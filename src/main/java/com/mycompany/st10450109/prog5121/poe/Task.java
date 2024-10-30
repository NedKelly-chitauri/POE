package com.mycompany.st10450109.prog5121.poe;


/**
 *
 * @author RC_Student_lab
 */

public class Task {
    private String taskName;
    private String taskDescription;
    private String developerName;
    private int taskDuration;

    // Constructor to initialize a task
    public Task(String taskName, String taskDescription, String developerName, int taskDuration) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerName = developerName;
        this.taskDuration = taskDuration;
    }

    // Method to validate the task description length
    public boolean isDescriptionValid() {
        return taskDescription.length() <= 50;
    }

    // Method to return a formatted task summary
    public String getTaskSummary() {
        return "Task Name: " + taskName + "\n" +
               "Description: " + taskDescription + "\n" +
               "Developer: " + developerName + "\n" +
               "Duration: " + taskDuration + " hours";
    }

    // Getters for the task attributes (optional, for further expansion if needed)
    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public int getTaskDuration() {
        return taskDuration;
    }
}