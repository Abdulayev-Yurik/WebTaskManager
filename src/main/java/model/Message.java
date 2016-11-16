package model;

/**
 * Created by employee on 11/16/16.
 */
public class Message {

    private int id;
    private int taskId;
    private String messageBody;

    public Message(int id, int taskId, String messageBody) {
        this.id = id;
        this.taskId = taskId;
        this.messageBody = messageBody;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
