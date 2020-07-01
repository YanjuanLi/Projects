 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Administrator.Administrator;
import Business.Bed.Bed;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.AdministratorAccount;

/**
 *
 * @author MyPC1
 */
public abstract class NursingHouse extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    
    private AdministratorAccount administratorAccount;
    private int status;
    private String location;
    private String scale;
    private String type;
   // private Bed bed;

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public enum EnterpriseType{
        
        MiddleEndNH("Middle End Nursing House"),
        HighEndNH("High End Nursing House"),
        LowEndNH("Low End Nursing House");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    public AdministratorAccount getAdministratorAccount() {
        return administratorAccount;
    }

    public void setAdministratorAccount(AdministratorAccount administratorAccount) {
        this.administratorAccount = administratorAccount;
    }

   

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  /*  public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }*/
    
    
    
    
    
    public NursingHouse(String name,String type){
        super(name);
        this.type=type;
        organizationDirectory=new OrganizationDirectory();
    }
}
