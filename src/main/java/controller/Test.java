package controller;

import model.Task;
import org.hibernate.Session;
import utils.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by employee on 11/17/16.
 */
@WebServlet({"/test"})
public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from Task where listId = :code ");
//        query.setParameter("code", "1");
        Collection list = session.createCriteria(Task.class).list();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Task task = (Task) iterator.next();
            System.out.println(task.getTaskTitle());
        }
//        Task task = new Task("TestTitle", "auysghfui" );
//        session.save(task);
        session.close();
    }
}
