/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.NursingWorkers;

import Business.Elder.Elder;
import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import Business.UserAccount.ElderAccount;
import Business.UserAccount.NursingWorkerAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author Liyanjuan
 */
public class ManageEldersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEldersJPanel
     */
    private JPanel container;
    private NursingWorkerAccount nursingWorkerAccount;
    private String institution;
    private NHSystem system;
    
    public ManageEldersJPanel(JPanel container,NursingWorkerAccount nursingWorkerAccount,String institution,NHSystem system){
        initComponents();
        backBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        deleteBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        viewBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        viewFamilyBtn.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        this.container=container;
        this.nursingWorkerAccount=nursingWorkerAccount;
        this.institution=institution;
        this.system=system;
        nhText.setEditable(false);
        nhText.setText(institution);
        
        populate();
      
    }

    private void populate(){
         DefaultTableModel dtm = (DefaultTableModel)eldersTable.getModel();
        dtm.setRowCount(0);
        for(Network network:system.getNetworkList()){
            for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                if(nh.getName().equals(institution)){
                 for(Elder e:nh.getElderDirectory().getElderList()){
                     
                  if(e.getNursingWorkerName().equals(nursingWorkerAccount.getNursingWorker().getName())){
                      
                  Object[] row = new Object[dtm.getColumnCount()];
                  
                  row[0] = e;
                  row[1] = e.getGender();
                  row[2] = e.getAge();
                  row[3] = e.getBedId();
                 
                 
                 dtm.addRow(row);
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
        backBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eldersTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        viewBtn = new javax.swing.JButton();
        viewFamilyBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        nhText = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Manage Elders");

        backBtn.setText("<< Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        eldersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Gender", "Age", "Bed ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(eldersTable);

        deleteBtn.setText("Delete Elder");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        viewBtn.setText("View Physiological States");
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        viewFamilyBtn.setText("View Family Contact Info");
        viewFamilyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFamilyBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Nursing House:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(backBtn)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewFamilyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel1)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn)
                    .addComponent(jLabel2)
                    .addComponent(nhText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(deleteBtn)
                .addGap(18, 18, 18)
                .addComponent(viewBtn)
                .addGap(18, 18, 18)
                .addComponent(viewFamilyBtn)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = eldersTable.getSelectedRow();
        if(selectedRow>=0){
            int selectionResult = JOptionPane.showConfirmDialog(null,"Are you sure to delete this elder?");
            if(selectionResult == JOptionPane.YES_OPTION){
                Elder elder = (Elder)eldersTable.getValueAt(selectedRow, 0);
                for(Network network:system.getNetworkList()){
                    for(NursingHouse nh:network.getNursingHouseDirectory().getNursingHouseList()){
                        if(nh.getName().equals(institution)){
                            for(Elder e : nh.getElderDirectory().getElderList()){
                                if(e==elder){
                                    e.setNursingWorkerId(0);
                                }
                            }
                        }
                    }
                }
                
                populate();
            }
        }else{
             JOptionPane.showMessageDialog(null, "Please select an elder!");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = eldersTable.getSelectedRow();
        if(selectedRow>=0){
            
            
                Elder elder = (Elder)eldersTable.getValueAt(selectedRow, 0);
                
                ViewPhysiologicalStatesJPanel panel = new ViewPhysiologicalStatesJPanel(container,elder,system,institution);
                container.add("ViewPhysiologicalStatesJPanel",panel);
                CardLayout layout =(CardLayout)container.getLayout();
                layout.next(container);
            
        }else{
             JOptionPane.showMessageDialog(null, "Please select an elder!");
        }
       
        
    }//GEN-LAST:event_viewBtnActionPerformed

    private void viewFamilyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFamilyBtnActionPerformed
        // TODO add your handling code here:
         int selectedRow = eldersTable.getSelectedRow();
        if(selectedRow>=0){
            
            
                Elder elder = (Elder)eldersTable.getValueAt(selectedRow, 0);
                
                ViewFamilyContactInfoJPanel panel = new ViewFamilyContactInfoJPanel(container,system,elder);
                container.add("ViewFamilyContactJPanel",panel);
                CardLayout layout =(CardLayout)container.getLayout();
                layout.next(container);
            
        }else{
             JOptionPane.showMessageDialog(null, "Please select an elder!");
        }
    }//GEN-LAST:event_viewFamilyBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable eldersTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nhText;
    private javax.swing.JButton viewBtn;
    private javax.swing.JButton viewFamilyBtn;
    // End of variables declaration//GEN-END:variables
}
