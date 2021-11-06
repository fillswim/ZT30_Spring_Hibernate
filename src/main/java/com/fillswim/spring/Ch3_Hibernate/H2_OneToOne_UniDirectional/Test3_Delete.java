package com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional;

import com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test3_Delete {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Удаление объетов из БД
            Employee employee = session.load(Employee.class, 1);
            session.delete(employee);

            session.getTransaction().commit();

        }

    }
}
