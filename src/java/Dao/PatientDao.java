/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Compare;
import Domain.Patient;
import Util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class PatientDao extends GenericDao<Patient> {
//    public List<Patient> findAll2(Class c) {
//        Session ss = NewHibernateUtil.getSessionFactory().openSession();
//        Query q = ss.createQuery("from " + c.getName() + " s ORDER BY s.Result DESC");
//        List<Patient> list = q.list();
//        ss.close();
//        
//        return list;
//    }
    
}
