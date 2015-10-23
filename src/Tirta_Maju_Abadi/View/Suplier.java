/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.View.evetView.Model_view_Suplier;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;

/**
 *
 * @author bd08
 */
public class Suplier extends javax.swing.JInternalFrame {

    private Model_view_Suplier mvs;
    private MD_Supplier mds=new MD_Supplier();
    public Suplier(database db,loadAllData lad) {
        initComponents();
        mvs=new Model_view_Suplier(lad, mds, db, jList1);
        reset();
    }

    private void reset(){
        f_no_suplier.setText(mvs.reset());
        f_nama_suplier.reset();
        f_no_email.reset();
        f_no_rek1.reset();
        f_no_rek2.reset();
        f_no_telp2.reset();
        f_no_telpon1.reset();
        t_Alamat.setText("");
        
    }
    private boolean cekKosong(){
        mds.setAlamat(t_Alamat.getText());
        mds.setEmail(f_no_email.getString());
        mds.setId_supplier(f_no_suplier.getInteger());
        mds.setNama(f_nama_suplier.getString());
        mds.setNo_rekening1(f_no_rek1.getString());
        mds.setNo_rekening2(f_no_rek2.getString());
        mds.setNo_telepon1(f_no_telpon1.getString());
        mds.setNo_telepon2(f_no_telp2.getString());
        return f_no_suplier.Kosongkah()&&
                f_nama_suplier.Kosongkah()&&
                f_no_email.Kosongkah()&&
                f_no_rek1.Kosongkah()&&
                f_no_rek2.Kosongkah()&&
                f_no_telp2.Kosongkah()&&
                f_no_telpon1.Kosongkah()&&
                !t_Alamat.getText().equals("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_ = new javax.swing.JPanel();
        jl_no_suplier = new javax.swing.JLabel();
        f_no_suplier = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_suplier);
        jl_nama_suplier = new javax.swing.JLabel();
        f_nama_suplier = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_nama_suplier);
        jl_alamat = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_Alamat = new javax.swing.JTextArea();
        jl_no_telpon1 = new javax.swing.JLabel();
        f_no_telpon1 = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_telpon1);
        jl_no_telpon2 = new javax.swing.JLabel();
        jl_email = new javax.swing.JLabel();
        jl_PPN = new javax.swing.JLabel();
        jl_no_rek1 = new javax.swing.JLabel();
        jl_no_rek2 = new javax.swing.JLabel();
        f_no_telp2 = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_telpon2);
        f_no_email = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_email);
        f_no_rek1 = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_rek1);
        f_no_rek2 = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_rek2);
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jRadioButton1 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jl_.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Suplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jl_no_suplier.setText("No");

        jl_nama_suplier.setText("Nama");

        jl_alamat.setText("Alamat");

        t_Alamat.setColumns(20);
        t_Alamat.setRows(5);
        jScrollPane1.setViewportView(t_Alamat);

        jl_no_telpon1.setText("No Telepon 1");

        jl_no_telpon2.setText("No Telepon 2");

        jl_email.setText("Email");

        jl_PPN.setText("PPN");

        jl_no_rek1.setText("No Rekening 1");

        jl_no_rek2.setText("No Rekening 2");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/edit.png"))); // NOI18N
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "List Suplier", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jRadioButton1.setText("Yes");

        javax.swing.GroupLayout jl_Layout = new javax.swing.GroupLayout(jl_);
        jl_.setLayout(jl_Layout);
        jl_Layout.setHorizontalGroup(
            jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jl_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jl_Layout.createSequentialGroup()
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jl_no_rek1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_no_telpon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_no_telpon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_alamat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_nama_suplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_no_suplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_PPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jl_Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(f_nama_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f_no_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jl_Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(f_no_telpon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_telp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_rek1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_rek2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jl_Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jl_Layout.createSequentialGroup()
                        .addComponent(jl_no_rek2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jl_Layout.setVerticalGroup(
            jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jl_Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jl_Layout.createSequentialGroup()
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_no_suplier)
                            .addComponent(f_no_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nama_suplier)
                            .addComponent(f_nama_suplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_alamat)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_no_telpon1)
                            .addComponent(f_no_telpon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_no_telpon2)
                            .addComponent(f_no_telp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_email)
                            .addComponent(f_no_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_PPN)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_no_rek1)
                    .addComponent(f_no_rek1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jl_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_no_rek2)
                    .addComponent(f_no_rek2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jl_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(cekKosong()){
            mvs.insertIntoTable();
            reset();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(cekKosong()){
            mvs.updateIntoTable();
            reset();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_nama_suplier;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_email;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_rek1;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_rek2;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_suplier;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_telp2;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_telpon1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jl_;
    private javax.swing.JLabel jl_PPN;
    private javax.swing.JLabel jl_alamat;
    private javax.swing.JLabel jl_email;
    private javax.swing.JLabel jl_nama_suplier;
    private javax.swing.JLabel jl_no_rek1;
    private javax.swing.JLabel jl_no_rek2;
    private javax.swing.JLabel jl_no_suplier;
    private javax.swing.JLabel jl_no_telpon1;
    private javax.swing.JLabel jl_no_telpon2;
    private javax.swing.JTextArea t_Alamat;
    // End of variables declaration//GEN-END:variables
}
