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
public class Sector {
    @Id
    
    private String Sect_Id;
private String Sect_Name;

@OneToMany(mappedBy="sector",fetch=FetchType.EAGER)
List<Cells>cell;

@ManyToOne
private District district;

    public String getSect_Id() {
        return Sect_Id;
    }

    public void setSect_Id(String Sect_Id) {
        this.Sect_Id = Sect_Id;
    }

    public String getSect_Name() {
        return Sect_Name;
    }

    public void setSect_Name(String Sect_Name) {
        this.Sect_Name = Sect_Name;
    }

    public List<Cells> getCell() {
        return cell;
    }

    public void setCell(List<Cells> cell) {
        this.cell = cell;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    
}
