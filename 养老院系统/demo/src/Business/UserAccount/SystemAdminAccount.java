/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Administrator.Administrator;
import Business.Administrator.SystemAdmin;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Liyanjuan
 */
public class SystemAdminAccount {
    private String username;
    private String password;
    private SystemAdmin systemAdmin;
    private Role role;
    private WorkQueue workQueue;

    public SystemAdminAccount() {
        workQueue = new WorkQueue();
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

    public SystemAdmin getSystemAdmin() {
        return systemAdmin;
    }

    public void setSystemAdmin(SystemAdmin administrator) {
        this.systemAdmin = administrator;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
}
