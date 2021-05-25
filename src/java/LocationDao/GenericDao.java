/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationDao;

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
    
    public String save(X x){
        Session ses=NewHibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        ses.save(x);
        ses.getTransaction().commit();
        ses.close();
        return"Saved Successfully";
    }
    
    public String delete(X x){
        Session ses=NewHibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        ses.delete(x);
        ses.getTransaction().commit();
        ses.close();
        return"Well deleted";
    }
    
    
    public String update(X x){
        Session ses=NewHibernateUtil.getSessionFactory().openSession();
        ses.beginTransaction();
        ses.update(x);
        ses.getTransaction().commit();
        ses.close();
        return"Well updated";
    }
    
    
  public List<X> FindAll(Class c){
  Session ss=NewHibernateUtil.getSessionFactory().openSession();
Query q=ss.createQuery("select a from "+c.getName()+" a");
List<X>list=q.list();
ss.close();
        return list;
  } 
      
 public List<X> FindAll2(String query,String id){
  Session ss=NewHibernateUtil.getSessionFactory().openSession();
Query q=ss.createQuery(query);
q.setString(0, id);

//ss.close();
        return q.list();
  } 
      
  
public X FindOne(Class c,Serializable id){
  Session ss=NewHibernateUtil.getSessionFactory().openSession();
X x=(X)ss.get(c, id);
ss.close();
        return x;
  }   
  
}
 


    

