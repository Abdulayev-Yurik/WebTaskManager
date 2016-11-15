package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
public class Task {

    private String taskId;
    private String taskTitle;
    private String details;
    private boolean isActive;
    private List<String> messages = new ArrayList<>();

    public Task(String taskId, String taskTitle) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        isActive = true;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return messages;
    }

    public Integer getMessagesValues(){
        return messages.size();
    }

    public String getTaskId() {
        return taskId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
