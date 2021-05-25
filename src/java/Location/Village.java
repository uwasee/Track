/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Location;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class Village {
    @Id
    
    private String Vill_Id;
private String Vill_Name;


@ManyToOne
private Cells cell;

    public String getVill_Id() {
        return Vill_Id;
    }

    public void setVill_Id(String Vill_Id) {
        this.Vill_Id = Vill_Id;
    }

    public String getVill_Name() {
        return Vill_Name;
    }

    public void setVill_Name(String Vill_Name) {
        this.Vill_Name = Vill_Name;
    }

    public Cells getCell() {
        return cell;
    }

    public void setCell(Cells cell) {
        this.cell = cell;
    }

    

    
}
