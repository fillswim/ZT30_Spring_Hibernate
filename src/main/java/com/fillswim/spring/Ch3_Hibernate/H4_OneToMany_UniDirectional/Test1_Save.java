package com.fillswim.spring.Ch3_Hibernate.H4_OneToMany_UniDirectional;

import com.fillswim.spring.Ch3_Hibernate.H4_OneToMany_UniDirectional.Entity.Department;
import com.fillswim.spring.Ch3_Hibernate.H4_OneToMany_UniDirectional.Entity.Employee;
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

            // Создание и сохранение объектов
            Department department = new Department("IT", 300, 1200);

            Employee employee1 = new Employee("Mike", "Petrov", 800);
            Employee employee2 = new Employee("Nick", "Ivanov", 900);

            department.addEmployeeToDepartment(employee1);
            department.addEmployeeToDepartment(employee2);


            session.beginTransaction();

            session.save(department);

            session.getTransaction().commit();

        }

    }
}
