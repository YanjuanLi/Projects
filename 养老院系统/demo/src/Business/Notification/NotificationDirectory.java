/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Notification;
import Business.NHSystem;
import java.util.ArrayList;

/**
 *
 * @author Surface book
 */
public class NotificationDirectory {
    private ArrayList<Notification> NotificationList;
    private NHSystem system;

    public NotificationDirectory() {
        NotificationList = new ArrayList();
    }

    public ArrayList<Notification> getNotificationList() {
        return NotificationList;
    }
    
    public Notification addNotification(){
        Notification notification = new Notification();
        this.NotificationList.add(notification);
        return notification;
    }
    
    public void deleteNotification(Notification notification){
        NotificationList.remove(notification);
    }
    
    public Notification createNotification(String content,ArrayList receiverList,String receiverIdentity,String sender,String senderIdentity){
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setReceiverList(receiverList);
        notification.setReceiverIdentity(receiverIdentity);
        notification.setSender(sender);
        //notification.setSenderId(senderId);
        notification.setSenderIdentity(senderIdentity);
        NotificationList.add(notification);
        return notification;
    }
    
    /*public Notification createNotification(String content,String receiver, int receiverId,String receiverIdentity,String sender,int senderId,String senderIdentity){
        Notification notification = new Notification();
        notification.setContent(content);
        notification.setReceiver(receiver);
        notification.setReceiverID(receiverId);
        notification.setReceiverIdentity(receiverIdentity);
        notification.setSender(sender);
        notification.setSenderId(senderId);
        notification.setSenderIdentity(senderIdentity);
        NotificationList.add(notification);
        return notification;
    }*/
    
    public int getIssueNum(String issue){
        int count=0;
        for(Notification n: system.getNotificationDirectory().getNotificationList()){
            if(issue.equals(n.getContent())){
                count++;
            }
        }
        return count;
    }
}
