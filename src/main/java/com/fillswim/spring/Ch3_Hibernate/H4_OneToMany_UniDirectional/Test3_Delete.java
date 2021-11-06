package com.fillswim.spring.Ch3_Hibernate.H4_OneToMany_UniDirectional;

import com.fillswim.spring.Ch3_Hibernate.H4_OneToMany_UniDirectional.Entity.Department;
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

            // Загрузка данных из БД
            Department department = session.load(Department.class, 1);

            // Удаление департамента
            session.delete(department);

            session.getTransaction().commit();

        }

    }
}
