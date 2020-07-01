/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ElderRole;

import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import Business.Notification.Notification;
import Business.UserAccount.ElderAccount;
import Business.UserAccount.NursingWorkerAccount;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.lnf.beautyeye.ch9_menu.BEMenuUI;

/**
 *
 * @author Surface book
 */
public class NotificationFrame extends javax.swing.JFrame {

    /**
     * Creates new form Notification
     */
    
    private static JPanel container;
    private static ElderAccount elderAccount;
    private static NHSystem system;
    private static String institution;
    
    public NotificationFrame(ElderAccount elderAccount, NHSystem system,String institution) {
        initComponents();
        setSize(1000, 800);
        setLocation(220,40);
        //viewBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        deleteBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        backBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));

        this.container = container;
        this.elderAccount = elderAccount;
        this.system=system;
        this.institution=institution;
        populate();
        
    }
    
     public void CloseFrame(){
        super.dispose();
    }
     
     private void populate(){
         DefaultTableModel dtm = (DefaultTableModel)notificationTable.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
            for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                if(nh.getName().equals(institution)){
                for(Notification n:nh.getNotificationDirectory().getNotificationList()){
                 if(n.getReceiverIdentity().equals("Elder")){
                      for(int i=0;i<n.getReceiverList().size();i++){
                        if(n.getReceiverList().get(i)==elderAccount.getElder()){
                            Object[] row = new Object[dtm.getColumnCount()];
                            row[0] = n;
                            
                            row[1] = n.getSenderIdentity();
                            row[2] = n.getContent();
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notificationTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Received Notifications");

        notificationTable.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        deleteBtn.setText("Delete Notification");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(195, 195, 195))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        CloseFrame();
    }//GEN-LAST:event_backBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotificationFrame(elderAccount,system,institution).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable notificationTable;
    // End of variables declaration//GEN-END:variables
}
