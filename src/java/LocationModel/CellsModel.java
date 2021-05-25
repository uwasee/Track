/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LocationModel;

import Location.Cells;
import Location.Sector;
import LocationDao.CellsDao;
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
public class CellsModel {
    
    List<Cells> cellList = new CellsDao().FindAll(Cells.class);
    Cells cell = new Cells();
    String message = new String();
    String dropSec;
    List<Cells> ce = new ArrayList<>();

    public void createCell() {

        Sector sector = new Sector();
        sector.setSect_Id(dropSec);
        cell.setSector(sector);
        message = new CellsDao().save(cell);
        cellList = new CellsDao().FindAll(Cells.class);
        cell = new Cells();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }

    public void findBySector() {
        try {
            ce = new ArrayList<>();
            Sector sector = new Sector();
            List<Cells> ls = new CellsDao().FindAll(Cells.class);

            for (Cells v : ls) {
                if (v.getSector().getSect_Id().equals(dropSec)) {
                    ce.add(v);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Cells> getCellList() {
        return cellList;
    }

    public void setCellList(List<Cells> cellList) {
        this.cellList = cellList;
    }

    public Cells getCell() {
        return cell;
    }

    public void setCell(Cells cell) {
        this.cell = cell;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDropSec() {
        return dropSec;
    }

    public void setDropSec(String dropSec) {
        this.dropSec = dropSec;
    }

    public List<Cells> getCe() {
        return ce;
    }

    public void setCe(List<Cells> ce) {
        this.ce = ce;
    }

    
}
