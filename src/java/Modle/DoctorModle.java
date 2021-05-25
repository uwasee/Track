/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.DoctorDao;
import Dao.HospitalDao;
import Dao.LoginDao;
//import Dao.PatientDao;
import Dao.ServiceDao;
//import Dao.ServiceDao;
import Domain.Doctor;
import Domain.Hospital;
import Domain.Login;
import Domain.Patient;
import Domain.Service;
//import Domain.Service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author CarineU
 */
@ManagedBean
@SessionScoped
public class DoctorModle {
   private Doctor docdetails=new Doctor();
    List<Doctor> docList = new DoctorDao().findAll(Doctor.class);
    Doctor doctor = new Doctor();
    private Hospital hospital= new Hospital();
    HospitalDao hospitalDao=new HospitalDao();
    DoctorDao docDao=new DoctorDao();
    List<Hospital> ho = new ArrayList<>();
    List<Doctor> dor= new ArrayList<>();
    List<Patient>pat= new ArrayList<>();
    List<Service>se= new ArrayList<>();
     private String searchKey=new String();
    String message = new String();
    String dropVillages; 
    Integer dropHospital;
    Integer dropPatient;
    Integer dropService;
    private Login login=new Login();
    LoginDao loginDao=new LoginDao();
    //private Hospital hospital=new Hospital();
    private Service service= new Service();
    ServiceDao serviceDao=new ServiceDao();
//    private Service service= new Service();
//    ServiceDao serviceDao= new ServiceDao();
    @PostConstruct
public  void  init(){
    
  docList = new DoctorDao().findAll(Doctor.class);
    

    }
public void see() {
        Login sss = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session");
      String  orgname = sss.getUsername();
        Login ur = (Login) new LoginDao().findbyId(Login.class, orgname);
  Login uu=new Login();
  uu.setUsername(orgname);
 
      
    }
public List<Doctor> v(){
    Login sss = (Login) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("session");
    String  orgname = sss.getUsername();
   Login ur = (Login) new LoginDao().findbyId(Login.class, orgname);
  Login uu=new Login();
  uu.setUsername(orgname);
    List<Doctor> ls = new LoginDao().searchCustomer(uu);
    return ls;
    }

    
    public void createDoctor(){
        if(doctor.getAvailable()>5 )
        {       FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "the doctor not available", null));
        }
        
        else{
    
    login.setPassword(login.getPassword());
        login.setRoleType("Doctor");
        loginDao=new LoginDao();
        loginDao.save2(login);
        doctor.setLogin(login);
        Hospital hospital = new Hospital();
        hospital.setId(dropHospital);
        doctor.setHospital(hospital);
        Service service = new Service();
        service.setId(dropService);
        doctor.setService(service);
        
        
        
       message = new DoctorDao().save(doctor);
    
    docList = new DoctorDao().findAll(Doctor.class);
        doctor = new Doctor();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(message));
    
        }
    
    }
     public void updateDoctor()
{
  docDao=new DoctorDao();  
//placedetails.setTypeName(message);
docDao.update(docdetails);
docdetails=new Doctor();
docList= docDao.findAll(Doctor.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
     public String fetchItems(final Doctor pl) {
        this.docdetails = pl;
        return "editDoctor.xhtml?faces-redirect=true";
    }
     public void deleteDoctor() {
       docDao .delete(this.docdetails);
        docList=docDao.findAll(Doctor.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Doctor is well deleted", ""));
    }
     public void fetchAndShow(final Doctor pl) {
        this.docdetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
     public void clearDoctorDetails() {
        this.docdetails = null;
    }
     public List<Doctor> view(){
     List<Doctor> list=new DoctorDao().findAll(Doctor.class);
     return list;
     }
     public void search(){
   if(searchKey.length() > 0){
   docList= new ArrayList<>();
   List<Doctor> placetype =  docDao.findAll(Doctor.class);
   for(Doctor patient : placetype){
   if(patient.getId().toString().contains(searchKey) ){
   docList.add(patient);
   }
   
   }
   
   }else{
   docList=docDao.findAll(Doctor.class);
   }
           
           
           
           
   }

    public Doctor getDocdetails() {
        return docdetails;
    }

    public void setDocdetails(Doctor docdetails) {
        this.docdetails = docdetails;
    }

    public List<Doctor> getDocList() {
        return docList;
    }

    public void setDocList(List<Doctor> docList) {
        this.docList = docList;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

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

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceDao getServiceDao() {
        return serviceDao;
    }

    public void setServiceDao(ServiceDao serviceDao) {
        this.serviceDao = serviceDao;
    }

    

    
    public List<Hospital> getHo() {
        return ho;
    }

    public void setHo(List<Hospital> ho) {
        this.ho = ho;
    }

    public List<Doctor> getDor() {
        return dor;
    }

    public void setDor(List<Doctor> dor) {
        this.dor = dor;
    }

    public List<Patient> getPat() {
        return pat;
    }

    public void setPat(List<Patient> pat) {
        this.pat = pat;
    }

    public List<Service> getSe() {
        return se;
    }

    public void setSe(List<Service> se) {
        this.se = se;
    }

    public Integer getDropService() {
        return dropService;
    }

    public void setDropService(Integer dropService) {
        this.dropService = dropService;
    }

    
    
    
}
