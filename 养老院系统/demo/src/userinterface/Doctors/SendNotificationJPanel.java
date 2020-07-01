/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctors;

import Business.Administrator.Administrator;
import Business.Elder.Elder;
import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import Business.UserAccount.DoctorAccount;
import java.awt.CardLayout;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author Liyanjuan
 */
public class SendNotificationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SendNotificationJPanel
     */
    private JPanel container;
    private NHSystem system;
    private String receiverIdentity;
    private String institution;
    private DoctorAccount doctorAccount;
    
    public SendNotificationJPanel(JPanel container, NHSystem system,String receiverIdentity, String institution,DoctorAccount doctorAccount) {
        initComponents();
        backBtton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        sendBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        clearBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        
        this.container=container;
        this.system=system;
        this.institution=institution;
        this.receiverIdentity=receiverIdentity;
        this.doctorAccount=doctorAccount;
        nhText.setEditable(false);
        nhText.setText(institution);
        senderText.setText(doctorAccount.getDoctor().getName());
        senderText.setEditable(false);
        //receiverText.setEditable(false);
        if(receiverIdentity.equals("Elder")){
            identityLabel.setText("Elder");
           
            for(Network network:system.getNetworkList()){
                
            for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                
                if(nh.getName().equals(institution)){
                    
                    for(Elder e:nh.getElderDirectory().getElderList()){
                        IDCombox.addItem(e);
                    }
                }
            }
        }
        }else{
            identityLabel.setText("Administrator");
            for(Network network:system.getNetworkList()){
            for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                if(nh.getName().equals(institution)){
                    for(Administrator a:nh.getAdministratorDirectory().getAdministratorList()){
                        IDCombox.addItem(a);
                    }
                }
            }
        }
        }
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        senderText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        clearBtn = new javax.swing.JButton();
        sendBtn = new javax.swing.JButton();
        backBtton = new javax.swing.JButton();
        identityLabel = new javax.swing.JLabel();
        IDCombox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        nhText = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Send Notification To An");

        jLabel2.setText("Receiver:");

        jLabel3.setText("Sender:");

        jLabel4.setText("Message:");

        messageTextArea.setColumns(20);
        messageTextArea.setRows(5);
        jScrollPane1.setViewportView(messageTextArea);

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        backBtton.setText("<< Back");
        backBtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBttonActionPerformed(evt);
            }
        });

        identityLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        IDCombox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                IDComboxItemStateChanged(evt);
            }
        });
        IDCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDComboxActionPerformed(evt);
            }
        });

        jLabel5.setText("Nursing House:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(backBtton)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(senderText, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(identityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(IDCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(378, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backBtton)
                    .addComponent(identityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(senderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(IDCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearBtn)
                    .addComponent(sendBtn))
                .addContainerGap(440, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1116, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:

        //receiverText.setText("");
        messageTextArea.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
        if(messageTextArea.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill all blanks first!");
        }else{
        int senderId = doctorAccount.getDoctor().getId();
        String senderIdentity = "Doctor";
        String sender = doctorAccount.getDoctor().getName();
        
        String message = messageTextArea.getText();

       
        
        ArrayList<Elder> elderList = new ArrayList();
        ArrayList<Administrator> administratorList = new ArrayList();

        for(Network network:system.getNetworkList()){
            for(NursingHouse nh : network.getNursingHouseDirectory().getNursingHouseList()){
                if(receiverIdentity.equals("Elder")){
                    
                     Elder elder = (Elder)IDCombox.getSelectedItem();
                    for(Elder e: nh.getElderDirectory().getElderList()){
                        if(e==elder){
                            elderList.add(e);
                            nh.getNotificationDirectory().createNotification(message, elderList, receiverIdentity, sender, senderIdentity);
                            JOptionPane.showMessageDialog(null, "Send notification successfully!");
                            
                            messageTextArea.setText("");
                        }
                    }
                }else if(receiverIdentity.equals("Administrator")){
                    for(Administrator a: nh.getAdministratorDirectory().getAdministratorList()){
                         Administrator admin = (Administrator)IDCombox.getSelectedItem();
                        if(a==admin){
                            administratorList.add(a);
                            nh.getNotificationDirectory().createNotification(message, administratorList, receiverIdentity, sender, senderIdentity);
                            JOptionPane.showMessageDialog(null, "Send notification successfully!");
                            
                            messageTextArea.setText("");

                        }
                    }
                }
            }
            }
        }
    }//GEN-LAST:event_sendBtnActionPerformed

    private void backBttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBttonActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBttonActionPerformed

    private void IDComboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_IDComboxItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            
        }
    }//GEN-LAST:event_IDComboxItemStateChanged

    private void IDComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDComboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox IDCombox;
    private javax.swing.JButton backBtton;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel identityLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JTextField nhText;
    private javax.swing.JButton sendBtn;
    private javax.swing.JTextField senderText;
    // End of variables declaration//GEN-END:variables
}
