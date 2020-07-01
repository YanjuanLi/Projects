/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.NHSystem;
import Business.Enterprise.NursingHouse;
import Business.Organization.Organization;
import Business.UserAccount.AdministratorAccount;
import Business.UserAccount.DoctorAccount;
import Business.UserAccount.ElderAccount;
import Business.UserAccount.NursingWorkerAccount;
import Business.UserAccount.SystemAdminAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        SystemAdmin("SystemAdmin"),
        Doctor("Doctor"),
        Admin("Admin"),
        Elder("Elder"),
        NursingWorker("Nursing Worker");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            DoctorAccount account, 
            NursingWorkerAccount nwAccount,
            AdministratorAccount adminAccount,
            ElderAccount elderAccount,
            SystemAdminAccount systemAdminAccount,
            Organization organization, 
            String s,
            NursingHouse enterprise, 
            NHSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}