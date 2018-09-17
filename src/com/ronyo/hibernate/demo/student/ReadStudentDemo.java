package com.ronyo.hibernate.demo.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Student studentOne = new Student("Bojack", "Horseman", "b.horseman@gmail.com");
            System.out.println("Saving!");
            session.beginTransaction();
            session.save(studentOne);
            System.out.println("Committed successfully");
            
            Student newStudent = session.get(Student.class, studentOne.getId());
            System.out.println("Done! " + newStudent);
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

}
