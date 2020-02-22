package com.amin.jdbc.crud;

import com.amin.jdbc.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CreateStudent {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)

                .buildSessionFactory();

        try {

            //Create session
            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Student newStudent = new Student("Hello","Hi", "jim@Bagnola.com");
            Student newStudent1 = new Student("Xhang","Rachel", "jim@Bagnola.com");
            Student newStudent2 = new Student("Aminjoni","Abdullozoda", "amin030296@gmail.co");

            session.save(newStudent);
            session.save(newStudent1);
            session.save(newStudent2);

            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }



    }
}
