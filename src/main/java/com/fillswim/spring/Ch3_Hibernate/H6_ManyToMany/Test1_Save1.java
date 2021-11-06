package com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany;

import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Child;
import com.fillswim.spring.Ch3_Hibernate.H6_ManyToMany.Entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test1_Save1 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            // Создание объектов
            Section section = new Section("Football");

            Child child1 = new Child("Mike", 5);
            Child child2 = new Child("Nike", 6);
            Child child3 = new Child("Nina", 7);

            // Добавление детей в секции
            section.addChildToSection(child1);
            section.addChildToSection(child2);
            section.addChildToSection(child3);

            session.beginTransaction();

            session.persist(section);

            session.getTransaction().commit();

        }

    }
}
