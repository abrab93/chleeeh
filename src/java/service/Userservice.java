/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;
import static util.HibernateUtil.sessionFactory;

/**
 *
 * @author Youness
 */
public class Userservice {
    
     public User findById(int i) {
        User person = null;
        sessionFactory.getCurrentSession().beginTransaction();
        person = (User) sessionFactory.getCurrentSession().get(User.class, i);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.close();
        return person;
    }

    
    public void save(User person) {


        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(person);
        sessionFactory.getCurrentSession().getTransaction().commit();
        sessionFactory.close();
    }
    
}
