;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.OrganizationDirectory;
import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class NursingHouseDirectory {
    private ArrayList<NursingHouse> nursingHouseList;
   

    public ArrayList<NursingHouse> getNursingHouseList() {
        return nursingHouseList;
    }

    public void setNursingHouseList(ArrayList<NursingHouse> nursingHouseList) {
        this.nursingHouseList = nursingHouseList;
    }
    
    public NursingHouseDirectory(){
        nursingHouseList=new ArrayList<NursingHouse>();
    }
    public NursingHouse addNursingHouse(NursingHouse nh){
        nursingHouseList.add(nh);
        return nh;
    }
    
    public boolean checkIfNursingHouseIsUnique(String name){
        for (NursingHouse ns : nursingHouseList){
            if (ns.getName().equals(name))
                return false;
        }
        return true;
    }
    
    //Create enterprise
    public NursingHouse createAndAddNursingHouse(String name,String type){
        NursingHouse nursingHouse=null;
        if(type=="High Level"){
            nursingHouse=new HighEndNursingHouse(name,type);
            nursingHouseList.add(nursingHouse);
        }else if(type=="Middle Level"){
            nursingHouse=new MiddleEndNursingHouse(name,type);
            nursingHouseList.add(nursingHouse);
        }else{
            nursingHouse=new LowEndNursingHouse(name,type);
            nursingHouseList.add(nursingHouse);
        }
        
      
        return nursingHouse;
    }
     public void removeNursingHouse(NursingHouse nursingHouse){
        nursingHouseList.remove(nursingHouse);
    }
    
}
