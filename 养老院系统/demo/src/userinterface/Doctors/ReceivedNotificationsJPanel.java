/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Doctors;

import Business.Employee.Doctor;
import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import Business.Notification.Notification;
import Business.UserAccount.DoctorAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author Liyanjuan
 */
public class ReceivedNotificationsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReceivedNotificationsJPanel
     */
    private JPanel container;
    private NHSystem system;
    private String institution;
    private DoctorAccount doctorAccount;
    
    public ReceivedNotificationsJPanel(JPanel container,NHSystem system,String institution,DoctorAccount doctorAccount) {
        initComponents();
        backBtn1.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        deleteBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        this.container=container;
        this.system=system;
        this.institution=institution;
        this.doctorAccount=doctorAccount;
        nhText.setEditable(false);
        nhText.setText(institution);
        populate();
    }

    private void populate(){
        DefaultTableModel dtm = (DefaultTableModel)notificationTable.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
            for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                if(nh.getName().equals(institution)){
                for(Notification n:nh.getNotificationDirectory().getNotificationList()){
                    if(n.getReceiverIdentity().equals("Doctor")){
                      
                    
                    for(int i=0;i<n.getReceiverList().size();i++){
                        if(n.getReceiverList().get(i)==doctorAccount.getDoctor()){
                              Object[] row = new Object[dtm.getColumnCount()];
                              
                              row[0] = n.getSender();
                              row[1] = n.getSenderIdentity();
                              row[2]=n.getContent();
            
                              dtm.addRow(row);
                        }
                    }
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

        backBtn1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nhText = new javax.swing.JTextField();

        backBtn1.setText("<< Back");
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        notificationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Sender Identity", "Content"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(notificationTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Received Notifications");

        deleteBtn.setText("Delete Notification");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Nursing House:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(backBtn1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(194, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(backBtn1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(deleteBtn)
                .addContainerGap(195, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtn1ActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = notificationTable.getSelectedRow();
        if(selectedRow>=0){
            int selectionResult = JOptionPane.showConfirmDialog(null,"Are you sure to delete this elder?");
            if(selectionResult == JOptionPane.YES_OPTION){
                Notification notification = (Notification)notificationTable.getValueAt(selectedRow, 0);
                for(Network network:system.getNetworkList()){
                    for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                        if(nh.getName().equals(institution)){
                            nh.getNotificationDirectory().deleteNotification(notification);
                        }
                    }
                }

                populate();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a notification!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn1;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nhText;
    private javax.swing.JTable notificationTable;
    // End of variables declaration//GEN-END:variables
}
