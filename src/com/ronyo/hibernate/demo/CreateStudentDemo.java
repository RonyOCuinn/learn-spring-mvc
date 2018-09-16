package com.ronyo.hibernate.demo;

import com.ronyo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Student student = new Student("Ronan", "O Cuinn", "rocuinn@gmail.com");
            System.out.println("Saving!");
            session.save(student);
            session.getTransaction().commit();
            System.out.println("Committed successfully");
        } finally {
            session.close();
        }
    }

}
