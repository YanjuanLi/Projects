/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Case;

import Business.Elder.Elder;
import Business.Employee.Doctor;

/**
 *
 * @author Liyanjuan
 */
public class Case {
    private int id;
    private static int count = 1;
   
    private Elder elder;
    private Doctor doctor;
    
    private String date;
    private String caseContent;
    private String prescription;
    
    public Case(){
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

   
    
    
    public void setDate(String date) {
        this.date = date;
    }

   

    public String getCaseContent() {
        return caseContent;
    }

    public void setCaseContent(String caseContent) {
        this.caseContent = caseContent;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Elder getElder() {
        return elder;
    }

    public void setElder(Elder elder) {
        this.elder = elder;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
   
    
    
    
    
     @Override
    public String toString() {
        return date;
    }
}
