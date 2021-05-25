/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

//import Dao.CompareDao;
import Dao.CompareDao;
import Domain.Compare;
import Domain.Hospital;
import Domain.Patient;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
public class CompareModel {
    Compare compare = new Compare();
    private Integer dropPatient;
    private Integer dropHospital;
    CompareDao compareDao = new CompareDao();
    List<Compare> compareList = new ArrayList<>();
   // List<Judger> judgerList = new ArrayList<>();
    List<Patient> patientList = new ArrayList<>();
    List<Compare> listcompare = new CompareDao().findAll(Compare.class);
    //List<Voted> listVoted = new VotedDao().findAll(Voted.class);
    private Compare compdetail=new  Compare();
    private String searchKey=new String();

    List<Compare> hospital1= new CompareDao().view("from Compare c WHERE c.hospital.name='kanombe'");
    List<Compare> hospital2= new CompareDao().view("from Compare c WHERE c.hospital.name='kibagabaga'");

    Integer hosp1 = hospital1.size();
    Integer hosp2 = hospital2.size();
    Integer total = listcompare.size();
    
    @PostConstruct
public  void  init(){
    
  listcompare = new CompareDao().findAll(Compare.class);
    

    }
         

    public void findPatient() {
        try {
            patientList = new ArrayList<>();
            Patient patient = new Patient();
            List<Compare> ls = new CompareDao().findAll(Compare.class);
            for (Compare comp : ls) {
                if (comp.getPatient().getId().equals(dropPatient)) {
                    compareList.add(comp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void findHospital() {
        try {
            compareList = new ArrayList<>();
            Hospital hospital = new Hospital();
            List<Compare> ls = new CompareDao().findAll(Compare.class);
            for (Compare comp : ls) {
                if (comp.getHospital().getId().equals(dropHospital)) {
                    compareList.add(comp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
   
//    public void fetchVotes(){
//    Candidate candidate=  new CandidateDao().findbyId(Candidate.class, dropCandidates);
//    totalVotes=candidate.getVotes();
//    System.out.println(totalVotes);
//    }
    
 public void createCompare(){
 
// if(compare.getMarks1()>100||compare.getMarks2()>100||compare.getMarks3()>100 )
//        {       FacesContext facesContext = FacesContext.getCurrentInstance();
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Marks can not be greater than 100!", null));
//        }
        
//        else{
            
//            double finalVotes=(totalVotes*100)/view().size();
            

        Hospital hospital = new Hospital();
        hospital.setId(dropHospital);
        compare.setHospital(hospital);

        Patient patient = new Patient();
        patient.setId(dropPatient);
        compare.setPatient(patient);
//        compare.setResult(((compare.getMarks1()+compare.getMarks2()+compare.getMarks3())*100)/300);
//       compare.setPerformance(compare.getResult().toString());
        compareDao.save2(compare);
        listcompare = new CompareDao().findAll(Compare.class);

        compare = new Compare();
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved!", null));
//        }
 
 } 

    public Compare getCompare() {
        return compare;
    }

    public void setCompare(Compare compare) {
        this.compare = compare;
    }

    public Integer getDropPatient() {
        return dropPatient;
    }

    public void setDropPatient(Integer dropPatient) {
        this.dropPatient = dropPatient;
    }

    public Integer getDropHospital() {
        return dropHospital;
    }

    public void setDropHospital(Integer dropHospital) {
        this.dropHospital = dropHospital;
    }

    public CompareDao getCompareDao() {
        return compareDao;
    }

    public void setCompareDao(CompareDao compareDao) {
        this.compareDao = compareDao;
    }

    public List<Compare> getCompareList() {
        return compareList;
    }

    public void setCompareList(List<Compare> compareList) {
        this.compareList = compareList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Compare> getListcompare() {
        return listcompare;
    }

    public void setListcompare(List<Compare> listcompare) {
        this.listcompare = listcompare;
    }

    public Compare getCompdetail() {
        return compdetail;
    }

    public void setCompdetail(Compare compdetail) {
        this.compdetail = compdetail;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public List<Compare> getHospital1() {
        return hospital1;
    }

    public void setHospital1(List<Compare> hospital1) {
        this.hospital1 = hospital1;
    }

    public List<Compare> getHospital2() {
        return hospital2;
    }

    public void setHospital2(List<Compare> hospital2) {
        this.hospital2 = hospital2;
    }

    public Integer getHosp1() {
        return hosp1;
    }

    public void setHosp1(Integer hosp1) {
        this.hosp1 = hosp1;
    }

    public Integer getHosp2() {
        return hosp2;
    }

    public void setHosp2(Integer hosp2) {
        this.hosp2 = hosp2;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    
 
    
}


