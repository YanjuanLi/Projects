package Business;

import Business.Administrator.Administrator;
import Business.Administrator.SystemAdmin;
import Business.Bed.Bed;
import Business.Elder.Elder;
import Business.Employee.Doctor;
import Business.Employee.NursingWorker;
import Business.Enterprise.NursingHouse;
import Business.Network.Network;
import static Business.Organization.Organization.Type.Elder;
import Business.Role.NursingWorkerRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.AdministratorAccount;
import Business.UserAccount.DoctorAccount;
import Business.UserAccount.ElderAccount;
import Business.UserAccount.NursingWorkerAccount;
import Business.UserAccount.SystemAdminAccount;
import java.util.ArrayList;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static NHSystem configure(){
        
        NHSystem system = NHSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        //Create Network
        Network n1 = system.addNetwork("network1");
        Network n2 = system.addNetwork("network2");
        
        //Create Nursing Houses
        NursingHouse nh1=n1.getNursingHouseDirectory().createAndAddNursingHouse("Sunshine", "Low Level");
        NursingHouse nh2=n2.getNursingHouseDirectory().createAndAddNursingHouse("Today", "Low Level");
        
        
        
        
        //Create system administrators
        SystemAdmin sysAdmin1 = system.getSystemAdminDirectory().createSystemAdmin("Yanjuan");
        SystemAdminAccount saa1 = system.getSystemAdminAccountDirectory().createSystemAdmin("Yanjuan", "333", sysAdmin1, new SystemAdminRole());
        
         //Create bed
        Bed bed1 = nh1.getBedList().addBed();
        bed1.setBedId(1);
        //bed1.setElderName("Elder1");
       // bed1.setNursingWorkerName("li");
        
        Bed bed2 = nh1.getBedList().addBed();
        bed2.setBedId(2);
       // bed2.setElderName("Elder2");
       // bed2.setNursingWorkerName("li");
        
        //Create elders
        Elder elder1 = nh1.getElderDirectory().createElder("Elder1","W",77,"School","liu","17803030927","lii",bed1.getBedId(),"Sunshine");
        bed1.setElderName(elder1.getName());
        bed1.setNursingWorkerName(elder1.getNursingWorkerName());
        ElderAccount ea1 =nh1.getElderAccountDirectory().createElder("Elder1", "123", elder1, new SystemAdminRole(),nh1.getName());
        Elder elder2 = nh2.getElderDirectory().createElder("Elder2","M",87,"Hospital","huang","178030307483","lii",bed1.getBedId(),"Sunshine");
        bed2.setElderName(elder2.getName());
        bed2.setNursingWorkerName(elder2.getNursingWorkerName());
        ElderAccount ea2 =nh2.getElderAccountDirectory().createElder("Elder2", "123", elder2, new SystemAdminRole(),nh1.getName());
        //Elder elder3 = nh1.getElderDirectory().createElder("Elder3","M",87,"Hospital","huang","178030307483",2,3,"Sunshine");
        //ElderAccount ea3 =nh1.getElderAccountDirectory().createElder("Elder3", "123", elder3, new SystemAdminRole(),nh1.getName());
        
       
        
        //Create nursing house administrators
        Administrator admin1 = nh1.getAdministratorDirectory().createAdministrator("Li");
        //admin1.setInstitution(nh1.getName());
        AdministratorAccount aa1 = nh1.getAdministratorAccountDirectory().createAdministrator("Li", "123", admin1, new SystemAdminRole(),nh1.getName());
        Administrator admin2 = nh2.getAdministratorDirectory().createAdministrator("Lii");
        AdministratorAccount aa2 = nh2.getAdministratorAccountDirectory().createAdministrator("Lii", "123", admin2, new SystemAdminRole(),nh2.getName());
        
        
        //Create doctors
        Doctor doctor1 = nh1.getDoctorDirectory().createDoctor("Doctor1","W",22,"Head","here");
        DoctorAccount ua1 = nh1.getDoctorAccountDirectory().createDoctor("Doctor1", "123", doctor1, new SystemAdminRole(),nh1.getName());
        Doctor doctor2 = nh1.getDoctorDirectory().createDoctor("Doctor2","W",22,"Mouth","here");
        DoctorAccount ua2 = nh1.getDoctorAccountDirectory().createDoctor("Doctor2", "123", doctor2, new SystemAdminRole(),nh1.getName());
        Doctor doctor3 = nh1.getDoctorDirectory().createDoctor("Doctor3","W",22,"Heart","here");
        DoctorAccount ua3 = nh1.getDoctorAccountDirectory().createDoctor("Doctor3", "123", doctor3, new SystemAdminRole(),nh1.getName());
        Doctor doctor4 = nh1.getDoctorDirectory().createDoctor("Doctor4","W",22,"Chest","here");
        DoctorAccount ua4 = nh1.getDoctorAccountDirectory().createDoctor("Doctor4", "123", doctor4, new SystemAdminRole(),nh1.getName());
        
        //Create nursing workers
       // NursingWorker nursingWorker = nh1.getNursingWorkerDirectory().createNursingWorker("li", "W",34, "frej", "32414543");
        //NursingWorkerAccount nwa = nh1.getNursingWorkerAccountDirectory().createNursingWorker("li", "111", nursingWorker,new NursingWorkerRole(),nh1.getName());
        
       NursingWorker nursingWorker1 = nh1.getNursingWorkerDirectory().createNursingWorker("lii", "W",34, "frej", "32414543");
        NursingWorkerAccount nwa1 = nh1.getNursingWorkerAccountDirectory().createNursingWorker("lii", "111", nursingWorker1,new NursingWorkerRole(),nh1.getName());
        
        
        
        //Create cases
        nh1.getCaseDirectory().createCase(elder1, doctor1, "12-11", "frewtgt", "frewr");
        
        ArrayList<Doctor> test = new ArrayList();
        test.add(doctor1);
        
        //Create notifications
       // nh1.getNotificationDirectory().createNotification("Test","Doctor1", 1, "doctor", "Elder1", 1, "elder");
        nh1.getNotificationDirectory().createNotification("Head", test,"Doctor","Elder1" , "Elder");
        
        return system;
    }
    
}
