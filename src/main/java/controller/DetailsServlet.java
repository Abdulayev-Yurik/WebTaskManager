package controller;

import dao.TaskDAO;
import model.Message;
import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/details"})
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("task");

        try {
            TaskDAO taskDAO = new TaskDAO((Connection) getServletContext().getAttribute("connection"));
            Task task = taskDAO.getTaskById(taskId);
            List<Message> messageList = task.getMessages();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/details.jsp");
            req.setAttribute("task", task);
            req.setAttribute("messages", messageList);
            dispatcher.forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            resp.sendRedirect("/home");
            e.printStackTrace();
        }
    }
}
