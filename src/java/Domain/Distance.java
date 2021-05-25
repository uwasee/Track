/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

/**
 *
 * @author User
 */
@Entity
public class Distance {
    @Id
    private Integer id;
    private String originLatitude;
    private String originLongitude;
    private String destinationLatitude;
    private String DestinationLongitude;
    private String distanceBtnCoordinates;
    
    public void setDistanceBtnCoordinates(String distanceBtnCoordinates) {
        this.distanceBtnCoordinates = distanceBtnCoordinates;
    }
   public String getDistanceBtnCoordinates() {
		String origin = this.originLatitude + "," + this.originLongitude;
		String destination=this.destinationLatitude+","+this.DestinationLongitude;
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
				return elements.getJSONObject("distance").getString("text").toString();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(String originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(String originLongitude) {
        this.originLongitude = originLongitude;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public String getDestinationLongitude() {
        return DestinationLongitude;
    }

    public void setDestinationLongitude(String DestinationLongitude) {
        this.DestinationLongitude = DestinationLongitude;
    }
    
    
    
    
    
    
    
    
}

    
    
