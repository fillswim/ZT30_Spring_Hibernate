package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany;

import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Child;
import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Test2_Load2 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();

            // Загрузка ребенка и вывод на экран всех его сессий
            Child child = session.load(Child.class, 5);
            List<Section> sections = child.getSections();

            for (Section section : sections) {
                System.out.println(section);
            }

            session.getTransaction().commit();

        }

    }
}
