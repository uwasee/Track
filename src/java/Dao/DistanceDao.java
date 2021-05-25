/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Distance;
import Domain.Hospital;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class DistanceDao extends GenericDao<Distance> {
    public List<Distance>findAllDistance(){
        Session ss=NewHibernateUtil.getSessionFactory().openSession();
        String q="from Hospital as c where c.name='kanombe'";
        Query que=ss.createQuery(q);
        
    List<Distance> ls=que.list();
    ss.close();
    return ls;
    
}
}
