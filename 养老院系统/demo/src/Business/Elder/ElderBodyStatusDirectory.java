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
public class ElderBodyStatusDirectory {
        private ArrayList<ElderBodyStatus> BodystatusList;

    public ElderBodyStatusDirectory() {
        BodystatusList = new ArrayList();
    }

    public ArrayList<ElderBodyStatus> getBodystatusList() {
        return BodystatusList;
    }
    
    public ElderBodyStatus addElderBodyStatus(){
        ElderBodyStatus Bodystatus = new ElderBodyStatus();
        this.BodystatusList.add(Bodystatus);
        return Bodystatus;
    }
    
    public void deleteElderBodyStatus(ElderBodyStatus ElderBodyStatus){
        BodystatusList.remove(ElderBodyStatus);
    }
    
    public ElderBodyStatus searchElderBodyStatus(String ofWhichElder){
        for(ElderBodyStatus e: BodystatusList){
            if(e.getOfWhichElder()==ofWhichElder){
                return e;
            }
        }
        return null;
    }
    
    public ElderBodyStatus createBodyStatus(double heartRate,double spo2,double bloodpressure,String ofWhichElder){
        ElderBodyStatus ElderBodyStatus = new ElderBodyStatus();
        ElderBodyStatus.setHeartRate(heartRate);
        ElderBodyStatus.setSpo2(spo2);
        ElderBodyStatus.setBloodpressue(bloodpressure);
        BodystatusList.add(ElderBodyStatus);
        return ElderBodyStatus;
    }
}
