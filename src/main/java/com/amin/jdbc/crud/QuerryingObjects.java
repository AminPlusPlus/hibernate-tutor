package com.amin.jdbc.crud;

import com.amin.jdbc.entity.Student;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;

import java.util.List;

public class QuerryingObjects {

    public static void main(String[] args) {
        try {
            Session session = HibernateAccess.currentSession();

            session.beginTransaction();

            List<Student> list = session.createQuery("from Student s where s.lastName = 'Abdullozoda'")
                    .getResultList();


            List<Student> listMatchEmail = session
                    .createQuery("from Student s where s.email LIKE '%@Bagnola.com'")
                    .getResultList();

            System.out.println("\n\n Bagnola : " + listMatchEmail);



            System.out.println("list of students : " + list);

            session.getTransaction().commit();


        }finally {

        }
    }



}
