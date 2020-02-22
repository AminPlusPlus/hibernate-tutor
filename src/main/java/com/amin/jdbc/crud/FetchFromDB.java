package com.amin.jdbc.crud;

import com.amin.jdbc.entity.Student;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;

import java.sql.SQLException;
import java.util.List;

public class FetchFromDB {

    public static void main(String[] args) {

        try {

            Session session = HibernateAccess.currentSession();

            session.beginTransaction();

            Student s1 = session.get(Student.class,4);

            System.out.println("READ STUDENT: " + s1);

            session.getTransaction().commit();

        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
