package com.telusko;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.telusko.Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();


        String brand = "Asus";
        // select * from laptop where ram = 32 => SQL
        // from Laptop where ram = 32 => HQL
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);
        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " " + data[1]);
        }


        // Laptop l1 = session.get(Laptop.class, 3);


        System.out.println(laptops);

        session.close();

        sf.close();


    }
}