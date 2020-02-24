package com.amin.jdbc.advanceMaping;

import com.amin.jdbc.entity.Course;
import com.amin.jdbc.entity.Instructor;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;

public class OneToManyBiDirectional {

    public static void main(String[] args) {

        try {
            Session session = HibernateAccess.currentSession();



            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class,1);

            instructor.getCourses().forEach(c-> {
                System.out.println(c.getTitle());
            });



            session.save(instructor);

            session.getTransaction().commit();


        }catch (Exception exp){

        }



    }

}
