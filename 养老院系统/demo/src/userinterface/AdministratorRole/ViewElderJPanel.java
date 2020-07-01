/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministratorRole;

import Business.Administrator.Administrator;
import Business.Bed.Bed;
import Business.Elder.Elder;
import Business.Elder.ElderChildren;
import Business.Elder.ElderDirectory;
import Business.Employee.NursingWorker;
import Business.Enterprise.NursingHouse;
import Business.NHSystem;
import Business.Network.Network;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

/**
 *
 * @author cuijingyi
 */
public class ViewElderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddElderJPanel
     */
    private JPanel container;
    private Elder elder;
    private NHSystem system;
    private String s;
    public ViewElderJPanel(JPanel container, NHSystem system,String s,Elder elder) {
        initComponents();
        btnBack.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        btnSave.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        btnUpdate.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        addContact.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        DeleteContact.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        
        this.container = container;
        this.system = system;
        this.s =s ;
        this.elder=elder;
        Cname.setEditable(false);
        Cidentity.setEditable(false);
        CphoneNum.setEditable(false);
        txtNH.setText(s);
        txtNH.setEditable(false);
        populateTable();
         for (Network network : system.getNetworkList()) {
            
            for (NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()) {
                if(nursingHouse.getName().equals(s)){
                    for(Elder e : nursingHouse.getElderDirectory().getElderList()){
                        if(e==elder){
                            
                        }
                            
                    }
                }
            }
         }
                            txtName.setText(elder.getName());
                            txtAge.setText(String.valueOf(elder.getAge()));
                            txtGender.setText(elder.getGender());
                            txtHA.setText(elder.getHomeAddress());
                            pfPW.setText(elder.getPassword());
                            cbbNWId.addItem(elder.getNursingWorkerName());
                            cbbBedId.addItem(elder.getBedId());
                            
                            txtName.setEditable(false);
                            txtAge.setEditable(false);
                            txtGender.setEditable(false);
                            txtHA.setEditable(false);
                            pfPW.setEditable(false);
                            cbbNWId.setEditable(false);
                            cbbBedId.setEditable(false);
                            
                            btnSave.setEnabled(false);
                            addContact.setEnabled(false);
                            DeleteContact.setEnabled(false);
    }
    
    private void populateTable() {
       // System.out.println("I am in populate table");
        //System.out.println("s:"+s);
        DefaultTableModel model = (DefaultTableModel) contactTable.getModel();
        model.setRowCount(0);
        //System.out.println("network list size:"+system.getNetworkList().size());
        for(Network network: system.getNetworkList()){
          //  System.out.println("nursing house list size:"+ network.getNursingHouseDirectory().getNursingHouseList().size());
            for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){
            //    System.out.println("nursingHouse.getName():"+nursingHouse.getName());
                if(nursingHouse.getName().equals(s)){
              //      System.out.println("elder :"+ elder.getChildrenDirectory().getElderChildrenList().size());
                    for(ElderChildren ec : elder.getChildrenDirectory().getElderChildrenList()) {
                        if(ec.getOfWhichElder().equals(elder.getName())){
                          Object[] row = new Object[3];
                          row[0] = ec.getChildName();
                          row[1] = ec.getChildIdentity();
                          row[2] = ec.getChildPhoneNumber();                      
                          model.addRow(row);
                        }
        }  
       }
      }
     }
    }
    
     private void populateCombox(){
        for(Network network: system.getNetworkList()){
            for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){
                if(nursingHouse.getName().equals(s)){
                  for(NursingWorker nursingWorker : nursingHouse.getNursingWorkerDirectory().getNursingWorkerList()){
                           cbbNWId.addItem(nursingWorker);
                }
              }
            }
        }
       for(Network network: system.getNetworkList()){
            for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){
                if(nursingHouse.getName().equals(s)){
                  for(Bed bed : nursingHouse.getBedList().getBedList()){
                          if(bed.getElderName().equals("Unknown")){
                           cbbBedId.addItem(bed.getBedId());
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

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtHA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pfPW = new javax.swing.JPasswordField();
        cbbNWId = new javax.swing.JComboBox();
        cbbBedId = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        contactTable = new javax.swing.JTable();
        Cname = new javax.swing.JTextField();
        Cidentity = new javax.swing.JTextField();
        CphoneNum = new javax.swing.JTextField();
        Cname1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addContact = new javax.swing.JButton();
        DeleteContact = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setText("View Elder Information");

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Name:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Gender:");

        txtGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenderActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Home Address:");

        txtHA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHAActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setText("Age:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Password:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Nursing House:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Nursing Worker Name:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Bed Id:");

        contactTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Identity", "PhoneNum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(contactTable);
        if (contactTable.getColumnModel().getColumnCount() > 0) {
            contactTable.getColumnModel().getColumn(0).setResizable(false);
            contactTable.getColumnModel().getColumn(1).setResizable(false);
            contactTable.getColumnModel().getColumn(2).setResizable(false);
            contactTable.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        Cname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CnameActionPerformed(evt);
            }
        });

        Cidentity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CidentityActionPerformed(evt);
            }
        });

        Cname1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Cname1.setText("Contact Name:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Contact Identity:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Contact PhoneNum:");

        addContact.setText("Add Contact Person");
        addContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactActionPerformed(evt);
            }
        });

        DeleteContact.setText("Delete Contact Person");
        DeleteContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteContactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(247, 247, 247))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnUpdate)
                        .addGap(286, 286, 286))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addContact, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(DeleteContact, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)
                                            .addComponent(Cname1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(Cname, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                                    .addComponent(Cidentity)))
                                            .addComponent(CphoneNum)))
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(txtGender)
                                    .addComponent(txtHA, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(txtAge)
                                    .addComponent(pfPW)
                                    .addComponent(cbbNWId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbBedId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNH)
                                        .addGap(3, 3, 3)))))))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1)
                    .addComponent(txtNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(pfPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbNWId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbBedId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cname1))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cidentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CphoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addContact)
                    .addComponent(DeleteContact))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnSave))
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout cardlayout = (CardLayout) container.getLayout();
        cardlayout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenderActionPerformed

    private void txtHAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHAActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
              txtName.setEditable(false);
              txtAge.setEditable(true);
              txtGender.setEditable(false);
              txtHA.setEditable(true);
              pfPW.setEditable(false);
              Cname.setEditable(true);
              Cidentity.setEditable(true);
              CphoneNum.setEditable(true);              
              for (Network network : system.getNetworkList()) {
                 for (NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()) {
                   if(nursingHouse.getName().equals(s)){
                        for(Bed bed: nursingHouse.getBedList().getBedList()){
                            if((Integer)cbbBedId.getSelectedItem() == bed.getBedId()){
                               bed.setElderName("");
                               bed.setNursingWorkerName("");
                     }
                   }
                }
               }
              }
              cbbNWId.removeAllItems();
              cbbBedId.removeAllItems();
              populateCombox();
              
              btnSave.setEnabled(true);
              addContact.setEnabled(true);
              DeleteContact.setEnabled(true);
              btnUpdate.setEnabled(false); 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
       // txtElderID.setText(String.valueOf(elder.getId()));
         for (Network network : system.getNetworkList()) {
            
            for (NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()) {
                if(nursingHouse.getName().equals(s)){
                    for(Elder e : nursingHouse.getElderDirectory().getElderList()){
                        if(e==elder){
                            if(Integer.parseInt(txtAge.getText())<60|| Integer.parseInt(txtAge.getText())>120){
                              JOptionPane.showMessageDialog(null,"The age random of doctor shoule between 60 and 120"); 
                           }else{ 
                            e.setName(txtName.getText());
                        
                          
                          int age = Integer.parseInt(txtAge.getText());
                          e.setAge(Integer.parseInt(txtAge.getText()));   
                          e.setGender(txtGender.getText());
                          e.setHomeAddress(txtHA.getText());
                          e.setPassword(String.valueOf(pfPW.getPassword()));
                        
                         for(Bed bed: nursingHouse.getBedList().getBedList()){
                            if((Integer)cbbBedId.getSelectedItem() == bed.getBedId()){
                               bed.setElderName(e.getName());
                               bed.setNursingWorkerName(e.getNursingWorkerName());
                     }
                 }
                            }
                          e.setNursingWorkerName((String)cbbNWId.getSelectedItem());                 
                          e.setBedId((Integer)cbbBedId.getSelectedItem());
                        }   
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Elder Information Updated Successfully");
        txtName.setEditable(false);
        txtAge.setEditable(false);
        txtGender.setEditable(false);
        txtHA.setEditable(false);
        pfPW.setEditable(false);
        cbbNWId.setEditable(false);
        cbbBedId.setEditable(false);
        cbbNWId.removeAllItems();
        cbbBedId.removeAllItems();
        populateCombox();
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true); 
        populateTable();
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void CnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CnameActionPerformed

    private void CidentityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CidentityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CidentityActionPerformed

    private void addContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addContactActionPerformed
        for(Network network: system.getNetworkList()){
            for(NursingHouse nursingHouse : network.getNursingHouseDirectory().getNursingHouseList()){ 
               if(nursingHouse.getName().equals(s)){
                    Pattern p = Pattern.compile("^\\d{10}$");
                 Matcher m = p.matcher(CphoneNum.getText());
                 boolean b = m.matches();
       if( b == false){
            JOptionPane.showMessageDialog(null, "The form of Phone Number should be 10 digit");
        }else{
                 elder.getChildrenDirectory().createElderChildren(Cname.getText(), Long.valueOf(CphoneNum.getText()), Cidentity.getText(), elder.getName());
       }
                }
            }
        }
        populateTable();  
    }//GEN-LAST:event_addContactActionPerformed

    private void DeleteContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteContactActionPerformed
        // TODO add your handling code here:
        int row=contactTable.getSelectedRow();
        String s=(String)contactTable.getValueAt(row, 0);
        ElderChildren elderChildren=elder.getChildrenDirectory().whichElderChildren(s);
        elder.getChildrenDirectory().deleteElderChildren(elderChildren);
        populateTable();

    }//GEN-LAST:event_DeleteContactActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cidentity;
    private javax.swing.JTextField Cname;
    private javax.swing.JLabel Cname1;
    private javax.swing.JTextField CphoneNum;
    private javax.swing.JButton DeleteContact;
    private javax.swing.JButton addContact;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cbbBedId;
    private javax.swing.JComboBox cbbNWId;
    private javax.swing.JTable contactTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPasswordField pfPW;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHA;
    private javax.swing.JTextField txtNH;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
