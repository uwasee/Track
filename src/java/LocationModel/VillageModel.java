/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationModel;

import Location.Cells;
import Location.Village;
import LocationDao.VillageDao;
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
public class VillageModel {
    List<Village> villages = new VillageDao().FindAll(Village.class);
    Village village = new Village();
    List<Village> villageList = new ArrayList<>();
    String dropCell;

    public void createVillage() {
        Cells cell = new Cells();
        cell.setCell_Id(dropCell);
        village.setCell(cell);
        String message = new VillageDao().save(village);
        villages = new VillageDao().FindAll(Cells.class);
        village = new Village();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public void findByCell() {
        try {
            villageList = new ArrayList<>();
            Cells cell = new Cells();
            List<Village> ls = new VillageDao().FindAll(Village.class);

            for (Village v : ls) {
                if (v.getCell().getCell_Id().equals(dropCell)) {
                    villageList.add(v);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Village> getVillages() {
        return villages;
    }

    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public List<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(List<Village> villageList) {
        this.villageList = villageList;
    }

    public String getDropCell() {
        return dropCell;
    }

    public void setDropCell(String dropCell) {
        this.dropCell = dropCell;
    }

   
}
