/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Administrator;

import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class SystemAdminDirectory {
     private ArrayList<SystemAdmin> systemAdminList;

    public SystemAdminDirectory() {
        systemAdminList = new ArrayList();
    }

    public ArrayList<SystemAdmin> getSystemAdminList() {
        return systemAdminList;
    }
    
    public SystemAdmin addSystemAdmin(){
        SystemAdmin administrator = new SystemAdmin();
        this.systemAdminList.add(administrator);
        return administrator;
    }
    
    public SystemAdmin createSystemAdmin(String name){
        SystemAdmin administrator = new SystemAdmin();
        administrator.setName(name);
        systemAdminList.add(administrator);
        return administrator;
    }
}
