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
    private List<Message> messages = new ArrayList<>();


    public Task(String taskId, String taskTitle) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        isActive = true;
    }

    public Task(String taskId, String taskTitle, String details, boolean isActive) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
