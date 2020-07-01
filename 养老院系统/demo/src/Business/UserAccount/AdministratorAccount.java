/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Administrator.Administrator;
import Business.Employee.Doctor;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Liyanjuan
 */
public class AdministratorAccount {
    private String username;
    private String password;
    private Administrator administrator;
    private Role role;
    private WorkQueue workQueue;
    private String institution;

    public AdministratorAccount() {
        workQueue = new WorkQueue();
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    

    public void setRole(Role role) {
        this.role = role;
    }

    

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
}
