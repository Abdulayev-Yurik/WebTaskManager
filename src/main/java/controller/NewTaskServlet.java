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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

/**
 * Created by yurik on 14.11.16.
 */
@WebServlet({"/newTask"})
public class NewTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        try {
            if (title == null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/add_task.jsp");
                req.setAttribute("lists", new ListDAO().getAllListTasks());
                dispatcher.forward(req, resp);
            }else {
                TaskDAO dao = new TaskDAO();
                dao.addNewTask(title, req.getParameter("details"),
                        parseInt(req.getParameter("listId")), req.getParameter("dueDate"));
                resp.sendRedirect("/home");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
