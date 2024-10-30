package com.mycompany.st10450109.prog5121.poe;


/**
 *
 * @author RC_Student_lab
 */

public class Task {
    private int taskNumber;
    private String taskName;
    private String description;
    private String developer;
    private int duration;
    private String status;
    private String taskID;

    public Task(int taskNumber, String taskName, String description, String developer, int duration, String status, String taskID) {
        this.taskNumber = taskNumber;
        this.taskName = taskName;
        this.description = description;
        this.developer = developer;
        this.duration = duration;
        this.status = status;
        this.taskID = taskID;
    }

    public String printTaskDetails() {
        return "Status: " + status + "\nDeveloper: " + developer + "\nTask Number: " + taskNumber +
               "\nTask Name: " + taskName + "\nDescription: " + description + "\nTask ID: " + taskID +
               "\nDuration: " + duration + " hours";
    }
}
