/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Administrator.Administrator;
import Business.Administrator.SystemAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class SystemAdminAccountDirectory {
     private ArrayList<SystemAdminAccount> systemAdminAccountList;

    public SystemAdminAccountDirectory() {
        systemAdminAccountList = new ArrayList();
    }

    public ArrayList<SystemAdminAccount> getSystemAdminAccountList() {
        return systemAdminAccountList;
    }
    
    public SystemAdminAccount authenticateSystemAdmin(String username, String password){
        for (SystemAdminAccount ua : systemAdminAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public SystemAdminAccount createSystemAdmin(String username, String password, SystemAdmin administrator, Role role){
        SystemAdminAccount systemAdminAccount = new SystemAdminAccount();
        systemAdminAccount.setUsername(username);
        systemAdminAccount.setPassword(password);
        systemAdminAccount.setSystemAdmin(administrator);
        systemAdminAccount.setRole(role);
        systemAdminAccountList.add(systemAdminAccount);
        return systemAdminAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (SystemAdminAccount ua : systemAdminAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}
