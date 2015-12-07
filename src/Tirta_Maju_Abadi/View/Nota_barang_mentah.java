package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Full_Piutang;
import Tirta_Maju_Abadi.DataModel.MD_Piutang;
import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.View.evetView.model_nota_bahan_mentah;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.Date;
import javax.swing.JOptionPane;

public class Nota_barang_mentah extends javax.swing.JInternalFrame {
    
    private MD_Piutang mp;
    private model_nota_bahan_mentah mnbm;
    
    public Nota_barang_mentah(loadAllData lad,database db) {
        initComponents();
        mp=new MD_Piutang(lad);
        mnbm=new model_nota_bahan_mentah(lad, db, mp, t_nota_barang_mentah.getModel());
        t_nota_barang_mentah.setModel(mnbm.getDtm());
        for(MD_Supplier tmps:lad.getListMD_Suplier().getList())
            f_supplier.addItem(tmps);
        visiblefilt(false);
        reset();
    }
    public Nota_barang_mentah(loadAllData lad,database db,MD_Piutang mdp) {
        initComponents();
        mp=mdp;
        //mnbm=new model_nota_bahan_mentah(lad, db, mp, t_nota_barang_mentah.getModel());
        //reset();
        visiblefilt(true);
    }
    private void reset(){
        mnbm.reset();
        f_No_pO.reset();
        f_no_nota.reset();
        f_supplier.reset();
        f_no_surat_jalan.reset();
        d_tanggal.setDate(null);
        d_tanggal_tempo.setDate(null);
        f_total.setText(0);
        f_total_ppn.setVisible(false);
        jLabel1.setVisible(false);
        resetfull();
    }
    private void visiblefilt(boolean a){
        jt_no_pem.setVisible(a);
        jl_setatus_pembayaran.setVisible(a);
        txt_setatus_pembayaran.setVisible(a);
        jl_dari_no_rekening.setVisible(a);
        jl_dari_norek.setVisible(a);
    }
    private void resetfull(){
        f_banyak.reset();
        f_nama_barang.reset();
        f_harga.reset();
    }
    
    private void insertIN(){
        mp.setNo_po(f_No_pO.getString());
        mp.setNo_Nota_Piutang(f_no_nota.getString());
        mp.setTanggal_nota((Date) d_tanggal.getDate());
        mp.setTanggal_jatuh_tempo((Date) d_tanggal_tempo.getDate());
        mp.setNo_surat_jalan(f_no_surat_jalan.getString());
        mp.setMds((MD_Supplier)f_supplier.getSelectedItem());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_no_nota = new javax.swing.JLabel();
        jl_Tanggal = new javax.swing.JLabel();
        jl_surat_jalan = new javax.swing.JLabel();
        jl_suplier = new javax.swing.JLabel();
        f_no_nota = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_nota);
        d_tanggal = new com.toedter.calendar.JDateChooser();
        f_no_surat_jalan = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_surat_jalan);
        f_supplier = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser(jl_suplier);
        jPanel2 = new javax.swing.JPanel();
        Jl_nama_barang = new javax.swing.JLabel();
        f_nama_barang = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(Jl_nama_barang);
        jl_harga = new javax.swing.JLabel();
        f_harga = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_harga);
        Jl_banyak = new javax.swing.JLabel();
        f_banyak = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(Jl_banyak);
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_nota_barang_mentah = new javax.swing.JTable();
        jl_total = new javax.swing.JLabel();
        f_total = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        f_total_ppn = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt();
        jl_no_po = new javax.swing.JLabel();
        f_No_pO = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_no_po);
        jl_Tanggal1 = new javax.swing.JLabel();
        d_tanggal_tempo = new com.toedter.calendar.JDateChooser();
        jl_setatus_pembayaran = new javax.swing.JLabel();
        txt_setatus_pembayaran = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_setatus_pembayaran);
        JL_no_pembayaran = new javax.swing.JLabel();
        jt_no_pem = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(JL_no_pembayaran);
        jl_dari_no_rekening = new javax.swing.JLabel();
        jl_dari_norek = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(jl_dari_no_rekening);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Nota Bahan Baku", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jl_no_nota.setText("No Nota Hutang");

        jl_Tanggal.setText("Tanggal Nota");

        jl_surat_jalan.setText("No Surat Jalan");

        jl_suplier.setText("Supplier");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Tabel Nota Barang Mentah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        Jl_nama_barang.setText("Nama Barang");

        jl_harga.setText("Harga");

        Jl_banyak.setText("Banyak");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton1.setText("Tambahkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t_nota_barang_mentah.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama", "Harga", "Banyak", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_nota_barang_mentah.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(t_nota_barang_mentah);
        if (t_nota_barang_mentah.getColumnModel().getColumnCount() > 0) {
            t_nota_barang_mentah.getColumnModel().getColumn(0).setResizable(false);
            t_nota_barang_mentah.getColumnModel().getColumn(0).setPreferredWidth(1);
            t_nota_barang_mentah.getColumnModel().getColumn(1).setResizable(false);
            t_nota_barang_mentah.getColumnModel().getColumn(1).setPreferredWidth(200);
            t_nota_barang_mentah.getColumnModel().getColumn(2).setResizable(false);
            t_nota_barang_mentah.getColumnModel().getColumn(3).setResizable(false);
            t_nota_barang_mentah.getColumnModel().getColumn(4).setResizable(false);
        }

        jl_total.setText("Total");

        f_total.setEditable(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/simpan.png"))); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/Reset.png"))); // NOI18N
        jButton3.setText("Reset");

        jCheckBox1.setText("PPN");
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jLabel1.setText("Total + PPN");

        f_total_ppn.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Jl_nama_barang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jl_harga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(f_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Jl_banyak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCheckBox1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jl_total))
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(f_total, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(f_total_ppn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jl_nama_barang)
                    .addComponent(f_nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_harga)
                    .addComponent(f_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jl_banyak)
                    .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_total)
                    .addComponent(f_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(f_total_ppn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jl_no_po.setText("No PO");

        jl_Tanggal1.setText("JatuhTempo");

        jl_setatus_pembayaran.setText("Pembayaran");

        txt_setatus_pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_setatus_pembayaranActionPerformed(evt);
            }
        });

        JL_no_pembayaran.setText("Nomor Transaksi");

        jl_dari_no_rekening.setText("Dari No Rekening");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jl_no_nota)
                                .addComponent(jl_Tanggal)
                                .addComponent(jl_surat_jalan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jl_suplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jl_no_po)
                            .addComponent(jl_Tanggal1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_No_pO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_nota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(d_tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                            .addComponent(f_no_surat_jalan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_supplier, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(d_tanggal_tempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(154, 154, 154)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jl_setatus_pembayaran)
                            .addComponent(JL_no_pembayaran)
                            .addComponent(jl_dari_no_rekening))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_setatus_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jt_no_pem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jl_dari_norek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_no_po)
                    .addComponent(f_No_pO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_setatus_pembayaran)
                    .addComponent(txt_setatus_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_no_nota)
                    .addComponent(f_no_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JL_no_pembayaran)
                    .addComponent(jt_no_pem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Tanggal)
                    .addComponent(d_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_dari_no_rekening)
                        .addComponent(jl_dari_norek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Tanggal1)
                    .addComponent(d_tanggal_tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_no_surat_jalan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_surat_jalan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_suplier)
                    .addComponent(f_supplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        insertIN();
        mnbm.SetFullPiutang(new MD_Full_Piutang(mp.getNo_po(), mp.getNo_Nota_Piutang(), f_nama_barang.getText(), f_harga.getInteger(), f_banyak.getInteger()));
        f_total.setText(f_total.getInteger()+(f_harga.getInteger()* f_banyak.getInteger()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(mnbm.insert())
            JOptionPane.showMessageDialog(null, "Data Telah Berhasil Di Simpan","Sukses",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Telah Gagal Di Simpan","Sukses",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
        //try {
            if(jCheckBox1.isSelected()){
                f_total_ppn.setText(f_total.getInteger()+(f_total.getInteger()*(10/100)));
                f_total_ppn.setVisible(true);
                jLabel1.setVisible(true);
            }else{
                f_total_ppn.setVisible(false);
                jLabel1.setVisible(false);
            }
        
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void txt_setatus_pembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_setatus_pembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_setatus_pembayaranActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JL_no_pembayaran;
    private javax.swing.JLabel Jl_banyak;
    private javax.swing.JLabel Jl_nama_barang;
    private com.toedter.calendar.JDateChooser d_tanggal;
    private com.toedter.calendar.JDateChooser d_tanggal_tempo;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_No_pO;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_banyak;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_harga;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_nama_barang;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_nota;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_surat_jalan;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser f_supplier;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_total;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_total_ppn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_Tanggal;
    private javax.swing.JLabel jl_Tanggal1;
    private javax.swing.JLabel jl_dari_no_rekening;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt jl_dari_norek;
    private javax.swing.JLabel jl_harga;
    private javax.swing.JLabel jl_no_nota;
    private javax.swing.JLabel jl_no_po;
    private javax.swing.JLabel jl_setatus_pembayaran;
    private javax.swing.JLabel jl_suplier;
    private javax.swing.JLabel jl_surat_jalan;
    private javax.swing.JLabel jl_total;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt jt_no_pem;
    private javax.swing.JTable t_nota_barang_mentah;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt txt_setatus_pembayaran;
    // End of variables declaration//GEN-END:variables
}
