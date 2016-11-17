package dao;

import model.ListTasks;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/17/16.
 */
public class ListDAO {

    private String dbUrl = "jdbc:mysql://localhost:3306/task_manager_db";
    private String user = "root";
    private String pass = "root";
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public ListDAO() throws SQLException, ClassNotFoundException {
        connection = new DBConnectionManager(dbUrl, user, pass).getConnection();
        statement = connection.createStatement();
    }

    public List<ListTasks> getAllListTasks() throws SQLException {
        List<ListTasks> list = new ArrayList<>();
        rs = statement.executeQuery("SELECT * FROM task_manager_db.list_tasks");
        while (rs.next()){
            ListTasks tasks = new ListTasks(rs.getInt("id"), rs.getString("name"));
            list.add(tasks);
        }
        connection.close();
        return list;
    }

    public void createNewList(String title) throws SQLException {
        statement.execute("INSERT INTO task_manager_db.list_tasks (name) VALUE ('"+ title +"');");
        connection.close();
    }
}
