package controller;

import dao.TaskDAO;
import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/taskState"})
public class TaskStateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String taskId = req.getParameter("task");
            TaskDAO taskDAO = new TaskDAO();
            taskDAO.switchStatusTask(taskId, !Boolean.parseBoolean(req.getParameter("active")));
            resp.sendRedirect("/home");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
