/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Hospital;
import Util.NewHibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
//import com.itextpdf.text.List;


/**
 *
 * @author User
 */
public class HospitalDao extends GenericDao<Hospital> {
    public List<Hospital>findAllHospital(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="select serviceName from Hospital as c where c.name='Kanombe'";
        Query que=ss.createQuery(q);
        
    List<Hospital> ls=que.list();
    ss.close();
    return ls;
    
}
    public List<Hospital>findAllHospital1(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="select serviceName from Hospital as c where c.name='Nyirikwaya'";
        Query que=ss.createQuery(q);
        
    List<Hospital> ls=que.list();
    ss.close();
    return ls;
    
}
    public List<Hospital>findAllHospital2(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="select serviceName from Hospital as c where c.name='CHUK'";
        Query que=ss.createQuery(q);
        
    List<Hospital> ls=que.list();
    ss.close();
    return ls;
    
}
    public List<Hospital>findAllHospital3(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="select serviceName from Hospital as c where c.name='kibagabaga'";
        Query que=ss.createQuery(q);
        
    List<Hospital> ls=que.list();
    ss.close();
    return ls;
    }
}