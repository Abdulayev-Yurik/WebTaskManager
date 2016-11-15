package controller;

import model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/taskState"})
public class TaskStateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("task");

        HttpSession session = req.getSession(true);

        if (session.isNew()){
            resp.sendRedirect("/home");
        }else {
            Task task = (Task) session.getAttribute(taskId);
            task.setActive(!task.isActive());
            resp.sendRedirect("/home");
        }

    }
}
