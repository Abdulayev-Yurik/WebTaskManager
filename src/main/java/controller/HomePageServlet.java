package controller;

import model.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 11/15/16.
 */
@WebServlet({"/home"})
public class HomePageServlet extends HttpServlet {

    private String counterKey = "counter";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(true);
        List<Task> taskActiveList = new ArrayList<>();
        List<Task> taskDoneList = new ArrayList<>();

        if (session.isNew())
            System.out.println("Home servlet session not exist");
        else {
            try {
                int listLength = (Integer) session.getAttribute(counterKey);
                System.out.println("Home servlet session exist, listLength = " + listLength);
                for (int i = 1; i <= listLength; i++) {
                    try {
                        Task task = (Task) session.getAttribute(i + "");
                        if (!task.getTaskTitle().isEmpty()) {
                            if (task.getActive()) {
                                taskActiveList.add(task);
                            } else {
                                taskDoneList.add(task);
                            }
                            System.out.println(task.getTaskTitle());
                        }
                    } catch (NullPointerException e) {

                    }
                }
            }catch (NullPointerException e){

            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        req.setAttribute("taskActiveList", taskActiveList);
        req.setAttribute("taskDoneList", taskDoneList);
        dispatcher.forward(req, resp);
    }
}
