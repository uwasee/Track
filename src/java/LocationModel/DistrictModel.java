/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationModel;

import Location.District;
import Location.Province;
import LocationDao.DistrictDao;
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
public class DistrictModel {
    
    List<District> districtList = new DistrictDao().FindAll(District.class);
    List<District> districtByProvince = new ArrayList<>();
    District district = new District();
    String message = new String();
    String dropPro;

    public void createDistrict(){
        Province province = new Province();
        province.setProv_Id(dropPro);
        district.setProvince(province);
        message = new DistrictDao().save(district);
        districtList = new DistrictDao().FindAll(District.class);
        district = new District();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
        
    }
    
    
    
         public void findByProvince(){
        try{
       districtByProvince = new ArrayList<>();
       Province pro=new Province();

       List<District> ls=new DistrictDao().FindAll(District.class);
   
       for(District v: ls){
           if(v.getProvince().getProv_Id().equals(dropPro)){
              districtByProvince.add(v);
           }
       }
       }catch(Exception e){e.printStackTrace();}
         }
//       Province pro=new Province();
//       pro.setCode(dropPro);
//        districtByProvince=new DistrictDao().viewAllByProvince(pro);
//     }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<District> getDistrictByProvince() {
        return districtByProvince;
    }

    public void setDistrictByProvince(List<District> districtByProvince) {
        this.districtByProvince = districtByProvince;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDropPro() {
        return dropPro;
    }

    public void setDropPro(String dropPro) {
        this.dropPro = dropPro;
    }

    
}
