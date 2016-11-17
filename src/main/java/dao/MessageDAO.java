package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by employee on 11/17/16.
 */
public class MessageDAO {

    private String dbUrl = "jdbc:mysql://localhost:3306/task_manager_db";
    private String user = "root";
    private String pass = "root";
    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public MessageDAO() throws SQLException, ClassNotFoundException {
        connection = new DBConnectionManager(dbUrl, user, pass).getConnection();
        statement = connection.createStatement();
    }
}
