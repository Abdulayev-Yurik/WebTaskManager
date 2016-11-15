package controller;

import model.Task;
import org.apache.catalina.Session;

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
@WebServlet({"/delMessages"})
public class DeleteMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskId = req.getParameter("taskId");
        String message = req.getParameter("message");

        HttpSession session = req.getSession(true);
        if (session.isNew()){
            resp.sendRedirect("/home");
        }else {
            Task task = (Task) session.getAttribute(taskId);
            task.getMessages().remove(message);
            resp.sendRedirect("/details?task=" + taskId);
        }
    }
}
