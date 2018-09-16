package com.ronyo.hibernate.demo;

import com.ronyo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class, 10);
            student.setFirstName("Rony");

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

}
