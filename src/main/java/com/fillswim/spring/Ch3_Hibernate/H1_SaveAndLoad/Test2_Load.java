package com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad;

import com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test2_Load {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Загрузка объекта из БД
            Employee employee = session.load(Employee.class, 1);
            System.out.println(employee);

            session.getTransaction().commit();

        }

    }
}
