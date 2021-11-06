package com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional;

import com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional.Entity.Department;
import com.fillswim.spring.Ch3_Hibernate.H5_OneToMany_BiDirectional.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Test2_Load2 {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
             Session session = sessionFactory.openSession()) {

            session.beginTransaction();
            // Загрузка объекта
            Employee employee = session.load(Employee.class, 2);
            Department department = employee.getDepartment();

            // Вывод работника
            System.out.println(employee);
            // Вывод департамента
            System.out.println(department);

            session.getTransaction().commit();

        }
    }
}
