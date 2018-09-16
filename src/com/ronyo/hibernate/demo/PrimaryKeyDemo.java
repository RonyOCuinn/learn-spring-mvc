package com.ronyo.hibernate.demo;

import com.ronyo.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args){
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            Student studentOne = new Student("Ronan", "O Cuinn", "rocuinn@gmail.com");
            Student studentTwo = new Student("Eoin", "Bleeks", "ebleeks@gmail.com");
            Student studentThree = new Student("Orla", "Foley", "ofoley01@gmail.com");
            System.out.println("Saving!");
            session.save(studentOne);
            session.save(studentTwo);
            session.save(studentThree);
            session.getTransaction().commit();
            System.out.println("Committed successfully");
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
