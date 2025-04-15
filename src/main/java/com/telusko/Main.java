package com.telusko;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
//        s1.setsName("Jacky");
//        s1.setRollNb(104);
//        s1.setsAge(47);

        Student s2 = null;


        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.telusko.Student.class)
                .configure()
                .buildSessionFactory();  //cfg.buildSessionFactory();
        Session session = sf.openSession();

        s1 = session.get(Student.class, 104);
        session.remove(s1);
        // session.merge(s1);
        //  s2 = session.get(Student.class, 102);
        Transaction transaction = session.beginTransaction();

        // session.persist(s1);


        transaction.commit();

        session.close();
        sf.close();

        System.out.println(s1);
    }
}