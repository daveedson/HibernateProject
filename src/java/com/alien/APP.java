/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alien;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class APP {

    public static void main(String[] args) {

        Session session = null;

        Alien alien = new Alien();
        alien.setAlienName("Wijoo");
        alien.setAlienLastName("Idada");
        alien.setAlienColor("Blue");

        try {

            session = HibernateUtil.getSessionFactory().openSession();
            Transaction ts = session.beginTransaction();

            session.save(alien);

            ts.commit();

            System.out.println("Data saved successsfully");

        } catch (HibernateException e) {
            System.out.println("An Error Occurred" + e);
        } finally {

            session.clear();
            session.close();

        }

    }

}
