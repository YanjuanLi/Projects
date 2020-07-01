/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bed;

/**
 *
 * @author cuijingyi
 */
public class Bed {
    private int bedId;
   // private static int count = 1;
    private String elderName;
    private String nursingWorkerName;
    
    /*public Bed(){
        
        
    }*/

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedNumber) {
        this.bedId = bedNumber;
    }

    public String getElderName() {
        return elderName;
    }

    public void setElderName(String elderName) {
        this.elderName = elderName;
    }

    public String getNursingWorkerName() {
        return nursingWorkerName;
    }

    public void setNursingWorkerName(String nursingWorkerName) {
        this.nursingWorkerName = nursingWorkerName;
    }
    
     @Override
    public String toString(){
        return ""+bedId;
    }
    
    
}
