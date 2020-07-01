/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Notification;

import java.util.ArrayList;

/**
 *
 * @author Surface book
 */
public class Notification {
    private String sender;
    private String senderIdentity;
    private int senderID;
    
    private String receiver;
    private String receiverIdentity;
    private int receiverID;
    private ArrayList receiverList;
    
    private String content;
    
    private int id;
    private static int count = 1;
    
    public Notification() {
        id = count;
        count++;
        receiverList = new ArrayList();
    }

    public int getId() {
        return id;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getsenderID() {
        return senderID;
    }

    public void setsenderID(int senderID) {
        this.senderID = senderID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSenderIdentity() {
        return senderIdentity;
    }

    public void setSenderIdentity(String senderIdentity) {
        this.senderIdentity = senderIdentity;
    }

    public int getSenderId() {
        return senderID;
    }

    public void setSenderId(int senderID) {
        this.senderID = senderID;
    }

    public String getReceiverIdentity() {
        return receiverIdentity;
    }

    public void setReceiverIdentity(String receiverItentity) {
        this.receiverIdentity = receiverItentity;
    }

    public int getReceiverId() {
        return receiverID;
    }

    public void setReceiverId(int receiverID) {
        this.receiverID = receiverID;
    }

    public ArrayList getReceiverList() {
        return receiverList;
    }

    public void setReceiverList(ArrayList receiverList) {
        this.receiverList = receiverList;
    }

    
   
     @Override
    public String toString() {
        return sender;
    }
    
}
