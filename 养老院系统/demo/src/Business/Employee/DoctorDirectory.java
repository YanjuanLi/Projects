/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class DoctorDirectory {
    
    private ArrayList<Doctor> doctorList;

    public DoctorDirectory() {
        doctorList = new ArrayList();
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
    
    public Doctor addDoctor(){
        Doctor doctor = new Doctor();
        this.doctorList.add(doctor);
        return doctor;
    }
    
    public Doctor createDoctor(String name, String gender,int age,String department,String homeAddress){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setAge(age);
        doctor.setDepartment(department);
        doctor.setGender(gender);
        doctor.setHomeAddress(homeAddress);
        
        doctorList.add(doctor);
        return doctor;
    }
    public void removeDoctor(Doctor doctor){
        doctorList.remove(doctor);
    }
}