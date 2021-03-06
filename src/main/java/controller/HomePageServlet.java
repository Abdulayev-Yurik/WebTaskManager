package controller;

import dao.ListDAO;
import dao.TaskDAO;
import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/home"})
public class HomePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String listId = req.getParameter("listId");
        try {
            TaskDAO taskDAO = new TaskDAO((Connection) getServletContext()
                    .getAttribute("connection"));
            ListDAO listDAO = new ListDAO((Connection) getServletContext()
                    .getAttribute("connection"));
            List<Task> taskActiveList = new ArrayList<>();
            List<Task> taskDoneList = new ArrayList<>();

            List<Task> tasks = listId == null ? taskDAO.getAllTasks() : taskDAO.getTasksFromList(listId);
            for (Task task : tasks) {
                if (task.isActive()) {
                    taskActiveList.add(task);
                } else {
                    taskDoneList.add(task);
                }
            }

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/home.jsp");
            req.setAttribute("taskActiveList", taskActiveList);
            req.setAttribute("taskDoneList", taskDoneList);
            req.setAttribute("listTasks", listDAO.getAllListTasks());
            dispatcher.forward(req, resp);
        } catch (SQLException | ClassNotFoundException | NullPointerException e) {
            e.printStackTrace();
            resp.sendRedirect("/home");
        }
    }
}
