/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.NursingHouseDirectory;

/**
 *
 * @author MyPC1
 */
public class Network {
    private String name;
    private NursingHouseDirectory nursingHouseDirectory;
    private int uncomfortableAmount;
    
    public Network(){
        nursingHouseDirectory=new NursingHouseDirectory();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NursingHouseDirectory getNursingHouseDirectory() {
        return nursingHouseDirectory;
    }

    public int getUncomfortableAmount() {
        return uncomfortableAmount;
    }

    public void setUncomfortableAmount(int uncomfortableAmount) {
        this.uncomfortableAmount = uncomfortableAmount;
    }
    
    
    @Override
    public String toString(){
        return name;
    }
    
}
