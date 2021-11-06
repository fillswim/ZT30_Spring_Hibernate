package com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional;

import com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional.Entity.Detail;
import com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional.Entity.Employee;
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
            Employee employee = session.load(Employee.class, 1);
            Detail detail = employee.getDetail();

            System.out.println(detail);

            System.out.println();

            session.save(employee);

            session.getTransaction().commit();

        }

    }
}
