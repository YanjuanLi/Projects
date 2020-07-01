/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Elder.Elder;
import Business.Employee.Doctor;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class ElderAccountDirectory {
    private ArrayList<ElderAccount> elderAccountList;

    public ElderAccountDirectory() {
        elderAccountList = new ArrayList();
    }

    public ArrayList<ElderAccount> getElderAccountList() {
        return elderAccountList;
    }
    
    public ElderAccount authenticateUser(String username, String password){
        for (ElderAccount ua : elderAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public ElderAccount createElder(String username, String password, Elder elder, Role role, String institution){
        ElderAccount elderAccount = new ElderAccount();
        elderAccount.setUsername(username);
        elderAccount.setPassword(password);
        elderAccount.setElder(elder);
        elderAccount.setRole(role);
        elderAccount.setInstitution(institution);
        elderAccountList.add(elderAccount);
        return elderAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (ElderAccount ua : elderAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
     public boolean removeElderAccount(Elder elder){
        if (this.findAccount(elder)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean findAccount(Elder elder){
        String userName = elder.getName();
        ElderAccount elderAccount = null;
        for (ElderAccount ea: this.elderAccountList){
            if(ea.getUsername().equals(userName)){
                elderAccount = ea;
            }
        }
        if(elderAccount != null){
            elderAccountList.remove(elderAccount);
            return true;
        }
        return false;
    }
}
