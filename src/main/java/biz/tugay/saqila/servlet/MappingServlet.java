package biz.tugay.saqila.servlet;

import biz.tugay.saqila.mapping.ColumnMapping;
import biz.tugay.saqila.mapping.enumMap.EnumMapping;
import biz.tugay.saqila.mapping.generationId.GenTableEntity;
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
@WebServlet(urlPatterns = "/mapping")
public class MappingServlet extends HttpServlet {

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

        // изучае mapping в Hibernate
        ColumnMapping mapping = (ColumnMapping) session.get(ColumnMapping.class, 2);

        //testInsertable(session); // тестируем сво-во колонки insertable. Висит на age. По дефолту на уровне БД выставил 999
        //testUpdatable(session); // тестируем сво-во колонки updatable. Висит на telephonNumber.

        //testEnum(session); // тестируем работа enum  в двух видах - когда первична текстовка, и когда первична нумерация. + LOB.

        testGeneratorStrategy(session); // тестируем различные стратегии работы id - генератора.

        session.close();

    }

    private void testInsertable(Session session) {
        ColumnMapping columnMapping = new ColumnMapping();

        columnMapping.setId(3);
        columnMapping.setFirstName("third");
        columnMapping.setLastName("last3");
        columnMapping.setAge(12); // попытаемся сохранить значение, отличное от 999, которое заданно на уровне БД.
        columnMapping.setTelephonNumber("+375293");

        session.save(columnMapping);
        session.getTransaction().commit();
    }

    private void testUpdatable(Session session) {
        ColumnMapping updateEntity = (ColumnMapping) session.get(ColumnMapping.class, 3);

        updateEntity.setAge(11); // Обращу внимание, не взирая на то, что на столбец age висит insertable, это не мешает обновлять данную колонку!
        updateEntity.setFirstName("Yes"); // Обращу внимание, не взирая на то, что на столбец age вис   ит insertable, это не мешает обновлять данную колонку!
        updateEntity.setTelephonNumber("No, it's not change"); // а тут updatable - false. Так что изменения не должны пройти!

        session.update(updateEntity);
        session.getTransaction().commit();
    }

    private void testEnum(Session session) {
        EnumMapping firstRow = (EnumMapping) session.get(EnumMapping.class, 1);
        System.out.println(firstRow.getBlobText());
        EnumMapping secindRow = (EnumMapping) session.get(EnumMapping.class, 2);
    }

    private void testGeneratorStrategy(Session session) {

        GenTableEntity genTableEntity1 = new GenTableEntity();
        GenTableEntity genTableEntity2 = new GenTableEntity();
        GenTableEntity genTableEntity3 = new GenTableEntity();

        genTableEntity1.setUserName("1");
        genTableEntity2.setUserName("2");
        genTableEntity3.setUserName("3");

        session.save(genTableEntity1);
        session.save(genTableEntity2);
        session.save(genTableEntity3);

        session.getTransaction().commit();
    }

    @Override
    public void destroy() {
        sessionFactory.close();
        super.destroy();
    }
}
