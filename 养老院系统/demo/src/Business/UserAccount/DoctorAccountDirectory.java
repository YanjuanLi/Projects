/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Doctor;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class DoctorAccountDirectory {
    
    private ArrayList<DoctorAccount> doctorAccountList;

    public DoctorAccountDirectory() {
        doctorAccountList = new ArrayList();
    }

    public ArrayList<DoctorAccount> getUserAccountList() {
        return doctorAccountList;
    }
    
    public DoctorAccount authenticateUser(String username, String password){
        for (DoctorAccount ua : doctorAccountList)
            if (ua.getUsername().equals(username) && ua.getPassword().equals(password)){
                return ua;
            }
        return null;
    }
    
    public DoctorAccount createDoctor(String username, String password, Doctor doctor, Role role,String institution){
        DoctorAccount userAccount = new DoctorAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
        userAccount.setDoctor(doctor);
        userAccount.setRole(role);
        userAccount.setInstitution(institution);
        doctorAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (DoctorAccount ua : doctorAccountList){
            if (ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
    
     public boolean removeDoctorAccount(Doctor doc){
        if (this.findAccount(doc)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean findAccount(Doctor doc){
        String userName = doc.getName();
        DoctorAccount doctorAccount = null;
        for (DoctorAccount da: this.doctorAccountList){
            if(da.getUsername().equals(userName)){
                doctorAccount = da;
            }
        }
        if(doctorAccount != null){
            doctorAccountList.remove(doctorAccount);
            return true;
        }
        return false;
    }
    public void removeDA(DoctorAccount da){
        doctorAccountList.remove(da);
    }
}
