/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

//import Dao.HospitalDao;
import Dao.DoctorDao;
import Dao.HospitalDao;
import Dao.MoutlyDao;
import Dao.PatientDao;
import Dao.ServiceDao;
import Domain.Doctor;
//import Dao.ServiceDao;
import Domain.Hospital;
//import Domain.Hospital;
import Domain.Mouthly;
import Domain.Patient;
import Domain.Service;
//import static Modle.AppointmentModel.ACCOUNT_SID;
//import static Modle.AppointmentModel.AUTH_TOKEN;
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
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author CarineU
 */
@ManagedBean
@SessionScoped
public class MouthlyModel {
   private Mouthly moudetails=new Mouthly();
    List<Mouthly> meList = new MoutlyDao().findAll(Mouthly.class);
    Mouthly mouthly = new Mouthly();
    MoutlyDao moutlyDao= new MoutlyDao();
//    private Hospital hospital= new Hospital();
//    HospitalDao hospitalDao=new HospitalDao();
//    private Doctor doctor= new Doctor();
//    DoctorDao doctorDao=new DoctorDao();
//    private Service service=new Service();
    ServiceDao serviceDao= new ServiceDao();
    HospitalDao hospitalDao= new HospitalDao();
//    private Patient patient= new Patient();
    PatientDao patientDao= new PatientDao();
    DoctorDao doctorDao= new DoctorDao();
    Integer dropPatient;
    Integer dropService;
    Integer dropDoctor;
//    List<Hospital> hos = new ArrayList<>();
    List<Service> serv= new ArrayList<>();
    List<Patient>pati= new ArrayList<>();
    List<Mouthly>mou=new ArrayList<>();
    List<Doctor>doc=new ArrayList<>();
    List<Hospital>hos= new ArrayList<>();
//    List<Doctor>dor= new ArrayList<>();
    
    String message = new String();
    String dropVillages;
    private Integer dropHospital;
    private String sms;
    public static final String ACCOUNT_SID = "AC47420e584fddd10be40ff0d375f03bc2";
    public static final String AUTH_TOKEN = "af193fad729a70c877e55683f8c50425";
    
    
    @PostConstruct
public  void  init(){
    
  meList = new MoutlyDao().findAll(Mouthly.class);
    

    }
//public void findPatient() {
//        try {
//            mou = new ArrayList<>();
//            Patient patient = new Patient();
//            List<Mouthly> ls = new MoutlyDao().findAll(Mouthly.class);
//            for (Mouthly comp : ls) {
//                if (comp.getPatient().getId().equals(dropPatient)) {
//                    mou.add(comp);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//public void findHospital() {
//        try {
//            mou = new ArrayList<>();
//            Hospital hospital = new Hospital();
//            List<Mouthly> ls = new MoutlyDao().findAll(Mouthly.class);
//            for (Mouthly comp : ls) {
//                if (comp.getHospital().getId().equals(dropHospital)) {
//                    mou.add(comp);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//   public void findDoctor() {
//        try {
//            mou = new ArrayList<>();
//            Doctor doctor = new Doctor();
//            List<Mouthly> ls = new MoutlyDao().findAll(Mouthly.class);
//            for (Mouthly comp : ls) {
//                if (comp.getDoctor().getId().equals(dropDoctor)) {
//                    mou.add(comp);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    } 
//   public void findService() {
//        try {
//            mou = new ArrayList<>();
//            Service service = new Service();
//            List<Mouthly> ls = new MoutlyDao().findAll(Mouthly.class);
//            for (Mouthly comp : ls) {
//                if (comp.getService().getId().equals(dropService)) {
//                    mou.add(comp);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
   public void create(){
       
Optional<Mouthly> available=Optional.ofNullable(mouthly);
//       if(available.isPresent()){
       if(mouthly.getAvailable()>2 )
        {       FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "the doctor is not available", null));
        }
//       mouthly.setAvailable(mouthly.getAvailable());
//      if(mouthly.getAvailable().equals(mouthly.getAvailable())){
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "The doctos is occupied,please choose other day!!", null));  
//      }  
        
        else{
       Doctor doctor= new Doctor();
       doctor.setId(dropDoctor);
       mouthly.setDoctor(doctor);
       Hospital hospital= new Hospital();
       hospital.setId(dropHospital);
       mouthly.setHospital(hospital);
Patient patient = new Patient();
        patient.setId(dropPatient);
        mouthly.setPatient(patient);
        Service service = new Service();
        service.setId(dropService);
        mouthly.setService(service);
        
    
     String sms= new MoutlyDao().save(mouthly);

        meList = new MoutlyDao().findAll(Mouthly.class);
        mouthly = new Mouthly();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(sms));
   
       }   
//       }
   }
   public void updateApp()
{
  moutlyDao=new MoutlyDao();  
//placedetails.setTypeName(message);
moutlyDao.update(moudetails);
moudetails=new Mouthly();
meList= moutlyDao.findAll(Mouthly.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
   public String fetchItems(final Mouthly pl) {
        this.moudetails = pl;
        return "editService.xhtml?faces-redirect=true";
    }
   public void deleteMouthly() {
      moutlyDao .delete(this.moudetails);
        meList=moutlyDao.findAll(Mouthly.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "App is well deleted", ""));
    }
   public void fetchAndShow(final Mouthly pl) {
        this.moudetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
   public void clearMouthlyDetails() {
        this.moudetails = null;
    }
 public List<Mouthly> view(){
     List<Mouthly> list=new MoutlyDao().findAll(Mouthly.class);
     return list;
     }

    public Mouthly getMoudetails() {
        return moudetails;
    }

    public void setMoudetails(Mouthly moudetails) {
        this.moudetails = moudetails;
    }

    public List<Mouthly> getMeList() {
        return meList;
    }

    public void setMeList(List<Mouthly> meList) {
        this.meList = meList;
    }

    public Mouthly getMouthly() {
        return mouthly;
    }

    public void setMouthly(Mouthly mouthly) {
        this.mouthly = mouthly;
    }

    public MoutlyDao getMoutlyDao() {
        return moutlyDao;
    }

    public void setMoutlyDao(MoutlyDao moutlyDao) {
        this.moutlyDao = moutlyDao;
    }
    
    

//    public Hospital getHospital() {
//        return hospital;
//    }
//
//    public void setHospital(Hospital hospital) {
//        this.hospital = hospital;
//    }
//
//    public HospitalDao getHospitalDao() {
//        return hospitalDao;
//    }
//
//    public void setHospitalDao(HospitalDao hospitalDao) {
//        this.hospitalDao = hospitalDao;
//    }

//    public Doctor getDoctor() {
//        return doctor;
//    }
//
//    public void setDoctor(Doctor doctor) {
//        this.doctor = doctor;
//    }
//
//    public DoctorDao getDoctorDao() {
//        return doctorDao;
//    }
//
//    public void setDoctorDao(DoctorDao doctorDao) {
//        this.doctorDao = doctorDao;
//    }

//    public Service getService() {
//        return service;
//    }
//
//    public void setService(Service service) {
//        this.service = service;
//    }

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public Integer getDropService() {
        return dropService;
    }

    public void setDropService(Integer dropService) {
        this.dropService = dropService;
    }

    public Integer getDropDoctor() {
        return dropDoctor;
    }

    public void setDropDoctor(Integer dropDoctor) {
        this.dropDoctor = dropDoctor;
    }

//    public List<Hospital> getHos() {
//        return hos;
//    }
//
//    public void setHos(List<Hospital> hos) {
//        this.hos = hos;
//    }

    public List<Service> getServ() {
        return serv;
    }

    public void setServ(List<Service> serv) {
        this.serv = serv;
    }

    public List<Patient> getPati() {
        return pati;
    }

    public void setPati(List<Patient> pati) {
        this.pati = pati;
    }

    public List<Mouthly> getMou() {
        return mou;
    }

    public void setMou(List<Mouthly> mou) {
        this.mou = mou;
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

    public HospitalDao getHospitalDao() {
        return hospitalDao;
    }

    public void setHospitalDao(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    public DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public List<Doctor> getDoc() {
        return doc;
    }

    public void setDoc(List<Doctor> doc) {
        this.doc = doc;
    }

    public List<Hospital> getHos() {
        return hos;
    }

    public void setHos(List<Hospital> hos) {
        this.hos = hos;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
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
            Paragraph para = new Paragraph(" App  ", font0);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(new Paragraph("\n"));
            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);

            PdfPCell cell1 = new PdfPCell(new Phrase("Doctopr", font2));
            cell1.setBorder(Rectangle.BOX);
            table.addCell(cell1);
            
            PdfPCell cell2 = new PdfPCell(new Phrase("Hospital", font2));
            cell2.setBorder(Rectangle.BOX);
            table.addCell(cell2);

//            PdfPCell cell3 = new PdfPCell(new Phrase("DOB", font2));
//            cell3.setBorder(Rectangle.BOX);
//            table.addCell(cell3);
            
             PdfPCell cell3 = new PdfPCell(new Phrase("Patient", font2));
            cell3.setBorder(Rectangle.BOX);
            table.addCell(cell3);
            
            PdfPCell cell4 = new PdfPCell(new Phrase("Service", font2));
            cell4.setBorder(Rectangle.BOX);
            table.addCell(cell4);
            
            PdfPCell cell5 = new PdfPCell(new Phrase("Day Used", font2));
            cell5.setBorder(Rectangle.BOX);
            table.addCell(cell5);
            
            PdfPCell cell6 = new PdfPCell(new Phrase("Hour Used", font2));
            cell6.setBorder(Rectangle.BOX);
            table.addCell(cell6);
            
            PdfPCell cell7 = new PdfPCell(new Phrase("Amount used", font2));
            cell7.setBorder(Rectangle.BOX);
            table.addCell(cell7);
            
            
//            PdfPCell cell5 = new PdfPCell(new Phrase("Email", font2));
//            cell5.setBorder(Rectangle.BOX);
//            table.addCell(cell5);
            PdfPCell pdfc1;
            PdfPCell pdfc2;
            PdfPCell pdfc3;
            PdfPCell pdfc4;
            PdfPCell pdfc5;
            PdfPCell pdfc6;
            PdfPCell pdfc7;
            int i = 1;
         
            for (Mouthly mem : meList) {
                pdfc1 = new PdfPCell(new Phrase(mem.getDoctor().getFirstName() ,font6));
                pdfc1.setBorder(Rectangle.BOX);
                table.addCell(pdfc1);
                
                
                pdfc2 = new PdfPCell(new Phrase(mem.getHospital().getName() ,font6));
                pdfc2.setBorder(Rectangle.BOX);
                table.addCell(pdfc2);

//                pdfc3 = new PdfPCell(new Phrase(mem.getDob(),font6));
//                pdfc3.setBorder(Rectangle.BOX);
//                table.addCell(pdfc3);
                
                pdfc3 = new PdfPCell(new Phrase(mem.getPatient().getFirstName(),font6));
                pdfc3.setBorder(Rectangle.BOX);
                table.addCell(pdfc3);
                
              pdfc4 = new PdfPCell(new Phrase(mem.getService().getName(),font6));
                pdfc4.setBorder(Rectangle.BOX);
                table.addCell(pdfc4);  
                pdfc5 = new PdfPCell(new Phrase(mem.getDay().toString(),font6));
                pdfc5.setBorder(Rectangle.BOX);
                table.addCell(pdfc5);  
                pdfc6 = new PdfPCell(new Phrase(mem.getHours(),font6));
                pdfc6.setBorder(Rectangle.BOX);
                table.addCell(pdfc6);
                pdfc7 = new PdfPCell(new Phrase(mem.getDay()*mem.getAmount() +"frw",font6));
                pdfc7.setBorder(Rectangle.BOX);
                table.addCell(pdfc7);  
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
