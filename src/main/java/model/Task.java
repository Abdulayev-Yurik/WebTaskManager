package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@Entity
@Table(name = "task_table")
public class Task {

    @Column(name = "id")@Id
    private String taskId;
    private ListTasks listTasks;
    private String taskTitle;
    private String details;
    private String dueDate;
    private boolean isActive;
    private int listId;
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

    public Task(String taskId, String taskTitle, String details, boolean isActive, int listId) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
        this.listId = listId;
    }

    public Task(String taskTitle, String details, boolean isActive, int listId) {
        this.taskTitle = taskTitle;
        this.details = details;
        this.isActive = isActive;
        this.listId = listId;
    }

    public Task() {
    }

    @Column(name = "title")
    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public Integer getMessagesValues() {
        return messages.size();
    }

    @Column(name = "id")
    public String getTaskId() {
        return taskId;
    }

    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name = "isActive")
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

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "listId", nullable = false)
    public ListTasks getListTasks() {
        return listTasks;
    }

    public void setListTasks(ListTasks listTasks) {
        this.listTasks = listTasks;
    }
}
