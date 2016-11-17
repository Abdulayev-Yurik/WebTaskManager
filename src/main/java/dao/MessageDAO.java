package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by employee on 11/17/16.
 */
public class MessageDAO {

    private Connection connection;
    private Statement statement;
    private ResultSet rs;

    public MessageDAO(Connection connection) throws SQLException, ClassNotFoundException {
        this.connection = connection;
        statement = connection.createStatement();
    }
}
