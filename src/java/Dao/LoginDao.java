/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Domain.Doctor;
import Domain.Login;
import Util.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class LoginDao extends GenericDao<Login> {
    public List<Login> loginencrypt(String u, String pass) throws Exception {

        Session s = NewHibernateUtil.getSessionFactory().openSession();
        List<Login> list = new ArrayList<>();

        List<Login> users = new LoginDao().findAll(Login.class);
        String z = "";
        for (Login us : users) {
            if (us.getUsername().matches(u)) {
                if (us.getPassword().matches(pass)) {
                    list.add(us);
                }
            }

        }

        s.close();
        return list;

    }
    
    
    public List<Login> login(String psw,String un){
      Session  s=NewHibernateUtil.getSessionFactory().openSession();
      Query q=s.createQuery("from Login s where s.password= :v and s.username= :l");
      q.setString("v", psw);
       q.setString("l", un);
      List<Login> u=q.list();
      return u;
    } 
     public List<Doctor> searchCustomer(Login us){
      Session  s=NewHibernateUtil.getSessionFactory().openSession();
      Query que=s.createQuery("from Aplicant s where s.login.username= :v ");
      que.setEntity("v", us);
       
      List<Doctor> u=que.list();
      s.close();
      return u;
    }     
    
}
