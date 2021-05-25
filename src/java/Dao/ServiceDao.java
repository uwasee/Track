/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Service;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class ServiceDao extends GenericDao<Service> {
    public List<Service>findAllService(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='dental' AND  c.hospital.name='Nyirikwaya' ";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;
    
    
    }
        public List<Service>findAllServicek(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='dental' AND  c.hospital.name='Kanombe' ";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;
    
    
    }
    public List<Service>findAllServiceKibagabaga(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='general' AND  c.hospital.name='kibagabaga' ";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;
    
    
    }
   public List<Service>findAllGeneral(){
       
    Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='pediatri' AND  c.hospital.name='kibagabaga' ";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
       
   } 
   public List<Service>findAllGeneralNyirinkwaya(){
       
    Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='general' AND c.hospital.name='Nyirikwaya'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
       
   } 
   public List<Service>findAllGeneralCHUK(){
       
    Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='pediatri' AND c.hospital.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
       
   }
   public List<Service> findAll(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='dental' AND c.hospital.name='kanombe' ";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
       
   }
   public List<Service>findAll2(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='general' AND c.hospital.name='kanombe'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAll3(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='pediatri' AND c.hospital.name='kanombe'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki4(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='dental' AND c.hospital.name='kibagabaga'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki5(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='general' AND c.hospital.name='kibagabaga'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki6(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='pediatri' AND c.hospital.name='kibagabaga'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki7(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='pediatri' AND c.hospital.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki8(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='eyes' AND c.hospital.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki9(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='neurology' AND c.hospital.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
   public List<Service>findAllki10(){
   
   Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Service as c where c.name='dental' AND c.hospital.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Service> ls=que.list();
    ss.close();
    return ls;   
   
   }
//   public List<Service>findAllkanombe(){
//   
//   Session ss=NewHibernateUtil.getSessionFactory().openSession();
//        String q=" countfrom Service as c where c.name='dental' AND c.";
//        Query que=ss.createQuery(q);
//        
//    List<Service> ls=que.list();
//    ss.close();
//    return ls;   
//   
//   }
}




