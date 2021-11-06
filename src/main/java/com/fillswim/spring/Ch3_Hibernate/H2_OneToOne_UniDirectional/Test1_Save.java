package com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional;

import com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional.Entity.Detail;
import com.fillswim.spring.Ch3_Hibernate.H2_OneToOne_UniDirectional.Entity.Employee;
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

            // Создание и созранение объектов
            Employee employee = new Employee("Mike", "Petrov", "Sales", 600);
            Detail detail = new Detail("Riga", "+7-925-011-20-77", "petrov@mail.ru");
            employee.setDetail(detail);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

        }

    }
}
