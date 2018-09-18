package com.ronyo.hibernate.demo;

import com.ronyo.hibernate.demo.course.Course;
import com.ronyo.hibernate.demo.instructor.Instructor;
import com.ronyo.hibernate.demo.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Query<Instructor> query = session.createQuery("select i from Instructor i JOIN FETCH i.courses where i.id=:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", 1);
            Instructor instructor = query.getSingleResult();

            System.out.println(instructor);

            session.getTransaction().commit();
            session.close();

            System.out.println(instructor.getCourses());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
