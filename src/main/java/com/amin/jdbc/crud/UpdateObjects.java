package com.amin.jdbc.crud;

import com.amin.jdbc.entity.Student;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;

public class UpdateObjects {

    public static void main(String[] args) {
        try {

            Session session = HibernateAccess.currentSession();
            session.beginTransaction();

            //Retrieve object
            Student student = session.get(Student.class,1);
            student.setEmail("jim@mum.edu");




            //Update all student emails.
            session.createQuery("update Student set email = concat(email,'@mum.edu') ")
                                .executeUpdate();

            //commit session transaction
            session.getTransaction().commit();


        }finally {

        }
    }

}
