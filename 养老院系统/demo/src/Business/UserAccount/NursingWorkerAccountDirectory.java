/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Elder.Elder;
import Business.Employee.NursingWorker;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class NursingWorkerAccountDirectory {
     private ArrayList<NursingWorkerAccount> nursingWorkerAccountList;

    public NursingWorkerAccountDirectory() {
        nursingWorkerAccountList = new ArrayList();
    }

    public ArrayList<NursingWorkerAccount> getNursingWorkerAccountList() {
        return nursingWorkerAccountList;
    }
    
    public NursingWorkerAccount authenticateUser(String username, String password){
        for (NursingWorkerAccount ua : nursingWorkerAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public NursingWorkerAccount createNursingWorker(String username, String password, NursingWorker nursingWorker, Role role,String institution){
        NursingWorkerAccount nursingWorkerAccount = new NursingWorkerAccount();
        nursingWorkerAccount.setUsername(username);
        nursingWorkerAccount.setPassword(password);
        nursingWorkerAccount.setNursingWorker(nursingWorker);
        nursingWorkerAccount.setRole(role);
        nursingWorkerAccount.setInstitution(institution);
        nursingWorkerAccountList.add(nursingWorkerAccount);
        
        return nursingWorkerAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (NursingWorkerAccount ua : nursingWorkerAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    public boolean removeNursingWorkerAccount(NursingWorker nursingWorker){
        if (this.findAccount(nursingWorker)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean findAccount(NursingWorker nursingWorker){
        String userName = nursingWorker.getName();
        NursingWorkerAccount nursingWorkerAccount = null;
        for (NursingWorkerAccount nw: this.nursingWorkerAccountList){
            if(nw.getUsername().equals(userName)){
                nursingWorkerAccount = nw;
            }
        }
        if(nursingWorkerAccount != null){
            nursingWorkerAccountList.remove(nursingWorkerAccount);
            return true;
        }
        return false;
    }
}
