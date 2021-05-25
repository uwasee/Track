/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.DistanceDao;
import Domain.Distance;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class DistanceModel {
    private Distance distdetails=new Distance();
    List<Distance> Listdistance = new DistanceDao().findAll(Distance.class);
    Distance distance = new Distance();
    String messages = new String();
  DistanceDao moDao=new DistanceDao();
     List<Distance> po = new ArrayList<>();
    private String searchKey=new String();
    public static String distanceBtnCoordinates(String originLatitude,String originLongitude,String destinationLatitude,String DestinationLongitude) {
		String origin = originLatitude + "," + originLongitude;
		String destination=destinationLatitude+","+DestinationLongitude;
		try {
			CloseableHttpClient client = HttpClients.createDefault();
			HttpPost request = new HttpPost("https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&destinations="+destination+"&key=AIzaSyBMNmJIxItpTDEIPZl367rY1uzzq1Is-tw");
			HttpResponse response = (HttpResponse) client.execute(request);
			   HttpEntity entity = response.getEntity();
			   String str;
				str = EntityUtils.toString(entity);
				JSONObject json = new JSONObject(str);
				JSONObject rows = new JSONObject(json.getJSONArray("rows").get(0).toString());
				JSONObject elements = new JSONObject(rows.getJSONArray("elements").get(0).toString());
				return elements.getJSONObject("distance").getString("text");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    public void createDistance(){
    messages = new  DistanceDao().save(distance);

        
         System.out.println(distanceBtnCoordinates("-1.9346153","30.0905639", "-1.9555547","30.1021022"));
         Listdistance = new DistanceDao().findAll(Distance.class);
        distance = new  Distance();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(messages));
    
    }

    public Distance getDistdetails() {
        return distdetails;
    }

    public void setDistdetails(Distance distdetails) {
        this.distdetails = distdetails;
    }

    public List<Distance> getListdistance() {
        return Listdistance;
    }

    public void setListdistance(List<Distance> Listdistance) {
        this.Listdistance = Listdistance;
    }

    public Distance getDistance() {
        return distance;
    }

    public void setDistance(Distance distance) {
        this.distance = distance;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public DistanceDao getMoDao() {
        return moDao;
    }

    public void setMoDao(DistanceDao moDao) {
        this.moDao = moDao;
    }

    public List<Distance> getPo() {
        return po;
    }

    public void setPo(List<Distance> po) {
        this.po = po;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
    

  
  }
  
   
  