package com.amin.jdbc.crud;

import com.amin.jdbc.entity.Student;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;

public class DeleteObjects {
    public static void main(String[] args) {

        Session session = HibernateAccess.currentSession();
        session.beginTransaction();

        //retrieve object
        Student student = session.get(Student.class,1);

        //delete
        session.delete(student);

        //delete by query
        session.createQuery("delete from Student where id = 4 ")
                .executeUpdate();

        //commit
        session.getTransaction().commit();

    }
}
