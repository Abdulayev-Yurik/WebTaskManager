package controller;

import dao.TaskDAO;
import model.Task;
import org.apache.catalina.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/delMessages"})
public class DeleteMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String messageId = req.getParameter("messageId");
        String taskId = req.getParameter("taskId");
        try {
            TaskDAO taskDAO = new TaskDAO((Connection) getServletContext().getAttribute("connection"));
            taskDAO.deleteMessage(messageId);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/details?task=" + taskId);


    }
}
