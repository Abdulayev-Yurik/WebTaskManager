package utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by employee on 11/17/16.
 */
@WebListener
public class CustomServletContextListener implements javax.servlet.ServletContextListener {

    private final String URL = "jdbc:mysql://localhost:3306/task_manager_db";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Innit context");
        ServletContext sc = servletContextEvent.getServletContext();
        try {
            Class.forName(DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            sc.setAttribute("connection", connection);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
