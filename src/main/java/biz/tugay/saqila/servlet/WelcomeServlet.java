package biz.tugay.saqila.servlet;
/* User: koray@tugay.biz Date: 06/08/15 Time: 17:10 */

import biz.tugay.saqila.model.Actor;
import biz.tugay.saqila.model.ContactEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = "/start")
public class WelcomeServlet extends HttpServlet {

    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        super.init();
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        //Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setFirstName("Nick2142");
        contactEntity.setLastName("VN");

        session.save(contactEntity);
        session.getTransaction().commit();

        List<Actor> actors = session.createQuery("FROM Actor").list();
        session.close();

        req.setAttribute("actors", actors);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        sessionFactory.close();
        super.destroy();
    }

}
