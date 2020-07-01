/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Bed;

import java.util.ArrayList;

/**
 *
 * @author cuijingyi
 */
public class BedList {
    private ArrayList<Bed> bedList;
    public BedList(){
        bedList = new ArrayList<Bed>();
    }

    public ArrayList<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(ArrayList<Bed> bedList) {
        this.bedList = bedList;
    }
    
    public Bed addBed(){
        Bed bed = new Bed();
        this.bedList.add(bed);
        return bed;
    }
    
    public Bed createBed(int bedId,String elderName,String nursingWorkerName){
        Bed bed = new Bed();
        bed.setBedId(bedId);
        bed.setElderName(elderName);
        bed.setNursingWorkerName(nursingWorkerName);
        bedList.add(bed);
        return bed;
    }
    
    public void removeBed(Bed bed){
        bedList.remove(bed);
    }
}
