package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany;

import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Child;
import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test1_Save2 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Создание объектов
            Section section1 = new Section("Volleyball");
            Section section2 = new Section("Chess");
            Section section3 = new Section("Math");

            Child child = new Child("Igor", 5);

            // Добавление секции для ребенка
            child.addSectionToChild(section1);
            child.addSectionToChild(section2);
            child.addSectionToChild(section3);

            session.beginTransaction();

            session.persist(child);

            session.getTransaction().commit();

        }

    }
}
