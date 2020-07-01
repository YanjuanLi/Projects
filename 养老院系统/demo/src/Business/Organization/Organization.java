/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Administrator.AdministratorDirectory;
import Business.Administrator.SystemAdminDirectory;
import Business.Bed.BedList;
import Business.Case.CaseDirectory;
import Business.Elder.ElderDirectory;
import Business.Employee.DoctorDirectory;
import Business.Employee.NursingWorkerDirectory;
import Business.Enterprise.NursingHouseDirectory;
import Business.Notification.NotificationDirectory;
import Business.Role.Role;
import Business.UserAccount.AdministratorAccountDirectory;
import Business.UserAccount.DoctorAccountDirectory;
import Business.UserAccount.ElderAccountDirectory;
import Business.UserAccount.NursingWorkerAccountDirectory;
import Business.UserAccount.SystemAdminAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private DoctorDirectory doctorDirectory;
    private DoctorAccountDirectory doctorAccountDirectory;
    private ElderDirectory elderDirectory;
    private ElderAccountDirectory elderAccountDirectory;
    private NursingWorkerDirectory nursingWorkerDirectory;
    private NursingWorkerAccountDirectory nursingWorkerAccountDirectory;
    private AdministratorDirectory administratorDirectory;
    private AdministratorAccountDirectory administratorAccountDirectory;
    private SystemAdminDirectory systemAdminDirectory;
    private SystemAdminAccountDirectory systemAdminAccountDirectory;
    private NotificationDirectory notificationDirectory;
    private BedList bedList;
    private NursingHouseDirectory nursingHouseDirectory;
    private CaseDirectory caseDirectory;
    
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        
        Admin("Administrator Organization"), 
        NursingWorker("Nursing Worker Organization"), 
        Doctor("Doctor"),
        Elder("Elder Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        doctorDirectory = new DoctorDirectory();
        doctorAccountDirectory = new DoctorAccountDirectory();
        elderDirectory = new ElderDirectory();
        elderAccountDirectory = new ElderAccountDirectory();
        nursingWorkerDirectory = new NursingWorkerDirectory();
        nursingWorkerAccountDirectory = new NursingWorkerAccountDirectory();
        administratorDirectory = new AdministratorDirectory();
        administratorAccountDirectory = new AdministratorAccountDirectory();
        systemAdminDirectory = new SystemAdminDirectory();
        systemAdminAccountDirectory = new SystemAdminAccountDirectory();
        notificationDirectory = new NotificationDirectory();
        bedList=new BedList();
        nursingHouseDirectory=new NursingHouseDirectory();
        caseDirectory = new CaseDirectory();
        organizationID = counter;
        ++counter;
    }

    public BedList getBedList() {
        return bedList;
    }

    public void setBedList(BedList bedList) {
        this.bedList = bedList;
    }

    public NursingHouseDirectory getNursingHouseDirectory() {
        return nursingHouseDirectory;
    }

    public void setNursingHouseDirectory(NursingHouseDirectory nursingHouseDirectory) {
        this.nursingHouseDirectory = nursingHouseDirectory;
    }

    public abstract ArrayList<Role> getSupportedRole();

    public ElderDirectory getElderDirectory() {
        return elderDirectory;
    }

    public ElderAccountDirectory getElderAccountDirectory() {
        return elderAccountDirectory;
    }

    public CaseDirectory getCaseDirectory() {
        return caseDirectory;
    }

    public void setCaseDirectory(CaseDirectory caseDirectory) {
        this.caseDirectory = caseDirectory;
    }

    
    public NursingWorkerDirectory getNursingWorkerDirectory() {
        return nursingWorkerDirectory;
    }

    public NursingWorkerAccountDirectory getNursingWorkerAccountDirectory() {
        return nursingWorkerAccountDirectory;
    }

    public NotificationDirectory getNotificationDirectory() {
        return notificationDirectory;
    }

    public void setNotificationDirectory(NotificationDirectory notificationDirectory) {
        this.notificationDirectory = notificationDirectory;
    }
    
    
    
    public DoctorAccountDirectory getDoctorAccountDirectory() {
        return doctorAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }
    
    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    public AdministratorDirectory getAdministratorDirectory() {
        return administratorDirectory;
    }

    public void setAdministratorDirectory(AdministratorDirectory administratorDirectory) {
        this.administratorDirectory = administratorDirectory;
    }

    public AdministratorAccountDirectory getAdministratorAccountDirectory() {
        return administratorAccountDirectory;
    }

    public void setAdministratorAccountDirectory(AdministratorAccountDirectory administratorAccountDirectory) {
        this.administratorAccountDirectory = administratorAccountDirectory;
    }

    public SystemAdminDirectory getSystemAdminDirectory() {
        return systemAdminDirectory;
    }

    public void setSystemAdminDirectory(SystemAdminDirectory systemAdminDirectory) {
        this.systemAdminDirectory = systemAdminDirectory;
    }

    public SystemAdminAccountDirectory getSystemAdminAccountDirectory() {
        return systemAdminAccountDirectory;
    }

    public void setSystemAdminAccountDirectory(SystemAdminAccountDirectory systemAdminAccountDirectory) {
        this.systemAdminAccountDirectory = systemAdminAccountDirectory;
    }

    
    @Override
    public String toString() {
        return name;
    }
    
    
}
