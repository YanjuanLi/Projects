/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministratorRole;

import Business.Administrator.Administrator;
import Business.Bed.Bed;
import Business.Elder.Elder;
import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author cuijingyi
 */
public class ManageEldersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageElderliesJPanel
     */
    private JPanel container;
   // private NHSystem admin;
    private NHSystem system;
    private String s;
   // private Elder elder;
    public ManageEldersJPanel(JPanel container, NHSystem system, String s) {
        initComponents();
        btnBack.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        btnAdd.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        btnDelete.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        btnView.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        this.container = container;
        this.system = system;
        this.s = s;
        txtNH.setText(s);
        txtNH.setEditable(false);
        populateElderTable();
    }

    public void refreshData(){
        this.populateElderTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
     private void populateElderTable() {
       DefaultTableModel model = (DefaultTableModel) tblElder.getModel();

        model.setRowCount(0);
        for(Network network: system.getNetworkList()){
            for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){
                if(nursingHouse.getName().equals(s)){
                    for(Elder elder : nursingHouse.getElderDirectory().getElderList()) {
            
                          Object[] row = new Object[4];
                          
                          row[0] = elder;
                          row[2] = elder.getNursingWorkerName();
                          row[1] = elder.getBedId();
                         
                          model.addRow(row);
        }  
       }
      }
     }
     }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblElder = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNH = new javax.swing.JTextField();

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setText("Manage   Elders  Information");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblElder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Bed Id", "Nursing Worker Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblElder);
        if (tblElder.getColumnModel().getColumnCount() > 0) {
            tblElder.getColumnModel().getColumn(0).setResizable(false);
            tblElder.getColumnModel().getColumn(1).setResizable(false);
            tblElder.getColumnModel().getColumn(2).setResizable(false);
        }

        btnAdd.setText("Add New Elder");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnView.setText("View Elder Information");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Elder Information");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Nursing House:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btnBack)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNH, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1)
                    .addComponent(txtNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAdd)
                .addGap(24, 24, 24)
                .addComponent(btnView)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addContainerGap(300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout cardlayout = (CardLayout) container.getLayout();
        cardlayout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        AddElderJPanel panel = new AddElderJPanel(container,system,s);
        container.add(panel);
        CardLayout cardlayout = (CardLayout) container.getLayout();
        cardlayout.next(container);  
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblElder.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Please select a row from table first to view details","Warning",JOptionPane.WARNING_MESSAGE);
        }
        else{
            Elder elder = (Elder)tblElder.getValueAt(selectedRow,0);
        ViewElderJPanel panel = new ViewElderJPanel(container,system,s,elder);
        container.add(panel);
        CardLayout cardlayout = (CardLayout) container.getLayout();
        cardlayout.next(container); 
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
         int selectedRow = tblElder.getSelectedRow();
        if (selectedRow >= 0){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null,"Would you like to delete the elder information?", "Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                
                Elder elder = (Elder)tblElder.getValueAt(selectedRow,0);
                for(Network network: system.getNetworkList()){
                   for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){
                      if(nursingHouse.getName().equals(s)){ 
                          for(Elder e:nursingHouse.getElderDirectory().getElderList()){
                              if(e==elder){
                                  elder=e;
                                  for(Bed bed : nursingHouse.getBedList().getBedList()){
                                  if(bed.getElderName().equals(e.getName())){
                                      bed.setElderName("Unknown");
                                     bed.setNursingWorkerName("Unknown");
                                  }
                              }
                              }
                              
                              
                          }
                           nursingHouse.getElderDirectory().deleteElder(elder);
                           nursingHouse.getElderAccountDirectory().removeElderAccount(elder);
                      }
                   }
                }
                populateElderTable();
                
             
        
            }
            
            
            else {
                JOptionPane.showMessageDialog(null,"Please select a row from table first","Warning",JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblElder;
    private javax.swing.JTextField txtNH;
    // End of variables declaration//GEN-END:variables
}
