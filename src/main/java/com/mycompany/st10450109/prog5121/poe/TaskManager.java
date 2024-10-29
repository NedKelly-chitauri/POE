import javax.swing.JOptionPane;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.st10450109.prog5121.poe;

/**
 *
 * @author RC_Student_lab
 */


public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private int totalHours = 0;
    
    public void addTask(int taskNumber, String taskName, String description, String developer, int duration, String status) {
        if (description.length() > 50) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters.");
            return;
        }
        
        String taskID = createTaskID(taskName, taskNumber, developer);
        Task task = new Task(taskNumber, taskName, description, developer, duration, status, taskID);
        tasks.add(task);
        totalHours += duration;

        JOptionPane.showMessageDialog(null, "Task successfully captured.\n" + task.printTaskDetails());
    }

    private String createTaskID(String taskName, int taskNumber, String developer) {
        return taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" +
               developer.substring(developer.length() - 3).toUpperCase();
    }

    public void displayTotalHours() {
        JOptionPane.showMessageDialog(null, "Total Hours Across Tasks: " + totalHours);
    }
}
