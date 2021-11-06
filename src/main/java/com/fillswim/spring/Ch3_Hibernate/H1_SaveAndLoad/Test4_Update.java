package com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test4_Update {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Обновление объекта в БД
//            Employee employee = session.load(Employee.class, 1);
//            employee.setSalary(1500);

            // Обновление нескольких объектов
            session.createQuery("update Employee set salary=1000 where surname='Ivanov'").executeUpdate();

            session.getTransaction().commit();

        }

    }
}
