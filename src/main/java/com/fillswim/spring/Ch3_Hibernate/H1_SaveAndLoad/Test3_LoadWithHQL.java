package com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad;

import com.fillswim.spring.Ch3_Hibernate.H1_SaveAndLoad.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Test3_LoadWithHQL {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Загрузка объекта из БД с использованием HQL
            // (Employees в запросе это не имя таблицы, а имя класса)
//            List<Employee> employees = session.createQuery("from Employee").getResultList();
            List<Employee> employees = session.createQuery("from Employee where name='Alex'").getResultList();
            for (Employee employee : employees) {
                System.out.println(employee);
            }

            session.getTransaction().commit();

        }
    }
}
