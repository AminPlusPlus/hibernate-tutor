package com.amin.jdbc.advanceMaping;

import com.amin.jdbc.entity.Instructor;
import com.amin.jdbc.entity.InstructorDetail;
import com.amin.jdbc.utils.HibernateAccess;
import org.hibernate.Session;

public class OneToOneApp {

    public static void main(String[] args) {
        try {

            Session session = HibernateAccess.currentSession();

            //Delete Instructor
            // deleteInstructor(session,5);

            //Read Instructor Detail
            //readInstructorDetail(session,11);

            //Delete Instructor Detail
           // deleteInstructorDetail(session,3);


            //setting to the Instructor new instruction detail
            InstructorDetail newDetail =  new InstructorDetail("azure.com","Hiking");

            session.beginTransaction();
            Instructor tempInst = session.get(Instructor.class,3);
            tempInst.setInstructorDetail(newDetail);
            session.getTransaction().commit();


        } finally {

        }
    }


    public static void save (Session session) {
        InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com/dance","Coding,Gym");

        Instructor instructor = new Instructor("John","Ray","johnRay@gmailcom",instructorDetail);


        session.beginTransaction();
        session.save(instructor);

        session.getTransaction().commit();
    }


    public static  void deleteInstructor (Session session, int id) {

        session.beginTransaction();
        Instructor instructor = session.get(Instructor.class,id);

        session.delete(instructor);
        session.getTransaction().commit();
    }

    public static void readInstructorDetail (Session session, int id) {
        session.beginTransaction();

        InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);

        System.out.println(instructorDetail.getInstructor());

        session.getTransaction().commit();
    }

    public static void deleteInstructorDetail(Session session, int id){
        session.beginTransaction();
        InstructorDetail detail = session.get(InstructorDetail.class,id);

        //remove association from the Instructor
        detail.getInstructor().setInstructorDetail(null);

        session.delete(detail);
        session.getTransaction().commit();
    }
}
