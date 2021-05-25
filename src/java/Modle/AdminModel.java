/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.AdminDao;
import Domain.Admin;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class AdminModel {
    private Admin admin=new Admin();
private Admin admindetails=new Admin();
Dao.AdminDao adminDao=new Dao.AdminDao();
private String id=new String();
private String searchKey=new String();
private List<Admin> adminList;


@PostConstruct
public void init(){
adminList=new AdminDao().findAll(Admin.class);
}

public void createAdmin()
{
//adminDao.update(admindetails);
admindetails=new Admin();
adminList=adminDao.findAll(Admin.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Admin is well updated"));
}

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Admin getAdmindetails() {
        return admindetails;
    }

    public void setAdmindetails(Admin admindetails) {
        this.admindetails = admindetails;
    }

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }

    

    
}
