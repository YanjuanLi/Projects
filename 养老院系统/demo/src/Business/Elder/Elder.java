/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Elder;

/**
 *
 * @author Liyanjuan
 */
public class Elder {
    private String name;
    private int id;
    private static int count = 1;
    
    private String password;
    private int age;
    private String gender;
    private String homeAddress;
    private String contactName1;
    private String phoneNumber1;
    private String identity1;
    private String contactName2;
    private String phoneNumber2;
    private String identity2;
    private int nursingWorkerId;
    private int bedId;
    private String NursingHouse;
    private String phoneNumber;
    private ElderBodyStatusDirectory elderBodyStatusDirectory;
     private ElderChidrenDirectory childrenDirectory;
     private String nursingWorkerName;
    

    public Elder() {
        id = count;
        elderBodyStatusDirectory=new ElderBodyStatusDirectory();
        childrenDirectory=new ElderChidrenDirectory();
        count++;
    }

    public String getNursingWorkerName() {
        return nursingWorkerName;
    }

    public void setNursingWorkerName(String nursingWorkerName) {
        this.nursingWorkerName = nursingWorkerName;
    }

    
    public ElderBodyStatusDirectory getElderBodyStatusDirectory() {
        return elderBodyStatusDirectory;
    }

    public ElderChidrenDirectory getChildrenDirectory() {
        return childrenDirectory;
    }

    public void setChildrenDirectory(ElderChidrenDirectory childrenDirectory) {
        this.childrenDirectory = childrenDirectory;
    }
    

    public void setElderBodyStatusDirectory(ElderBodyStatusDirectory elderBodyStatusDirectory) {
        this.elderBodyStatusDirectory = elderBodyStatusDirectory;
    }
    

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   


    
    public int getNursingWorkerId() {
        return nursingWorkerId;
    }

    public void setNursingWorkerId(int nursingWorkerId) {
        this.nursingWorkerId = nursingWorkerId;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getNursingHouse() {
        return NursingHouse;
    }

    public void setNursingHouse(String NursingHouse) {
        this.NursingHouse = NursingHouse;
    }

    public String getContactName1() {
        return contactName1;
    }

    public void setContactName1(String contactName1) {
        this.contactName1 = contactName1;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public String getIdentity1() {
        return identity1;
    }

    public void setIdentity1(String identity1) {
        this.identity1 = identity1;
    }

    public String getContactName2() {
        return contactName2;
    }

    public void setContactName2(String contactName2) {
        this.contactName2 = contactName2;
    }

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getIdentity2() {
        return identity2;
    }

    public void setIdentity2(String identity2) {
        this.identity2 = identity2;
    }
    
    
    
}
