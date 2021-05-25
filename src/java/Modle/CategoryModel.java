/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.CategoryDao;
import Domain.Category;
import java.util.List;
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
public class CategoryModel {
    
     private Category category=new Category();
 private  Category catDeatails=new  Category();
 private List<Category> list=new CategoryDao().findAll(Category.class);

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCatDeatails() {
        return catDeatails;
    }

    public void setCatDeatails(Category catDeatails) {
        this.catDeatails = catDeatails;
    }

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }
 
 public void create(){
    new CategoryDao().save(category);
   category=new Category();
     list=new CategoryDao().findAll(Category.class);
     FacesContext fc=FacesContext.getCurrentInstance();
        fc.addMessage(null,new FacesMessage("saved"));
    }
    
}

