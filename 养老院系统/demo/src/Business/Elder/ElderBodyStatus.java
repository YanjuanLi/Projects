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

public class ElderBodyStatus {
private double spo2;
private double heartRate; 
private double bloodpressue;
private String ofWhichElder;



    public double getSpo2() {
        return spo2;
    }

    public void setSpo2(double spo2) {
        this.spo2 = spo2;
    }

    public double getBloodpressue() {
        return bloodpressue;
    }

    public void setBloodpressue(double bloodpressue) {
        this.bloodpressue = bloodpressue;
    }
    
    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }


    public String getOfWhichElder() {
        return ofWhichElder;
    }

    public void setOfWhichElder(String ofWhichElder) {
        this.ofWhichElder = ofWhichElder;
    }

    

}
