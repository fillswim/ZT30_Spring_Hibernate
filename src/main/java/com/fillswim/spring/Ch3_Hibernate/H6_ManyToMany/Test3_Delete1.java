package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany;

import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test3_Delete1 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Удаление секции
            Section section = session.load(Section.class, 1);

            session.delete(section);

            session.getTransaction().commit();

        }

    }
}
