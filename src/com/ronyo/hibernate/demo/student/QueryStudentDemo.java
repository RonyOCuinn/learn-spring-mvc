package com.ronyo.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            List<Student> studentList = session.createQuery("from Student s where s.lastName='Horseman'", Student.class).getResultList();

            for(Student s : studentList){
                System.out.println(s);
            }

        } finally {
            sessionFactory.close();
        }
    }

}
