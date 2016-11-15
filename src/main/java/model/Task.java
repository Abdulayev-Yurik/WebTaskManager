package model;

/**
 * Created by employee on 11/15/16.
 */
public class Task {

    private String taskTitle;

    public Task(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }
}
