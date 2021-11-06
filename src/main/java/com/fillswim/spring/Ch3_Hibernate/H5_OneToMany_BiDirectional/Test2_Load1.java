package com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional;

import com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional.Entity.Department;
import com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional.Entity.Employee;
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
            // Загрузка объектов
            Department department = session.load(Department.class, 1);
            List<Employee> employees = department.getEmployees();

            // Вывод департамента
            System.out.println(department);
            // Вывод работников
            for (Employee employee : employees) {
                System.out.println(employee);
            }


            session.getTransaction().commit();

        }

    }
}
