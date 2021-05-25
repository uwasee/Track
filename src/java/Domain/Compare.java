/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author User
 */
@Entity
public class Compare {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String performance;
    private Double marks1;
    private Double marks2;
    private Double marks3;
    private Double result;
    
    @ManyToOne
    private Hospital hospital;
    @ManyToOne
    private Patient patient;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public Double getMarks1() {
        return marks1;
    }

    public void setMarks1(Double marks1) {
        this.marks1 = marks1;
    }

    public Double getMarks2() {
        return marks2;
    }

    public void setMarks2(Double marks2) {
        this.marks2 = marks2;
    }

    public Double getMarks3() {
        return marks3;
    }

    public void setMarks3(Double marks3) {
        this.marks3 = marks3;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
    
    
    
    
    
}
