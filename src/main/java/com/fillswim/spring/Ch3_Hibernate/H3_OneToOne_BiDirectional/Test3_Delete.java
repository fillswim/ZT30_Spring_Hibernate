package com.fillswim.spring.Ch3_Hibernate.H3_OneToOne_BiDirectional;

import com.fillswim.spring.Ch3_Hibernate.H3_OneToOne_BiDirectional.Entity.Detail;
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

            // Удаление объетов из БД при CascadeType.ALL
//            Detail detail = session.load(Detail.class, 2);
//            session.delete(detail);

            // Удаление объетов из БД при CascadeType.PERSIST, CascadeType.REFRESH
            Detail detail = session.load(Detail.class, 4);
            // Разрушение связи между объектами
            detail.getEmployee().setDetail(null);

            session.delete(detail);

            session.getTransaction().commit();

        }

    }
}
