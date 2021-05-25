/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationModel;

import Location.District;
import Location.Sector;
import LocationDao.SectorDao;
import java.util.ArrayList;
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
public class SectorModel {
    List<Sector> sectorList = new SectorDao().FindAll(Sector.class);
    Sector sector = new Sector();
    String message = new String();
    String dropDis;
    List<Sector> se = new ArrayList<>();
   
    
   public void findByDistrict(){   
      try{
       se = new ArrayList<>();
      District Dis=new District();
      List<Sector> ls=new SectorDao().FindAll(Sector.class);
      for(Sector v: ls){
           if(v.getDistrict().getDist_Id().equals(dropDis)){
              se.add(v);
           }
       }
       }catch(Exception e){e.printStackTrace();}
     }
    
    
    public void createSector(){
       
       District district = new District();
        district.setDist_Id(dropDis);
        sector.setDistrict(district);
        message = new SectorDao().save(sector);
        sectorList = new SectorDao().FindAll(Sector.class);
        sector = new Sector();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public List<Sector> getSectorList() {
        return sectorList;
    }

    public void setSectorList(List<Sector> sectorList) {
        this.sectorList = sectorList;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDropDis() {
        return dropDis;
    }

    public void setDropDis(String dropDis) {
        this.dropDis = dropDis;
    }

    public List<Sector> getSe() {
        return se;
    }

    public void setSe(List<Sector> se) {
        this.se = se;
    }

    
}
