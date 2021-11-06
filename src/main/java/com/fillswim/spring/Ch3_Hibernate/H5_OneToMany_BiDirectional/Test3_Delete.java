package com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional;

import com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional.Entity.Employee;
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
            // Загрузка объекта
            Employee employee = session.load(Employee.class, 5);

            session.delete(employee);

            session.getTransaction().commit();

        }
    }
}
