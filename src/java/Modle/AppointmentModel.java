/*
 * To chxange this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import Dao.AppointmentDao;
import Dao.DoctorDao;
//import Dao.HospitalDao;
import Dao.PatientDao;
import Domain.Appointment;
import Domain.Doctor;
//import Domain.Hospital;
import Domain.Patient;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
//import Domain.Service;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author CarineU
 */
@ManagedBean
@SessionScoped
public class AppointmentModel {
    private Appointment appdetails=new Appointment();
    List<Appointment> appList = new AppointmentDao().findAll(Appointment.class);
    Appointment appointment = new Appointment();
//    private Hospital hospital= new Hospital();
    PatientDao patientDao=new PatientDao();
    DoctorDao docDao=new DoctorDao();
    //List<Hospital> ho = new ArrayList<>();
    List<Doctor> dor= new ArrayList<>();
    List<Patient>pat= new ArrayList<>();
    //List<Service>se= new ArrayList<>();
    Integer dropPatient;
    Integer dropDoctor;
    String message = new String();
    private String sms;
    public static final String ACCOUNT_SID = "AC47420e584fddd10be40ff0d375f03bc2";
    public static final String AUTH_TOKEN = "af193fad729a70c877e55683f8c50425";
    
    
    public void createAppointment(){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(appointment.getPhoneNumber()),
                new com.twilio.type.PhoneNumber("+13475073429"), "You have booked a place").create(); 
         System.out.println(message.getSid());
        
//        if(appointment.getAvailable()>2 )
//        {       FacesContext facesContext = FacesContext.getCurrentInstance();
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "the doctor is not available", null));
//        }
//        
//        else{
        
        Doctor doctor=new Doctor();
        doctor.setId(dropDoctor);
        appointment.setDoctor(doctor);
        Patient patient=new Patient();
        patient.setId(dropPatient);
        appointment.setPatient(patient);
        
    
    String sms = new AppointmentDao().save(appointment);
    
    appList = new AppointmentDao().findAll(Appointment.class);
        appointment = new Appointment();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.addMessage(null, new FacesMessage(sms));
        
    }

    public Appointment getAppdetails() {
        return appdetails;
    }

    public void setAppdetails(Appointment appdetails) {
        this.appdetails = appdetails;
    }

    public List<Appointment> getAppList() {
        return appList;
    }

    public void setAppList(List<Appointment> appList) {
        this.appList = appList;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public PatientDao getPatientDao() {
        return patientDao;
    }

    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    public DoctorDao getDocDao() {
        return docDao;
    }

    public void setDocDao(DoctorDao docDao) {
        this.docDao = docDao;
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

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public Integer getDropDoctor() {
        return dropDoctor;
    }

    public void setDropDoctor(Integer dropDoctor) {
        this.dropDoctor = dropDoctor;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    
    
    
    
    
}
