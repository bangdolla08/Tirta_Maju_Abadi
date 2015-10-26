/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.View.evetView.View_penjualan_po;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Tirta_Maju_Abadi.View.evetView.View_pengiriman_po;

/**
 *
 * @author NEEZAR
 */
public class Pengiriman_po extends javax.swing.JInternalFrame {
    private MD_Penjualan_po mpel=new MD_Penjualan_po();
    private View_penjualan_po vpp;
    private View_pengiriman_po vkirpo;
    private database db;
    private listMD_Penjualan_po lppo;
    private Date date=new Date();
    private loadAllData ld;
    private loadAllData lad;
    private View_pengiriman_po kirimpo;
    private MD_Pelanggan mdpelanngan;
    /**
     * Creates new form NewJInternalFrame
     */
    public Pengiriman_po() {
        initComponents();
    }
    
    public void reset(){
        f_no_po.setText("");
        c_supplier.setSelectedItem("--Pilih--");
        c_nama_barang.setSelectedItem("--Pilih--");
        f_banyak.setText("");
    }
    public Pengiriman_po(loadAllData lad) {
        this.lad=lad;
        initComponents();        
        vkirpo=new View_pengiriman_po(t_pengiriman_bo.getModel(), lppo, db);
        t_pengiriman_bo.setModel(vpp.getdtm());
//        vpp.list(c_nama_barang);
//        vpp.list(c_supplier);
    }
    
      public void list(ModelChuser mc){
        List<list2Values> list=new ArrayList<>();
        for(MD_Produk mp:ld.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
    private void setMpel(){
        mpel.setNo_nota(f_no_po.getText());
        int brg=Integer.valueOf(c_nama_barang.getSelectedItemS());
        mpel.setId_pelanggan(brg);
    }
    
     public void tambah(){
        list2Values ls=(list2Values)c_nama_barang.getSelectedItem();
        MD_Full_penjualan mdfbb=new MD_Full_penjualan(ls.getIsinya(), f_no_po.getInteger(), f_banyak.toString(),lad);
        vpp.set_TableBawah(mdfbb,mdpelanngan.getId_Pelanggan());                                                                                                     
        mpel.listMD_Full_penjualan(mdfbb);                                                                            
    }           
    /**ge\
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_nopo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        f_no_po = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_nopo);
        c_supplier = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        l_bnyak = new javax.swing.JLabel();
        f_banyak = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_bnyak);
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_pengiriman_bo = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        c_nama_barang = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        jButton3 = new javax.swing.JButton();

        l_nopo.setText("No PO");

        jLabel2.setText("Supplier");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Tabel Pengiriman BO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel3.setText("Nama Barang");

        l_bnyak.setText("Banyak");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton1.setText("Tambahkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t_pengiriman_bo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama Barang", "Banyak"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_pengiriman_bo);
        if (t_pengiriman_bo.getColumnModel().getColumnCount() > 0) {
            t_pengiriman_bo.getColumnModel().getColumn(0).setResizable(false);
            t_pengiriman_bo.getColumnModel().getColumn(0).setPreferredWidth(5);
            t_pengiriman_bo.getColumnModel().getColumn(1).setResizable(false);
            t_pengiriman_bo.getColumnModel().getColumn(1).setPreferredWidth(250);
            t_pengiriman_bo.getColumnModel().getColumn(2).setResizable(false);
            t_pengiriman_bo.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/cetak.png"))); // NOI18N
        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/Reset.png"))); // NOI18N
        jButton3.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_bnyak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_bnyak)
                    .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(c_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(l_nopo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(c_supplier, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(f_no_po, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nopo)
                    .addComponent(f_no_po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tambah();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(c_nama_barang.equals("Galon")){
            kirimpo.simpan_produkGalon();
        }
        else{
            vpp.simpanpenjulanpo();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_nama_barang;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_supplier;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_banyak;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_po;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_bnyak;
    private javax.swing.JLabel l_nopo;
    private javax.swing.JTable t_pengiriman_bo;
    // End of variables declaration//GEN-END:variables
}
