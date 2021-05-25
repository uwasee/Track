/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Location;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class Province {
    @Id
    
    private String Prov_Id;
private String Prov_Name;

@OneToMany(mappedBy="province",fetch=FetchType.EAGER)
 List<District>district;

    public String getProv_Id() {
        return Prov_Id;
    }

    public void setProv_Id(String Prov_Id) {
        this.Prov_Id = Prov_Id;
    }

    public String getProv_Name() {
        return Prov_Name;
    }

    public void setProv_Name(String Prov_Name) {
        this.Prov_Name = Prov_Name;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }

    
}
