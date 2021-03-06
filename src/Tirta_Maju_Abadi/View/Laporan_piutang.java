/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Laporan_piutang extends javax.swing.JInternalFrame {

    /**
     * Creates new form Laporan_piutang
     */
    private database db;
    private loadAllData lad;
    private loadAllData lads;
    private DefaultTableModel dtm=new DefaultTableModel();
    private TableModel tm;
    private ResultSet rs;
    private ResultSet rs2;
    private ResultSet rss;
    private MD_Pelanggan mp;
    private MD_Penjualan_po mpp;
    private MD_Supplier mps;
    private MD_Datang_bahan_dasar mdb;
    private Date date=new Date();
    private List<list2Values> list=new ArrayList<>();
    

    public Laporan_piutang(database db, loadAllData lad) {
        initComponents();
        this.lad=lad;
        //setNamaPelangan();
        setCuser();
        list(c_pilih);    
        dtm=(DefaultTableModel)t_laporan_piutang.getModel();
        t_start.setDate(date);
        t_end.setDate(date);
        c_pelanggan.setEnabled(false);
    }
    
    private void setNamaPelangan(){
        c_pelanggan.removeAllItems();
        c_pelanggan.addItem("--Pilih--");
        for(MD_Pelanggan mpel:lad.getListMD_Pelanggan().getAll()){
            c_pelanggan.addItem(mpel);
        }
    }
    
    private void setNamaSipplier(){
        c_pelanggan.removeAllItems();
        c_pelanggan.addItem("--Pilih--");
        for(MD_Supplier msup:lad.getListMD_Suplier().getList()){
            c_pelanggan.addItem(msup);
        }
    }
    
    public void list(ModelChuser mc){
        mc.setModel(list);
    }
    private void setCuser(){
        list.add(new list2Values("Nama Pelanggan", 1));
        list.add(new list2Values("Nama Supplier", 2));
    }
    
    public void showTable(){
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        int no=1;
        int x=0;
        String a="";
        dtm.setRowCount(0);
        try{
               if(t_start.getDate()==null||t_end.getDate()==null)
                    rs=new database().getRs("Select * from piutang");
               else{
                   java.sql.Date date = new java.sql.Date(t_start.getDate().getTime());
                   java.sql.Date dates = new java.sql.Date(t_end.getDate().getTime());
                   rs=new database().getRs("Select * from piutang where tanggal_nota between '"+date+"' and '"+dates+"'");
               }
                    
            while(rs.next()){
                if(c_pilih.getSelectedIndex()==1){
                    this.mpp=lad.getListMD_Penjualan_po().getMDByNO_Surat(rs.getString("no_nota_piutang"));
                    x=mpp.getId_pelanggan();
                }if(c_pilih.getSelectedIndex()==2){
                    this.mpp=lad.getListMD_Penjualan_po().getMDByNO_Surat(rs.getString("no_nota_piutang"));
                    this.mdb=lad.getListMD_Datang_bahan_dasar().getMDByNo_po(rs.getString("No_PO"));
                    x=mdb.getId_supplier();
                    //JOptionPane.showMessageDialog(null, x);
                }
                
                if(rs.getString("no_nota_piutang").equals(mpp.getNo_nota())&&
                        x==c_pelanggan.getSelectedIndex()){
                    Vector vct=new Vector();
                    vct.add(no);
                    vct.add(rs.getString("no_nota_piutang"));
                    this.mp=lad.getListMD_Pelanggan().getMDByID(c_pelanggan.getSelectedIndex());
                    vct.add(mp.getNama());
                    vct.add(df.format(rs.getDate("tanggal_nota")));
                    vct.add(df.format(rs.getDate("tanggal_jatuhTempo")));
                    vct.add(rs.getString("no_surat_jalan"));
                    boolean tmp=rs.getBoolean("setatusPembayaran");
                    if(tmp)
                        a="Sudah";
                    else
                        a="Belum";
                    vct.add(a);
                    no++;
                    dtm.addRow(vct);
                }
            }
           }catch(Exception e){
               
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

        jPanel1 = new javax.swing.JPanel();
        jl_nama = new javax.swing.JLabel();
        c_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        jLabel1 = new javax.swing.JLabel();
        t_start = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        t_end = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_laporan_piutang = new javax.swing.JTable();
        jl_pilihan = new javax.swing.JLabel();
        c_pilih = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser(jl_pilihan);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 4), "Laporan Piutang", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jl_nama.setText("Nama Pelanggan");

        jLabel1.setText("Dari Bulan ");

        t_start.setDateFormatString("dd-MM-yyyy");

        jLabel2.setText("Sampai Bulan");

        t_end.setDateFormatString("dd-MM-yyyy");

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        t_laporan_piutang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "No Nota Piutang", "Nama Pelanggan", "Tanggal Nota", "Tanggal Jatuh Tempo", "No Surat Jalan", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_laporan_piutang);
        if (t_laporan_piutang.getColumnModel().getColumnCount() > 0) {
            t_laporan_piutang.getColumnModel().getColumn(0).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(0).setPreferredWidth(50);
            t_laporan_piutang.getColumnModel().getColumn(1).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(1).setPreferredWidth(110);
            t_laporan_piutang.getColumnModel().getColumn(2).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(2).setPreferredWidth(180);
            t_laporan_piutang.getColumnModel().getColumn(3).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(3).setPreferredWidth(100);
            t_laporan_piutang.getColumnModel().getColumn(4).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(4).setPreferredWidth(150);
            t_laporan_piutang.getColumnModel().getColumn(5).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(5).setPreferredWidth(110);
            t_laporan_piutang.getColumnModel().getColumn(6).setResizable(false);
            t_laporan_piutang.getColumnModel().getColumn(6).setPreferredWidth(80);
        }

        jl_pilihan.setText("Pilihan");

        c_pilih.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_pilihItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c_pelanggan, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(c_pilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_start, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t_end, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t_start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(c_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void c_pilihItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_pilihItemStateChanged
        // TODO add your handling code here:
        if(c_pilih.getSelectedIndex()==1){
            jl_nama.setText("Nama Pelanggan");
            c_pelanggan.setEnabled(true);
            setNamaPelangan();
        }if(c_pilih.getSelectedIndex()==2){
            jl_nama.setText("Nama Supplier");
            c_pelanggan.setEnabled(true);
            setNamaSipplier();
        }
    }//GEN-LAST:event_c_pilihItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_pilih;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_nama;
    private javax.swing.JLabel jl_pilihan;
    private com.toedter.calendar.JDateChooser t_end;
    private javax.swing.JTable t_laporan_piutang;
    private com.toedter.calendar.JDateChooser t_start;
    // End of variables declaration//GEN-END:variables
}
