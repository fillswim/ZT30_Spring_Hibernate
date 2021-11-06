package com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad;

import com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test1_Save {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Сохранение объекта в БД
            Employee employee = new Employee("Nick", "Smirnov", "Sales", 700);
            session.save(employee);

            session.getTransaction().commit();

        }

    }
}
