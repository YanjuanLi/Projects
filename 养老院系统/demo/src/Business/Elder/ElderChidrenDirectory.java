/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Elder;

import java.util.ArrayList;

/**
 *
 * @author Surface book
 */
public class ElderChidrenDirectory {
        private ArrayList<ElderChildren> elderChildrenList;

    public ElderChidrenDirectory() {
        elderChildrenList = new ArrayList();
    }

    public ArrayList<ElderChildren> getElderChildrenList() {
        return elderChildrenList;
    }
    
    public ElderChildren addElderChildren(ElderChildren elderChildren){
        this.elderChildrenList.add(elderChildren);
        return elderChildren;
    }
    
    public void deleteElderChildren(ElderChildren ElderChildren){
        elderChildrenList.remove(ElderChildren);
    }
    
    public ElderChildren searchElderChildren(String childName){
        for(ElderChildren e: elderChildrenList){
            if(e.getChildName()==childName){
                return e;
            }
        }
        return null;
    }
    
    public ElderChildren createElderChildren(String childname, long phonenumber,String identity,String ofwhichelder){
        ElderChildren ElderChildren = new ElderChildren();
        ElderChildren.setChildIdentity(identity);
        ElderChildren.setChildName(childname);
        ElderChildren.setChildPhoneNumber(phonenumber);
        ElderChildren.setOfWhichElder(ofwhichelder);
        elderChildrenList.add(ElderChildren);
        return ElderChildren;
    }
    
    public ElderChildren whichElderChildren(String keyword){
        for(ElderChildren e : elderChildrenList){
            if(e.getChildName().equals(keyword)){
                return e;
            }
        }
        return null;
    }
}
