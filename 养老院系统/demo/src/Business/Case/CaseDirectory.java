/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Case;

import Business.Elder.Elder;
import Business.Employee.Doctor;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class CaseDirectory {
    private ArrayList<Case> caseList;
    
    public CaseDirectory(){
        caseList = new ArrayList();
    }

    public ArrayList<Case> getCaseList() {
        return caseList;
    }

    public void setCaseList(ArrayList<Case> caseList) {
        this.caseList = caseList;
    }
    
    
     public Case addCase(){
        Case c = new Case();
        this.caseList.add(c);
        return c;
    }
     
     public void deleteCase(Case c){
         this.caseList.remove(c);
     }
     
     public Case createCase(Elder elder, Doctor doctor, String date, String content, String prescription){
         Case c = new Case();
         c.setElder(elder);
         c.setDoctor(doctor);
         c.setDate(date);
         
         c.setCaseContent(content);
         c.setPrescription(prescription);
         caseList.add(c);
         return c;
     }

}
