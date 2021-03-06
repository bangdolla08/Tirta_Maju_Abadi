package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Harga_pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.View.evetView.Model_view_Pelanggan;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import javax.swing.JTable;


public class Pelanggan extends javax.swing.JInternalFrame {

    private Model_view_Pelanggan mvp;
    private database db;
    private loadAllData lad;
    private MD_Pelanggan mp=new MD_Pelanggan();
    public Pelanggan(database db,loadAllData lad) {
        initComponents();
        this.db=db;
        this.lad=lad;
        mvp=new Model_view_Pelanggan(t_Harga.getModel(), L_nama_pelanggan, this.db,lad , mp);
        mp.list(c_type_pelanggan);
        setNamaProduk();
        reset();
    }
    private void setNamaProduk(){
        for(MD_Produk tmpMp:lad.getListMD_Produk().getAll()){
            C_nama_produk.addItem(tmpMp);
        }
    }
    
    private void reset(){
        mvp.reset();
        t_Harga.setModel(mvp.getDTM());
        L_nama_pelanggan.setModel(mvp.getDTL());
        f_id_pelanggan.setText(mvp.getnextID());
        tex_area_alamat.setText("");
        f_nama.reset();
        f_no_telepon.reset();
        resetFull();
        flipflop(true);
    }
    private void resetFull(){
        f_harga.reset();
        C_nama_produk.setSelectedIndex(0);        
    }
    private void setMD_pelanggan(){
        mp.setId_pelanggan(f_id_pelanggan.getInteger());
        mp.setAlamat(tex_area_alamat.getText());
        mp.setNama(f_nama.getText());
        mp.setNo_telepon(f_no_telepon.getText());
        mp.setTipe_pembayaran(c_type_pelanggan.getSelectedIndex());
    }
    private void flipflop(boolean status){
        jButton1.setEnabled(!status);
        jButton2.setEnabled(status);
    }
    private MD_Harga_pelanggan insertTable(){
        setMD_pelanggan();
        MD_Harga_pelanggan mhp=null;
        MD_Produk tmpMP=(MD_Produk)C_nama_produk.getSelectedItem();
        int harga=f_harga.getInteger();
        return new MD_Harga_pelanggan(harga, tmpMP, harga);
    }
    
    private boolean cekKosong(){
        return f_id_pelanggan.Kosongkah()
                &&!tex_area_alamat.getText().equals("")
                &&f_nama.Kosongkah()
                &&f_no_telepon.Kosongkah()
                &&c_type_pelanggan.getSelectedIndex()!=0
                &&t_Harga.getRowCount()!=0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_no_pelanggan = new javax.swing.JLabel();
        jl_nama_pelanggan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jl_no_telp = new javax.swing.JLabel();
        jl_type_pelanggan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        t_Harga = new javax.swing.JTable();
        jl_nama_produk = new javax.swing.JLabel();
        jl_harga = new javax.swing.JLabel();
        f_harga = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_harga);
        C_nama_produk = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser(jl_nama_produk);
        jButton3 = new javax.swing.JButton();
        f_id_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_pelanggan);
        f_nama = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_nama_pelanggan);
        jScrollPane1 = new javax.swing.JScrollPane();
        tex_area_alamat = new javax.swing.JTextArea();
        f_no_telepon = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_telp);
        c_type_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser(jl_type_pelanggan);
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        L_nama_pelanggan = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jl_no_pelanggan.setText("No Pelanggan");

        jl_nama_pelanggan.setText("Nama");

        jLabel3.setText("Alamat");

        jl_no_telp.setText("No Telepon");

        jl_type_pelanggan.setText("Type Pelanggan");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "List Harga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        t_Harga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Nama Produk", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_Harga.getTableHeader().setReorderingAllowed(false);
        t_Harga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                t_HargaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(t_Harga);
        if (t_Harga.getColumnModel().getColumnCount() > 0) {
            t_Harga.getColumnModel().getColumn(0).setResizable(false);
            t_Harga.getColumnModel().getColumn(0).setPreferredWidth(5);
            t_Harga.getColumnModel().getColumn(1).setResizable(false);
            t_Harga.getColumnModel().getColumn(1).setPreferredWidth(200);
            t_Harga.getColumnModel().getColumn(2).setResizable(false);
            t_Harga.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        jl_nama_produk.setText("Nama Produk");

        jl_harga.setText("Harga");

        jButton3.setText("Tambah");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jl_nama_produk)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C_nama_produk, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jl_harga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_nama_produk)
                    .addComponent(jl_harga)
                    .addComponent(f_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(C_nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        f_id_pelanggan.setEditable(false);

        tex_area_alamat.setColumns(20);
        tex_area_alamat.setRows(5);
        jScrollPane1.setViewportView(tex_area_alamat);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(1, 1, 1), 4), "List Pelanggan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        L_nama_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                L_nama_pelangganMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(L_nama_pelanggan);

        jPanel3.add(jScrollPane2);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/edit.png"))); // NOI18N
        jButton1.setText("Edit");

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jl_no_pelanggan)
                            .addComponent(jl_type_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_nama_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_no_telp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_no_telepon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(c_type_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_id_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_no_pelanggan)
                            .addComponent(f_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_nama_pelanggan)
                            .addComponent(f_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_no_telp)
                            .addComponent(f_no_telepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jl_type_pelanggan)
                            .addComponent(c_type_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        mvp.addtoTablemodel(insertTable());
        resetFull();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void L_nama_pelangganMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_L_nama_pelangganMousePressed
        mp=(MD_Pelanggan)L_nama_pelanggan.getSelectedValue();
        f_id_pelanggan.setText(mp.getId_Pelanggan());
        f_nama.setText(mp.getNama());
        f_no_telepon.setText(mp.getNo_telepon());
        tex_area_alamat.setText(mp.getAlamat());
        c_type_pelanggan.setSelectedIndex(mp.getTipe_pembayaran());
        mvp.setTableModel(mp);
        flipflop(false);
    }//GEN-LAST:event_L_nama_pelangganMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(cekKosong()){
            mvp.Insert();
            reset();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void t_HargaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_HargaMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_t_HargaMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser C_nama_produk;
    private javax.swing.JList L_nama_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_type_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_harga;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_id_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_nama;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_telepon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jl_harga;
    private javax.swing.JLabel jl_nama_pelanggan;
    private javax.swing.JLabel jl_nama_produk;
    private javax.swing.JLabel jl_no_pelanggan;
    private javax.swing.JLabel jl_no_telp;
    private javax.swing.JLabel jl_type_pelanggan;
    private javax.swing.JTable t_Harga;
    private javax.swing.JTextArea tex_area_alamat;
    // End of variables declaration//GEN-END:variables
}
