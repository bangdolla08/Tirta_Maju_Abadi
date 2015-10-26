/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Full_Bo_barang;
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
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Tirta_Maju_Abadi.View.Pencarian_pelanggan;
import Tirta_Maju_Abadi.DataModel.listMD_Pegawai;
import Tirta_Maju_Abadi.DataModel.MD_Pegawai;
import static Tirta_Maju_Abadi.View.Penjualan_depo.convertUtilDateToSqlDate;
import Tirta_Maju_Abadi.View.evetView.view_penjualan_depo;

/**
 *
 * @author NEEZAR
 */
public class PO_penjualan extends javax.swing.JInternalFrame {
    private MD_Penjualan_po mpel=new MD_Penjualan_po();
    private View_penjualan_po vpp;
    private database db;
    private listMD_Penjualan_po lppo;
    private MD_Pelanggan pelanggan=new MD_Pelanggan();
    private Date date=new Date();
    private loadAllData ld;
    private MD_Full_penjualan m_depo;
    private MD_Pegawai m_pegawai;
    /**
     * Creates new form PO_penjualan
     */
    public PO_penjualan(database db,loadAllData ld) {
        initComponents();
        this.m_depo=m_depo;
        f_total.setText(0);
        this.db=db;
        this.ld=ld;
        vpp=new View_penjualan_po(t_penjualan.getModel(), m_depo, db,ld,pelanggan,mpel );
        reset();
        t_penjualan.setModel(vpp.getdtm());
    }
    
    public void setlist(){
        for(MD_Produk mp:ld.getListMD_Produk().getAll()){
           c_nm_produk.addItem(mp);
        } 
    }
    
     public void setlistMarketing(){
        for(MD_Pegawai m_pegawai:ld.getListMD_Pegawai().getListMarketing()){
           c_id_marketing.addItem(m_pegawai);
         }
    }
    
    public void reset(){
        setlistMarketing();
        setlist();
        vpp.reset_notadanpo();
        f_no_po.setText(vpp.getReset_po());
        f_nm_pelanggan.setText("");
        d_tanggal_po.setDate(null);
        f_banyak.setText("");
        f_total.setText("");
        ngesetTgl();
    }
    public void ngesetTgl(){
        Date date = new Date();
        d_tanggal_po.setDate(date);
    }
    
    private void panggil_pelanggan(){
        Pencarian_pelanggan pen=new Pencarian_pelanggan(this);
        pen.setVisible(true);
        pen.requestFocus(true);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - pen.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - pen.getHeight()) / 2);
        pen.setLocation(x, y);
        getParent().add(pen);
        pen.moveToFront();
   }
    
     public void list(modelTextFilt mtf){
        List<list2Values> list=new ArrayList<>();
        for(MD_Pelanggan mp:ld.getListMD_Pelanggan().getAll()){
            list.add(new list2Values(mp.getNama(), mp.getId_Pelanggan()));
        }
        mtf.setText(list);
    }
     
      public MD_Full_penjualan setPenjualan_depo(){
        String no_po=f_no_po.getText();
        int bnyk=f_banyak.getInteger();
        MD_Produk tmpMP=(MD_Produk)c_nm_produk.getSelectedItem();
        return new MD_Full_penjualan(tmpMP, bnyk, no_po, ld);
      }
     
    private void setMpel(){
        MD_Pegawai mppeg=(MD_Pegawai)c_id_marketing.getSelectedItem();
        //mpel.setId_marketing(mppeg);
        mpel.setNo_nota(f_no_po.getText());
        mpel.setNo_po(f_no_po.getText());
        mpel.setId_pelanggan(pelanggan.getId_Pelanggan());
        mpel.setId_marketing(c_id_marketing.getSelectedIndex());        
        mpel.setTanggalpesan(convertUtilDateToSqlDate(d_tanggal_po.getDate()));
        }
    
//    private MD_Penjualan_po setMpelpo(){
//        MD_Pegawai mppeg=(MD_Pegawai)c_id_marketing.getSelectedItem();
//        //mpel.setId_marketing(mppeg);
////        mpel.setNo_nota(f_no_po.getText());
////        mpel.setNo_po(f_no_po.getText());
////        mpel.setId_pelanggan(pelanggan.getId_Pelanggan());
//        mpel.setTanggalpesan(convertUtilDateToSqlDate(d_tanggal_po.getDate()));
//        MD_Pegawai mdpeg=(MD_Pegawai) c_id_marketing.getSelectedItem();
//        String no_po=f_no_po.getText();
//        String no_nota=f_no_po.getText();
//       return new MD_Penjualan_po(HIDE_ON_CLOSE, no_nota, no_po, date, HIDE_ON_CLOSE, db, ld);
//        }
    
    
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        l_nm_pelanggan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        d_tanggal_po = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        c_nm_produk = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        l_banyak = new javax.swing.JLabel();
        f_banyak = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_banyak);
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_penjualan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        f_total = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        f_nm_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_nm_pelanggan);
        jLabel2 = new javax.swing.JLabel();
        c_id_marketing = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        f_no_po = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "PO Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel1.setText("No PO");

        l_nm_pelanggan.setText("Nama Pelanggan");

        jLabel3.setText("Tanggal PO");

        d_tanggal_po.setDate(date);
        d_tanggal_po.setDateFormatString("dd-MM-yyyy");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Tabel Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel4.setText("Nama Produk");

        l_banyak.setText("Banyak");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t_penjualan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Produk", "Banyak", "Harga", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        t_penjualan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(t_penjualan);
        if (t_penjualan.getColumnModel().getColumnCount() > 0) {
            t_penjualan.getColumnModel().getColumn(0).setResizable(false);
            t_penjualan.getColumnModel().getColumn(0).setPreferredWidth(1);
            t_penjualan.getColumnModel().getColumn(1).setResizable(false);
            t_penjualan.getColumnModel().getColumn(1).setPreferredWidth(150);
            t_penjualan.getColumnModel().getColumn(2).setResizable(false);
            t_penjualan.getColumnModel().getColumn(3).setResizable(false);
            t_penjualan.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel6.setText("Total");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/pesan.png"))); // NOI18N
        jButton2.setText("Pesan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/Reset.png"))); // NOI18N
        jButton3.setText("Reset");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(c_nm_produk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_banyak)
                        .addGap(18, 18, 18)
                        .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_total, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_nm_produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(l_banyak)
                    .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(f_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        f_nm_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_nm_pelangganMouseClicked(evt);
            }
        });

        jLabel2.setText("Id Marketing");

        f_no_po.setEditable(false);

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
                            .addComponent(jLabel3)
                            .addComponent(l_nm_pelanggan)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_nm_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(d_tanggal_po, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(c_id_marketing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_no_po, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_id_marketing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(f_no_po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nm_pelanggan)
                    .addComponent(f_nm_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(d_tanggal_po, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setPenjualan_depo();
        setMpel();
        vpp.simpanpenjulanpo();
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tambahno();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void f_nm_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_nm_pelangganMouseClicked
        // TODO add your handling code here:
        panggil_pelanggan();
    }//GEN-LAST:event_f_nm_pelangganMouseClicked

    public void tambahno(){
        MD_Produk tmpMP=(MD_Produk)c_nm_produk.getSelectedItem();
        int bannyak=f_banyak.getInteger();
        int harga=ld.getListMD_Harga_pelanggan().getByIDAndProduk(mpel.getId_pelanggan(),tmpMP.getId_produk()).getHarga();
        MD_Full_penjualan mfp=new MD_Full_penjualan(tmpMP, bannyak,f_no_po.getString(), ld);
        vpp.set_TableBawah(mfp,pelanggan.getId_Pelanggan());   
        f_total.setText(harga*bannyak);  
       }    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_id_marketing;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_nm_produk;
    private com.toedter.calendar.JDateChooser d_tanggal_po;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_banyak;
    public static Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_nm_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_po;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_banyak;
    private javax.swing.JLabel l_nm_pelanggan;
    private javax.swing.JTable t_penjualan;
    // End of variables declaration//GEN-END:variables

    void tttt(MD_Pelanggan msdp) {
        pelanggan=msdp;
        //System.out.println(lad.getListMD_Harga_pelanggan().getByIDAndProduk(mp.getId_Pelanggan(),3).getHarga());
        mpel.setId_pelanggan(pelanggan.getId_Pelanggan());
        mpel.setPel(pelanggan);
        pelanggan=msdp;
        f_nm_pelanggan.setText(msdp);
    }
}
