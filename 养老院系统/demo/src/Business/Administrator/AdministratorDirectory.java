/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Administrator;

import Business.Elder.Elder;
import java.util.ArrayList;

/**
 *
 * @author Liyanjuan
 */
public class AdministratorDirectory {
    private ArrayList<Administrator> administratorList;

    public AdministratorDirectory() {
        administratorList = new ArrayList();
    }

    public ArrayList<Administrator> getAdministratorList() {
        return administratorList;
    }
    
    public Administrator addAdministrator(){
        Administrator administrator = new Administrator();
        this.administratorList.add(administrator);
        return administrator;
    }
    
    public Administrator createAdministrator(String name){
        Administrator administrator = new Administrator();
        administrator.setName(name);
        administratorList.add(administrator);
        return administrator;
    }
}
