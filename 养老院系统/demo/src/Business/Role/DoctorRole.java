/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.NHSystem;
import Business.Enterprise.NursingHouse;
import Business.Organization.HealthCareDOrganization;
import Business.Organization.Organization;
import Business.UserAccount.AdministratorAccount;
import Business.UserAccount.DoctorAccount;
import Business.UserAccount.ElderAccount;
import Business.UserAccount.NursingWorkerAccount;
import Business.UserAccount.SystemAdminAccount;
import userinterface.DoctorRole.DoctorWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, 
            DoctorAccount account, 
            NursingWorkerAccount nwAccount,
            AdministratorAccount adminAccount,
            ElderAccount elderAccount,
            SystemAdminAccount systemAdminAccount,
            Organization organization, 
            String s,
            NursingHouse enterprise, 
            NHSystem business) {
        return new DoctorWorkAreaJPanel(userProcessContainer, account, (HealthCareDOrganization)organization, enterprise);
    }
    
    
}
