/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Compare;
import Util.NewHibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class GenericDao<X> {
    public String save(X a) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(a);
        ss.getTransaction().commit();
        ss.close();
        return "Saved!";

    }
    
    
        public void save2(X a) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(a);
        ss.getTransaction().commit();
        ss.close();
   }

    public void update(X a) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(a);
        ss.getTransaction().commit();
        ss.close();

    }

    public void delete(X a) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(a);
        ss.getTransaction().commit();
        ss.close();

    }

    public List<X> findAll(Class c) {

        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        Query q = ss.createQuery("from " + c.getName() + " s ");
        List<X> list = q.list();
        ss.close();
        return list;

    }
   public List<Compare>view(String q) {
       
      
        return NewHibernateUtil.getSessionFactory().openSession().createQuery(q).list();
    } 
    public X findbyId(Class c, Serializable id) {
        Session ss = NewHibernateUtil.getSessionFactory().openSession();
        X s = (X) ss.get(c, id);
        ss.close();
        return s;
    }
    
    
}
