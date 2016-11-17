package dao;

import model.ListTasks;
import model.Message;
import model.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/16/16.
 */
public class TaskDAO {

    private String dbUrl = "jdbc:mysql://localhost:3306/task_manager_db";
    private String user = "root";
    private String pass = "root";
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public TaskDAO() throws SQLException, ClassNotFoundException {
        connection = new DBConnectionManager(dbUrl, user, pass).getConnection();
        statement = connection.createStatement();
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> taskList = new ArrayList<>();
        rs = statement.executeQuery("SELECT * FROM task_manager_db.task_table");
        while (rs.next()) {
            Task task = new Task(rs.getString("id"), rs.getString("title"),
                    rs.getString("details"), rs.getBoolean("isActive"));
            taskList.add(task);
        }
        connection.close();
        return taskList;
    }

    public List<Task> getTasksFromList(String listId) throws SQLException {
        List<Task> tasks = new ArrayList<>();
        rs = statement.executeQuery("SELECT * FROM task_manager_db.task_table WHERE listId=" + listId);
        while (rs.next()){
            Task task = new Task(rs.getString("id"), rs.getString("title"),
                    rs.getString("details"), rs.getBoolean("isActive"));
            tasks.add(task);
        }
        connection.close();
        return tasks;
    }


    public void addNewTask(String title, String details) throws SQLException {
        statement.execute("INSERT INTO task_manager_db.task_table (title, details) VALUES ('" +
                title + "','" + details + "');");
        connection.close();
    }

    public void deleteTask(String id) throws SQLException {
        statement.execute("DELETE FROM task_manager_db.task_table WHERE id =" + id);
        connection.close();
    }

    public void switchStatusTask(String taskId, boolean isActive) throws SQLException {
        statement.execute("UPDATE task_manager_db.task_table SET isActive =" + isActive + " WHERE id =" + taskId);
        connection.close();
    }

    public Task getTaskById(String taskId) throws SQLException {
        rs = statement.executeQuery("SELECT * FROM task_manager_db.task_table WHERE id =" + taskId);
        rs.next();
        Task task = new Task(rs.getString("id"), rs.getString("title"),
                rs.getString("details"), rs.getBoolean("isActive"));
        task.setMessages(getTaskMessages(taskId));
        connection.close();
        return task;
    }

    private List<Message> getTaskMessages(String taskId) throws SQLException {
        ResultSet resultSet;
        List<Message> messages = new ArrayList<>();
        resultSet = statement.executeQuery("SELECT * FROM task_manager_db.messages WHERE taskId =" + taskId);
        while (resultSet.next()) {
            messages.add(new Message(resultSet.getInt("id"), resultSet.getInt("taskId"),
                    resultSet.getString("message_body")));
        }
        resultSet.close();
        return messages;
    }

    public void addNewMessage(String taskId, String message) throws SQLException {
        statement.execute("INSERT INTO task_manager_db.messages (taskId, message_body) VALUES " +
                "('" + taskId + "','" + message + "')");
        connection.close();
    }

    public void deleteMessage(String messageId) throws SQLException {
        statement.execute("DELETE FROM task_manager_db.messages WHERE id =" + messageId);
        connection.close();
    }

    public void getAllListTasks() throws SQLException {
        List<ListTasks> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM task_manager_db.list_tasks");
        while (resultSet.next()){
            ListTasks tasks = new ListTasks(resultSet.getInt("id"), resultSet.getString("name"));
            list.add(tasks);
        }
    }

}
