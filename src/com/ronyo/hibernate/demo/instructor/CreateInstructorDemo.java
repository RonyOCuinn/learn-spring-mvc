package com.ronyo.hibernate.demo.instructor;

import com.ronyo.hibernate.demo.course.Course;
import com.ronyo.hibernate.demo.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate_one_to_many.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("Ronan", "O Cuinn", "rocuinn@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/rony", "cans");

            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }

}
