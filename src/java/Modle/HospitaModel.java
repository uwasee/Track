/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;
import Dao.HospitalDao;
import Domain.Email;
import Domain.Hospital;
import Domain.Patient;
import Location.Village;
import LocationDao.VillageDao;
//import java.util.ArrayList;
//import java.util.List;
//import javax.faces.context.FacesContext;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.application.FacesMessage;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
//import javax.annotation.PostConstruct;
/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class HospitaModel {
    private Hospital hosdetails=new Hospital();
    List<Hospital> hoList = new HospitalDao().findAll(Hospital.class);
    Hospital hospital = new Hospital();
    private Village village= new Village();
    VillageDao villageDao=new VillageDao();
    String message = new String();
    String dropVillages;
    Integer dropPatient;
   // private Integer totalHospital=new HospitalDao().findAllHospital().size();
    HospitalDao hoDao=new HospitalDao();
    List<Hospital> ho = new ArrayList<>();
    List<Patient> pa= new ArrayList<>();
    private String searchKey=new String();
    private Email email=new Email();
    private Integer totalkanombe=new HospitalDao().findAllHospital().size();
    private Integer totalNyirikwaya=new HospitalDao().findAllHospital1().size();
    private Integer totalCHUK=new HospitalDao().findAllHospital2().size();
    private Integer totalKibagabaga=new HospitalDao().findAllHospital3().size();
    
    public void createHospital(){
    Village village=new Village();
    village.setVill_Id(dropVillages);
    hospital.setVillage(village);
//    Patient patient= new Patient();
//    patient.setId(dropPatient);
//    hospital.setPatient(patient);
     message = new  HospitalDao().save(hospital);
     hoList = new HospitalDao().findAll(Hospital.class);
        hospital = new  Hospital();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
         
    }
    public void updateHospital()
{
  hoDao=new HospitalDao();  
//placedetails.setTypeName(message);
hoDao.update(hosdetails);
hosdetails=new Hospital();
hoList=hoDao.findAll(Hospital.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
    public String fetchItems(final Hospital pl) {
        this.hosdetails = pl;
        return "editHospital.xhtml?faces-redirect=true";
    }
    public void deleteHospital() {
       hoDao .delete(this.hosdetails);
        hoList=hoDao.findAll(Hospital.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Hospital is well deleted", ""));
    }
  public void fetchAndShow(final Hospital pl) {
        this.hosdetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
  public void clearHospitalDetails() {
        this.hosdetails = null;
    }
   public List<Hospital> view(){
     List<Hospital> list=new HospitalDao().findAll(Hospital.class);
     return list;
     } 
   public void search(){
   if(searchKey.length() > 0){
   hoList= new ArrayList<>();
   List<Hospital> placetype =  hoDao.findAll(Hospital.class);
   for(Hospital hospital : placetype){
   if(hospital.getId().toString().contains(searchKey) ){
   hoList.add(hospital);
   }
   
   }
   
   }else{
   hoList=hoDao.findAll(Hospital.class);
   }        
           
   }

 
    
    public void createoneorderPDF() {
        try {

            FacesContext context = FacesContext.getCurrentInstance();
            Document document = new Document();
            Rectangle rect = new Rectangle(20, 20, 800, 800);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            writer.setBoxSize("art", rect);
            document.setPageSize(rect);
            if (!document.isOpen()) {
                document.open();
            }
            String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("\\startbootstrap-sb-admin-2-gh-pages");
            path = path.substring(0, path.indexOf("\\build"));
            path = path + "\\web\\Photo\\images (1).png";
            Image image = Image.getInstance(path);
            image.scaleAbsolute(50, 50);
            image.setAlignment(Element.ALIGN_LEFT);
            Paragraph title = new Paragraph();
            //BEGIN page
           title.add(image);
            title.add("\n hospital");
            title.add("\n P.O. Box 3892 KIGALI - RWANDA");
            title.add("\n Email: info@hospital.gov.rw" );
            document.add(title);

            Font font0 = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.UNDERLINE);
            Font font1 = new Font(Font.FontFamily.TIMES_ROMAN, 9, Font.BOLD);
            Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font font5 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font6 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font7 = new Font(Font.FontFamily.TIMES_ROMAN, 11, Font.ITALIC);
            Font font8 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.UNDERLINE);

            document.add(new Paragraph("\n"));
            Paragraph para = new Paragraph(" Hospital List  ", font0);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(new Paragraph("\n"));
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);

            PdfPCell cell1 = new PdfPCell(new Phrase("HospitalName", font2));
            cell1.setBorder(Rectangle.BOX);
            table.addCell(cell1);
            
            PdfPCell cell2 = new PdfPCell(new Phrase("StreatRoad", font2));
            cell2.setBorder(Rectangle.BOX);
            table.addCell(cell2);

//            PdfPCell cell3 = new PdfPCell(new Phrase("DOB", font2));
//            cell3.setBorder(Rectangle.BOX);
//            table.addCell(cell3);
            
             PdfPCell cell3 = new PdfPCell(new Phrase("Village", font2));
            cell3.setBorder(Rectangle.BOX);
            table.addCell(cell3);
            
//            PdfPCell cell4 = new PdfPCell(new Phrase("Phone", font2));
//            cell4.setBorder(Rectangle.BOX);
//            table.addCell(cell4);
//            
//            PdfPCell cell5 = new PdfPCell(new Phrase("Email", font2));
//            cell5.setBorder(Rectangle.BOX);
//            table.addCell(cell5);
            PdfPCell pdfc1;
            PdfPCell pdfc2;
            PdfPCell pdfc3;
            PdfPCell pdfc4;
            PdfPCell pdfc5;
            PdfPCell pdfc6;

            int i = 1;
         
            for (Hospital mem : hoList) {
                pdfc1 = new PdfPCell(new Phrase(mem.getName() ,font6));
                pdfc1.setBorder(Rectangle.BOX);
                table.addCell(pdfc1);
                
                
                pdfc2 = new PdfPCell(new Phrase(mem.getStreetNum() ,font6));
                pdfc2.setBorder(Rectangle.BOX);
                table.addCell(pdfc2);

//                pdfc3 = new PdfPCell(new Phrase(mem.getDob(),font6));
//                pdfc3.setBorder(Rectangle.BOX);
//                table.addCell(pdfc3);
                
                pdfc3 = new PdfPCell(new Phrase(mem.getVillage().getVill_Name(),font6));
                pdfc3.setBorder(Rectangle.BOX);
                table.addCell(pdfc3);
                
            }
            document.add(table);
            Paragraph p = new Paragraph("\n\nPrinted On: " + new Date(), font1);
            p.setAlignment(Element.ALIGN_RIGHT);
            document.add(p);
            Paragraph ps = new Paragraph("\n Hospital ", font1);
            ps.setAlignment(Element.ALIGN_RIGHT);
            document.add(ps);
            document.close();
            String fileName = "Hospital Report";

            writePDFToResponse(context.getExternalContext(), baos, fileName);

            context.responseComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void writePDFToResponse(ExternalContext externalContext, ByteArrayOutputStream baos, String fileName) {
        try {
            externalContext.responseReset();
            externalContext.setResponseContentType("application/pdf");
            externalContext.setResponseHeader("Expires", "0");
            externalContext.setResponseHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
            externalContext.setResponseHeader("Pragma", "public");
            externalContext.setResponseHeader("Content-disposition", "attachment;filename=" + fileName + ".pdf");
            externalContext.setResponseContentLength(baos.size());
            OutputStream out = externalContext.getResponseOutputStream();
            baos.writeTo(out);
            externalContext.responseFlushBuffer();
        } catch (IOException e) {

        }
    }       

    public Hospital getHosdetails() {
        return hosdetails;
    }

    public void setHosdetails(Hospital hosdetails) {
        this.hosdetails = hosdetails;
    }

    public List<Hospital> getHoList() {
        return hoList;
    }

    public void setHoList(List<Hospital> hoList) {
        this.hoList = hoList;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public VillageDao getVillageDao() {
        return villageDao;
    }

    public void setVillageDao(VillageDao villageDao) {
        this.villageDao = villageDao;
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

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public HospitalDao getHoDao() {
        return hoDao;
    }

    public void setHoDao(HospitalDao hoDao) {
        this.hoDao = hoDao;
    }

    public List<Hospital> getHo() {
        return ho;
    }

    public void setHo(List<Hospital> ho) {
        this.ho = ho;
    }

    public List<Patient> getPa() {
        return pa;
    }

    public void setPa(List<Patient> pa) {
        this.pa = pa;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Integer getTotalkanombe() {
        return totalkanombe;
    }

    public void setTotalkanombe(Integer totalkanombe) {
        this.totalkanombe = totalkanombe;
    }

    public Integer getTotalNyirikwaya() {
        return totalNyirikwaya;
    }

    public void setTotalNyirikwaya(Integer totalNyirikwaya) {
        this.totalNyirikwaya = totalNyirikwaya;
    }

    public Integer getTotalCHUK() {
        return totalCHUK;
    }

    public void setTotalCHUK(Integer totalCHUK) {
        this.totalCHUK = totalCHUK;
    }

    public Integer getTotalKibagabaga() {
        return totalKibagabaga;
    }

    public void setTotalKibagabaga(Integer totalKibagabaga) {
        this.totalKibagabaga = totalKibagabaga;
    }

    
    
    
}
