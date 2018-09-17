package com.ronyo.hibernate.demo.instructor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_advanced_mappings.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 4;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());

            session.getTransaction().commit();

        } catch (NullPointerException e){
            e.printStackTrace();
        }
        finally {
            sessionFactory.close();
        }
    }

}
