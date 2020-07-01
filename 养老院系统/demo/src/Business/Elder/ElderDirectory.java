/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Elder;

import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class ElderDirectory {
    private ArrayList<Elder> elderList;

    public ElderDirectory() {
        elderList = new ArrayList();
    }

    public ArrayList<Elder> getElderList() {
        return elderList;
    }
    
    public Elder addElder(){
        Elder elder = new Elder();
        this.elderList.add(elder);
        return elder;
    }
    
    public void deleteElder(Elder elder){
        elderList.remove(elder);
    }
    
    public Elder searchElder(int id){
        for(Elder e: elderList){
            if(e.getId()==id){
                return e;
            }
        }
        return null;
    }
    
    public Elder createElder(String name, String gender, int age, String homeAddress, String childNanme, String childPhoneNumber, String nursingWorkerName, int bedId, String nursingHouse){
        Elder elder = new Elder();
        elder.setName(name);
        elder.setAge(age);
        elder.setBedId(bedId);
        elder.setContactName1(childNanme);
        elder.setPhoneNumber1(childPhoneNumber);
        elder.setGender(gender);
        elder.setHomeAddress(homeAddress);
        elder.setNursingHouse(nursingHouse);
        elder.setNursingWorkerName(nursingWorkerName);
        elderList.add(elder);
        return elder;
    }
}
