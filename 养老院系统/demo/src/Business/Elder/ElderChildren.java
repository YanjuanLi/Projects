/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Elder;

/**
 *
 * @author Surface book
 */

public class ElderChildren {
private String childIdentity;
private long childPhoneNumber; 
private String childName;
private String ofWhichElder;

    public String getOfWhichElder() {
        return ofWhichElder;
    }

    public void setOfWhichElder(String ofWhichElder) {
        this.ofWhichElder = ofWhichElder;
    }


    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getChildIdentity() {
        return childIdentity;
    }

    public void setChildIdentity(String childIdentity) {
        this.childIdentity = childIdentity;
    }

    public long getChildPhoneNumber() {
        return childPhoneNumber;
    }

    public void setChildPhoneNumber(long childPhoneNumber) {
        this.childPhoneNumber = childPhoneNumber;
    }


}
