package com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test5_Delete {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Удаление объекта из БД
//            Employee employee = session.load(Employee.class, 1);
//            session.delete(employee);

            // Удаление объектов с помощью HQL
            session.createQuery("delete Employee where surname='Ivanov'").executeUpdate();

            session.getTransaction().commit();

        }

    }
}
