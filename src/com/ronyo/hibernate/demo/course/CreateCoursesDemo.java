package com.ronyo.hibernate.demo.course;

import com.ronyo.hibernate.demo.instructor.Instructor;
import com.ronyo.hibernate.demo.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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

            Instructor instructor = session.get(Instructor.class, 1);

            Course courseOne = new Course("Data Structures and Algorithms");
            Course courseTwo = new Course("Functional Programming");
            Course courseThree = new Course("Testing");

            instructor.addCourse(courseOne);
            instructor.addCourse(courseTwo);
            instructor.addCourse(courseThree);

            session.save(courseOne);
            session.save(courseTwo);
            session.save(courseThree);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
