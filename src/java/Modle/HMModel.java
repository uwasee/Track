/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

//import Dao.CitizenDao;
import Dao.HMDao;
import Dao.LoginDao;
import Domain.HM;
import Domain.Login;
import Location.Village;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
////import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.primefaces.context.RequestContext;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class HMModel {
    private HM citydetails=new HM();
    List<HM> cityList = new HMDao().findAll(HM.class);
    HM citizen = new HM();
    private Login login= new Login();
    LoginDao loginDao=new LoginDao();
    String message = new String();
    String dropVillages;
    HMDao ciDao=new HMDao();
    List<HM> ci = new ArrayList<>();
    private String searchKey=new String();
    
//    public static String distanceBtnCoordinates(String originLatitude,String originLongitude,String destinationLatitude,String DestinationLongitude) {
//		String origin = originLatitude + "," + originLongitude;
//		String destination=destinationLatitude+","+DestinationLongitude;
//		try {
//			CloseableHttpClient client = HttpClients.createDefault();
//			HttpPost request = new HttpPost("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&destinations="+destination+"&key=AIzaSyBMNmJIxItpTDEIPZl367rY1uzzq1Is-tw");
//			HttpResponse response = (HttpResponse) client.execute(request);
//			   HttpEntity entity = response.getEntity();
//			   String str;
//				str = EntityUtils.toString(entity);
//				JSONObject json = new JSONObject(str);
//				JSONObject rows = new JSONObject(json.getJSONArray("rows").get(0).toString());
//				JSONObject elements = new JSONObject(rows.getJSONArray("elements").get(0).toString());
//				return elements.getJSONObject("distance").getString("text");
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//    public void findByVillages() {
//        try {
//            ci = new ArrayList<>();
//            Village vil = new Village();
//            List<Citizens> ls = new CitizenDao().findAll(Citizens.class);
//            for (Citizens c : ls) {
//                if (c.getVillage().getVill_Id().equals(dropVillages)) {
//                    ci.add(c);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    public void createCitizen(){
//    Village village = new Village();
//        village.setVill_Id(dropVillages);
//        citizen.setVillage(village);
        login.setPassword(login.getPassword());
        login.setRoleType("Manager");
        loginDao=new LoginDao();
        loginDao.save2(login);
        citizen.setLogin(login);
        message = new  HMDao().save(citizen);
    //System.out.println(distanceBtnCoordinates("-1.9346153","30.0905639", "-1.9555547","30.1021022"));
    cityList = new HMDao().findAll(HM.class);
        citizen = new  HM();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    
    }
    
         public void updateDoctor()
{
  ciDao=new HMDao();  
//placedetails.setTypeName(message);
ciDao.update(citydetails);
citydetails=new HM();
cityList= ciDao.findAll(HM.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
     public String fetchItems(final HM pl) {
        this.citydetails = pl;
        return "editDoctor.xhtml?faces-redirect=true";
    }
     public void deleteDoctor() {
       ciDao .delete(this.citydetails);
        cityList=ciDao.findAll(HM.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Manager is well deleted", ""));
    }
     public void fetchAndShow(final HM pl) {
        this.citydetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
     public void clearDoctorDetails() {
        this.citydetails = null;
    }
     public List<HM> view(){
     List<HM> list=new HMDao().findAll(HM.class);
     return list;
     }
     public void search(){
   if(searchKey.length() > 0){
   cityList= new ArrayList<>();
   List<HM> placetype =  ciDao.findAll(HM.class);
   for(HM patient : placetype){
   if(patient.getId().toString().contains(searchKey) ){
   cityList.add(patient);
   }
   
   }
   
   }else{
   cityList=ciDao.findAll(HM.class);
   }
           
           
           
           
   }
    

    public HM getCitydetails() {
        return citydetails;
    }

    public void setCitydetails(HM citydetails) {
        this.citydetails = citydetails;
    }

    public List<HM> getCityList() {
        return cityList;
    }

    public void setCityList(List<HM> cityList) {
        this.cityList = cityList;
    }

    public HM getCitizen() {
        return citizen;
    }

    public void setCitizen(HM citizen) {
        this.citizen = citizen;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDropVillages() {
        return dropVillages;
    }

    public void setDropVillages(String dropVillages) {
        this.dropVillages = dropVillages;
    }

    

    public List<HM> getCi() {
        return ci;
    }

    public void setCi(List<HM> ci) {
        this.ci = ci;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public HMDao getCiDao() {
        return ciDao;
    }

    public void setCiDao(HMDao ciDao) {
        this.ciDao = ciDao;
    }
    
    
}
