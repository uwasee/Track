/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

//import Dao.HospitalDao;
//import Dao.HospitalDao;
import Dao.LoginDao;
import Dao.PatientDao;
import Domain.Email;
//import Domain.Hospital;
import Domain.Login;
import Domain.Patient;
//import Domain.Service;
//import Location.Village;
//import LocationDao.VillageDao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
//import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class PatientModel {
    Patient patient = new Patient();
    String message = new String();
    String dropVillages;
    Integer dropService;
    Integer dropHospital;
    Integer dropPatient;
    PatientDao patientDao= new PatientDao();
    private Login login= new Login();
    LoginDao loginDao=new LoginDao();
    List<Patient>patientList=new ArrayList<>();
//    List<Hospital> hoList = new ArrayList<>();
//    List<Service> serviceList= new ArrayList<>();
    List<Patient> pasList = new PatientDao().findAll(Patient.class);
    private Patient pasdetails=new Patient();
    private String searchKey=new String();
    private Email email=new Email();
    
    @PostConstruct
public  void  init(){
    
  pasList = new PatientDao().findAll(Patient.class);
    
    }
    
    public void createPatient(){
    
        login.setPassword(login.getPassword());
        login.setRoleType("Patient");
        loginDao=new LoginDao();
        loginDao.save2(login);
        patient.setLogin(login);
       message = new PatientDao().save(patient);
       String Email=patient.getEmail();
        email.from("info@hospital.gov.rw");
        email.to(Email);
        email.subject("message");
        email.text(" Dear"+" "+patient.getFirstName()+ " "+patient.getLastName()+" "+"your search map hospital has been successful ");
        email.send();
         pasList = new PatientDao().findAll(Patient.class);

        patient = new Patient();
FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    
    
    }
    public void updatePatient()
{
  patientDao=new PatientDao();  
//placedetails.setTypeName(message);
patientDao.update(pasdetails);
pasdetails=new Patient();
pasList=patientDao.findAll(Patient.class);
FacesContext ct = FacesContext.getCurrentInstance();
ct.addMessage(null, new FacesMessage("Updated!"));
}
    public String fetchItems(final Patient pl) {
        this.pasdetails = pl;
        return "editPatient.xhtml?faces-redirect=true";
    }
    public void deletePatient() {
       patientDao .delete(this.pasdetails);
        pasList=patientDao.findAll(Patient.class);
        FacesContext ct = FacesContext.getCurrentInstance();
        ct.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Patient is well deleted", ""));
    }
 public void fetchAndShow(final Patient pl) {
        this.pasdetails = pl;
        RequestContext.getCurrentInstance().execute("PF('delete').show()");
    }
 public void clearPatientDetails() {
        this.pasdetails = null;
    }
 public List<Patient> view(){
     List<Patient> list=new PatientDao().findAll(Patient.class);
     return list;
     }
 public void search(){
   if(searchKey.length() > 0){
   pasList= new ArrayList<>();
   List<Patient> placetype =  patientDao.findAll(Patient.class);
   for(Patient patient : placetype){
   if(patient.getId().toString().contains(searchKey) ){
   pasList.add(patient);
   }
   
   }
   
   }else{
   pasList=patientDao.findAll(Patient.class);
   }
           
           
           
           
   }
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public Integer getDropService() {
        return dropService;
    }

    public void setDropService(Integer dropService) {
        this.dropService = dropService;
    }

    public Integer getDropHospital() {
        return dropHospital;
    }

    public void setDropHospital(Integer dropHospital) {
        this.dropHospital = dropHospital;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Patient> getPasList() {
        return pasList;
    }

    public void setPasList(List<Patient> pasList) {
        this.pasList = pasList;
    }

    public Patient getPasdetails() {
        return pasdetails;
    }

    public void setPasdetails(Patient pasdetails) {
        this.pasdetails = pasdetails;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
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

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
    
    
}
