/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Doctor;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class DoctorAccount {
    
    private String username;
    private String password;
    private Doctor doctor;
    private Role role;
    private WorkQueue workQueue;
    private String institution;

    public DoctorAccount() {
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

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}