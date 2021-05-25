/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

//import Dao.CompareDao;
import Dao.HospitalDao;
import Dao.PatientDao;
//import Dao.PatientDao;
import Dao.ServiceDao;
//import Domain.Compare;
import Domain.Email;
import Domain.Hospital;
import Domain.Patient;
import Domain.Service;
//import Location.Village;
//import LocationDao.VillageDao;
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
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class ServiceModel {
    private Service serdetails=new Service();
    List<Service> seList = new ServiceDao().findAll(Service.class);
    Service service = new Service();
//    private Hospital hospital= new Hospital();
    HospitalDao hospitalDao=new HospitalDao();
    PatientDao patientDao= new PatientDao();
    String message = new String();
    String dropVillages;
    private Integer dropHospital;
    private Integer totalService=new ServiceDao().findAllService().size();
    private Integer totalServicek=new ServiceDao().findAllServicek().size();
    private Integer totalGeneral=new ServiceDao().findAllGeneral().size();
    private Integer totDental=new ServiceDao().findAllServiceKibagabaga().size();
    private Integer totGeneral=new ServiceDao().findAllGeneralNyirinkwaya().size();
    private Integer totChuk=new ServiceDao().findAllGeneralCHUK().size();
    private Integer totkano= new ServiceDao().findAll().size();
    private Integer tot=new ServiceDao().findAll2().size();
    private Integer totped= new ServiceDao().findAll3().size();
    private Integer totdet=new ServiceDao().findAllki4().size();
    private Integer totg=new ServiceDao().findAllki5().size();
    private Integer totp=new ServiceDao().findAllki6().size();
    private Integer totpch=new ServiceDao().findAllki7().size();
    private Integer totpsch=new ServiceDao().findAllki8().size();
    private Integer totgch=new ServiceDao().findAllki9().size();
    private Integer totdch=new ServiceDao().findAllki10().size();
    //private Integer totKanomb=new ServiceDao().findAll4().size();
    Integer dropPatient;
    Integer dropService;
    Integer dropDoctor;
    ServiceDao serDao=new ServiceDao();
    List<Hospital> ho = new ArrayList<>();
    List<Service> ser= new ArrayList<>();
    List<Patient>pat= new ArrayList<>();
    private String searchKey=new String();
  private  Email email=new Email();
    @PostConstruct
public  void  init(){
    
  seList = new ServiceDao().findAll(Service.class);
    

    }
public void findPatient() {
        try {
            ser = new ArrayList<>();
            Patient patient = new Patient();
            List<Service> ls = new ServiceDao().findAll(Service.class);
            for (Service comp : ls) {
                if (comp.getPatient().getId().equals(dropPatient)) {
                    ser.add(comp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
public void findHospital() {
        try {
            ser = new ArrayList<>();
            Hospital hospital = new Hospital();
            List<Service> ls = new ServiceDao().findAll(Service.class);
            for (Service comp : ls) {
                if (comp.getHospital().getId().equals(dropHospital)) {
                    ser.add(comp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void createService(){
    Hospital hospital = new Hospital();
        hospital.setId(dropHospital);
        service.setHospital(hospital);
        Patient patient = new Patient();
        patient.setId(dropPatient);
        service.setPatient(patient);
    
     message= new ServiceDao().save(service);
//     String Email=service.getEmail();
//        email.from("info@hospital.gov.rw");
//        email.to(Email);
//        email.subject("message");
//        email.text(" Dear"+" "+service.getName()+ " "+patient.getFirstName()+" "+patient.getLastName()+ " "+"your are welcome ");
//        email.send();
        seList = new ServiceDao().findAll(Service.class);
        service = new Service();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(message));
    
    }
    public void updateService()
{
  serDao=new ServiceDao();  
//placedetails.setTypeName(message);
serDao.update(serdetails);
serdetails=new Service();
seList=serDao.findAll(Service.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
    public String fetchItems(final Service pl) {
        this.serdetails = pl;
        return "editService.xhtml?faces-redirect=true";
    }
    public void deleteService() {
       serDao .delete(this.serdetails);
        seList=serDao.findAll(Service.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Service is well deleted", ""));
    }
    public void fetchAndShow(final Service pl) {
        this.serdetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
 public void clearServiceDetails() {
        this.serdetails = null;
    }
 public List<Service> view(){
     List<Service> list=new ServiceDao().findAll(Service.class);
     return list;
     }
 public void search(){
   if(searchKey.length() > 0){
   seList= new ArrayList<>();
   List<Service> placetype =  serDao.findAll(Service.class);
   for(Service patient : placetype){
   if(patient.getId().toString().contains(searchKey) ){
   seList.add(patient);
   }
   
   }
   
   }else{
   seList=serDao.findAll(Service.class);
   }
           
           
           
           
   }
    

    public Service getSerdetails() {
        return serdetails;
    }

    public void setSerdetails(Service serdetails) {
        this.serdetails = serdetails;
    }

    public List<Service> getSeList() {
        return seList;
    }

    public void setSeList(List<Service> seList) {
        this.seList = seList;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

//    public Hospital getHospital() {
//        return hospital;
//    }
//
//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }

    public HospitalDao getHospitalDao() {
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
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

    public Integer getDropHospital() {
        return dropHospital;
    }

    public void setDropHospital(Integer dropHospital) {
        this.dropHospital = dropHospital;
    }

    public ServiceDao getSerDao() {
        return serDao;
    }

    public void setSerDao(ServiceDao serDao) {
        this.serDao = serDao;
    }

    public List<Hospital> getHo() {
        return ho;
    }

    public void setHo(List<Hospital> ho) {
        this.ho = ho;
    }

    public List<Service> getSer() {
        return ser;
    }

    public void setSer(List<Service> ser) {
        this.ser = ser;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public List<Patient> getPat() {
        return pat;
    }

    public void setPat(List<Patient> pat) {
        this.pat = pat;
    }

    public Integer getTotalService() {
        return totalService;
    }

    public void setTotalService(Integer totalService) {
        this.totalService = totalService;
    }

    public Integer getTotalGeneral() {
        return totalGeneral;
    }

    public void setTotalGeneral(Integer totalGeneral) {
        this.totalGeneral = totalGeneral;
    }

    public Integer getTotDental() {
        return totDental;
    }

    public void setTotDental(Integer totDental) {
        this.totDental = totDental;
    }

    public Integer getTotGeneral() {
        return totGeneral;
    }

    public void setTotGeneral(Integer totGeneral) {
        this.totGeneral = totGeneral;
    }

    public Integer getTotalServicek() {
        return totalServicek;
    }

    public void setTotalServicek(Integer totalServicek) {
        this.totalServicek = totalServicek;
    }
    

    public Integer getTotChuk() {
        return totChuk;
    }

    public void setTotChuk(Integer totChuk) {
        this.totChuk = totChuk;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Integer getDropService() {
        return dropService;
    }

    public void setDropService(Integer dropService) {
        this.dropService = dropService;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
    
    

//    public Integer getTotKanomb() {
//        return totKanomb;
//    }
//
//    public void setTotKanomb(Integer totKanomb) {
//        this.totKanomb = totKanomb;
//    }
//    

    public Integer getTotkano() {
        return totkano;
    }

    public void setTotkano(Integer totkano) {
        this.totkano = totkano;
    }

    public Integer getTot() {
        return tot;
    }

    public void setTot(Integer tot) {
        this.tot = tot;
    }

    public Integer getTotped() {
        return totped;
    }

    public void setTotped(Integer totped) {
        this.totped = totped;
    }

    public Integer getTotdet() {
        return totdet;
    }

    public void setTotdet(Integer totdet) {
        this.totdet = totdet;
    }

    public Integer getTotg() {
        return totg;
    }

    public void setTotg(Integer totg) {
        this.totg = totg;
    }

    public Integer getTotp() {
        return totp;
    }

    public void setTotp(Integer totp) {
        this.totp = totp;
    }

    public Integer getTotpch() {
        return totpch;
    }

    public void setTotpch(Integer totpch) {
        this.totpch = totpch;
    }

    public Integer getTotpsch() {
        return totpsch;
    }

    public void setTotpsch(Integer totpsch) {
        this.totpsch = totpsch;
    }

    public Integer getTotgch() {
        return totgch;
    }

    public void setTotgch(Integer totgch) {
        this.totgch = totgch;
    }

    public Integer getTotdch() {
        return totdch;
    }

    public void setTotdch(Integer totdch) {
        this.totdch = totdch;
    }

    public Integer getDropDoctor() {
        return dropDoctor;
    }

    public void setDropDoctor(Integer dropDoctor) {
        this.dropDoctor = dropDoctor;
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
            Paragraph para = new Paragraph(" Service  ", font0);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(new Paragraph("\n"));
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            PdfPCell cell1 = new PdfPCell(new Phrase("Patient", font2));
            cell1.setBorder(Rectangle.BOX);
            table.addCell(cell1);
            
            PdfPCell cell2 = new PdfPCell(new Phrase("Hospital", font2));
            cell2.setBorder(Rectangle.BOX);
            table.addCell(cell2);

//            PdfPCell cell3 = new PdfPCell(new Phrase("DOB", font2));
//            cell3.setBorder(Rectangle.BOX);
//            table.addCell(cell3);
            
             PdfPCell cell3 = new PdfPCell(new Phrase("Service", font2));
            cell3.setBorder(Rectangle.BOX);
            table.addCell(cell3);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("Floor", font2));
            cell4.setBorder(Rectangle.BOX);
            table.addCell(cell4);
            
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
         
            for (Service mem : seList) {
                pdfc1 = new PdfPCell(new Phrase(mem.getPatient().getFirstName() ,font6));
                pdfc1.setBorder(Rectangle.BOX);
                table.addCell(pdfc1);
                
                
                pdfc2 = new PdfPCell(new Phrase(mem.getHospital().getName() ,font6));
                pdfc2.setBorder(Rectangle.BOX);
                table.addCell(pdfc2);

//                pdfc3 = new PdfPCell(new Phrase(mem.getDob(),font6));
//                pdfc3.setBorder(Rectangle.BOX);
//                table.addCell(pdfc3);
                
                pdfc3 = new PdfPCell(new Phrase(mem.getName(),font6));
                pdfc3.setBorder(Rectangle.BOX);
                table.addCell(pdfc3);
                
              pdfc4 = new PdfPCell(new Phrase(mem.getFloor(),font6));
                pdfc4.setBorder(Rectangle.BOX);
                table.addCell(pdfc4);  
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
        
    
}
