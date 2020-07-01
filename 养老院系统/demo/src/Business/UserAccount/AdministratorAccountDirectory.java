/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Administrator.Administrator;
import Business.Employee.Doctor;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class AdministratorAccountDirectory {
    private ArrayList<AdministratorAccount> administratorAccountList;

    public AdministratorAccountDirectory() {
        administratorAccountList = new ArrayList();
    }

    public ArrayList<AdministratorAccount> getAdministratorAccountList() {
        return administratorAccountList;
    }
    
    public AdministratorAccount authenticateAdministrator(String username, String password){
        for (AdministratorAccount aa : administratorAccountList)
            if (aa.getUsername().equals(username) && aa.getPassword().equals(password)){
                return aa;
            }
        return null;
    }
    
    public AdministratorAccount createAdministrator(String username, String password, Administrator administrator, Role role,String institution){
        AdministratorAccount administratorAccount = new AdministratorAccount();
        administratorAccount.setUsername(username);
        administratorAccount.setPassword(password);
        administratorAccount.setAdministrator(administrator);
        administratorAccount.setRole(role);
        administratorAccount.setInstitution(institution);
        administratorAccountList.add(administratorAccount);
        return administratorAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (AdministratorAccount ua : administratorAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
    public AdministratorAccount addAdministratorAccount(){
        AdministratorAccount aa = new AdministratorAccount();
        administratorAccountList.add(aa);
        return aa;
    }
}
