package controller;

import model.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/test"})
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Task task = new Task("TestTitle", "auysghfui", true, 1);
        session.save(task);
        session.getTransaction().commit();
    }
}
