package com.amin.jdbc.utils;

import com.amin.jdbc.entity.Course;
import com.amin.jdbc.entity.Instructor;
import com.amin.jdbc.entity.InstructorDetail;
import com.amin.jdbc.entity.Student;
import org.hibernate.Session;

import org.hibernate.cfg.Configuration;

import javax.swing.text.html.parser.Entity;

public class HibernateAccess {


    public static Session currentSession() {
       return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory().getCurrentSession();
    }

}
