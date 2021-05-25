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
public class Cells {
    @Id
    private String Cell_Id;
private String Cell_Name;

@OneToMany(mappedBy="cell",fetch=FetchType.EAGER)
List<Village>village;
@ManyToOne
private Sector sector;

    public String getCell_Id() {
        return Cell_Id;
    }

    public void setCell_Id(String Cell_Id) {
        this.Cell_Id = Cell_Id;
    }

    public String getCell_Name() {
        return Cell_Name;
    }

    public void setCell_Name(String Cell_Name) {
        this.Cell_Name = Cell_Name;
    }

    public List<Village> getVillage() {
        return village;
    }

    public void setVillage(List<Village> village) {
        this.village = village;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    

    
}
