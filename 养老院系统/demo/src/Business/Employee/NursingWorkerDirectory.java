/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class NursingWorkerDirectory {
    private ArrayList<NursingWorker> nursingWorkerList;

    public NursingWorkerDirectory() {
        nursingWorkerList = new ArrayList();
    }

    public ArrayList<NursingWorker> getNursingWorkerList() {
        return nursingWorkerList;
    }
    
     public NursingWorker addNursingWorker(){
        NursingWorker nursingWorker = new NursingWorker();
        this.nursingWorkerList.add(nursingWorker);
        return nursingWorker;
    }
    
    public NursingWorker createNursingWorker(String name, String gender, int age, String homeAddress, String phoneNumber){
        NursingWorker nursingWorker = new NursingWorker();
        nursingWorker.setName(name);
        nursingWorker.setGender(gender);
        nursingWorker.setAge(age);
        nursingWorker.setHomeAddress(homeAddress);
        nursingWorker.setPhoneNumber(phoneNumber);
        nursingWorkerList.add(nursingWorker);
        return nursingWorker;
    }
     public void removeNursingWorker(NursingWorker nursingWorker){
        nursingWorkerList.remove(nursingWorker);
    }
}
