package biz.tugay.saqila.servlet;

import biz.tugay.saqila.accessMode.FieldMode;
import biz.tugay.saqila.accessMode.MixedMode;
import biz.tugay.saqila.accessMode.PropertyMode;
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

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = "/accessMode")
public class AccessModeServlet extends HttpServlet {

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

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // изучае доступы в Hibernate

        //field access mode
        FieldMode fieldMode = (FieldMode) session.get(FieldMode.class, 1);

        //property access mode
        PropertyMode propertyMode = (PropertyMode) session.get(PropertyMode.class, 2);

        //mixed access mode
        MixedMode mixedMode = (MixedMode) session.get(MixedMode.class, 3);

        session.close();

    }

    @Override
    public void destroy() {
        sessionFactory.close();
        super.destroy();
    }
}
