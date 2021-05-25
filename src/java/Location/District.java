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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author User
 */
@Entity
public class District {
    @Id
    
    private String Dist_Id;
private String Dist_Name; 

@ManyToOne
private Province province;
@OneToMany(mappedBy="district",fetch=FetchType.EAGER)
List<Sector>sector;

    public String getDist_Id() {
        return Dist_Id;
    }

    public void setDist_Id(String Dist_Id) {
        this.Dist_Id = Dist_Id;
    }

    public String getDist_Name() {
        return Dist_Name;
    }

    public void setDist_Name(String Dist_Name) {
        this.Dist_Name = Dist_Name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public List<Sector> getSector() {
        return sector;
    }

    public void setSector(List<Sector> sector) {
        this.sector = sector;
    }

    

    
}
