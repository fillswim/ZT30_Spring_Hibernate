package com.fillswim.spring.Ch3_Hibernate.H3_OneToOne_BiDirectional;

import com.fillswim.spring.Ch3_Hibernate.H3_OneToOne_BiDirectional.Entity.Detail;
import com.fillswim.spring.Ch3_Hibernate.H3_OneToOne_BiDirectional.Entity.Employee;
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

            // Загрузка объетов из БД
            Detail detail = session.load(Detail.class, 2);
            Employee employee = detail.getEmployee();

            System.out.println(detail);
            System.out.println(employee);

            session.getTransaction().commit();

        }

    }
}
