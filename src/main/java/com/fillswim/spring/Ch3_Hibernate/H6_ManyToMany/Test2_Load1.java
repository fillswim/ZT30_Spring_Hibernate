package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany;

import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Child;
import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Test2_Load1 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Загрузка секции и вывод на печать детей
            Section section = session.load(Section.class, 1);
            List<Child> children = section.getChildren();

            for (Child child : children) {
                System.out.println(child);
            }

            session.getTransaction().commit();

        }

    }
}
