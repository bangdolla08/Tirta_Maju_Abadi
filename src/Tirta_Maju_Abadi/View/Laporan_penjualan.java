/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;

import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Mobil_Keluar;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.listMD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
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
public class Laporan_penjualan extends javax.swing.JInternalFrame {

    /**
     * Creates new form Laporan_penjualan
     */
    private database db;
    private loadAllData lad;
    private loadAllData lads;
    private DefaultTableModel dtm=new DefaultTableModel();
    private TableModel tm;
    private ResultSet rs;
    private ResultSet rss;
    private MD_Pelanggan mp;
    private MD_Mobil_Keluar mkeluar;
    private MD_Full_penjualan mfp;
    private Date date=new Date();
    public Laporan_penjualan(database db, loadAllData lad) {
        initComponents();
        //this.db=db;
        this.lad=lad;
        setNamaPelangan();
        dtm=(DefaultTableModel)t_laporan.getModel();
        t_start.setDate(date);
        t_end.setDate(date);
    }
    
    
    private void setNamaPelangan(){
        for(MD_Pelanggan mpel:lad.getListMD_Pelanggan().getAll()){
            c_pelanggan.addItem(mpel);
        }
    }
    
//    public void showTable(){
//        int no=1;
//        dtm.setRowCount(0);
//        try{
//            java.sql.Date date = new java.sql.Date(t_start.getDate().getTime());
//            java.sql.Date dates = new java.sql.Date(t_end.getDate().getTime());
//            rs=new database().getRs("select a.Id_pelanggan, a.No_nota, DATE_FORMAT(a.tanggalpesan,'%d-%m-%Y') as tanggall, "
//                    + "b.Id_pelanggan, b.Nama,  DATE_FORMAT(c.tanggal, '%d-%m-%Y') as tanggals, sum(d.Banyak)as banyakk from penjualan_po a, "
//                    + "pelanggan b, mobil_keluar c, full_penjualan d where b.Id_pelanggan='"+c_pelanggan.getSelectedIndex()+"' and a.Id_pelanggan='"+c_pelanggan.getSelectedIndex()+"'"
//                    + "and a.tanggalpesan between '"+date+"' and '"+dates+"' and a.tanggalpesan=c.tanggal and a.No_nota=d.No_nota");
//            while(rs.next()){
//                Vector vct=new Vector();
//                vct.add(no);
//                vct.add(rs.getString("No_nota"));
//                vct.add(rs.getString("Nama"));
//                vct.add(rs.getString("banyakk"));
//                vct.add(rs.getString("tanggall"));
//                vct.add(rs.getString("tanggals"));
//                vct.add("");
//                no++;
//                dtm.addRow(vct);
//            }
//        }catch(Exception e){
//            System.out.println("erorr= "+e);
//        }
//    }
    private int ambilTotal(String No_nota){
        int a=0;
        try{
            rss=new database().getRs("select sum(banyak) as banyaks from full_penjualan where No_nota='"+No_nota+"'");
            while(rss.next()){
                a=Integer.valueOf(rss.getString("banyaks"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return a;
    }
    
    public void tampilkan(){
        SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        int no=1;
        dtm.setRowCount(0);
        try{
            if(t_start.getDate()==null||t_end.getDate()==null)
                    rs=new database().getRs("Select * from penjualan_po");
               else{
                   java.sql.Date date = new java.sql.Date(t_start.getDate().getTime());
                   java.sql.Date dates = new java.sql.Date(t_end.getDate().getTime());
                   rs=new database().getRs("select * from penjualan_po where Id_pelanggan='"+c_pelanggan.getSelectedIndex()+"' "
                    + "and tanggalpesan between '"+date+"' and '"+dates+"'");
               }
            while(rs.next()){
                this.mfp=lad.getListMD_Full_penjualan().getMDByNo_nota(rs.getString("No_nota"));
                if(rs.getString("No_nota").equals(mfp.getNo_nota())&&
                        rs.getInt("Id_pelanggan")==c_pelanggan.getSelectedIndex()){
                Vector vct=new Vector();
                vct.add(no);
                vct.add(rs.getString("No_nota"));
                this.mp=lad.getListMD_Pelanggan().getMDByID(c_pelanggan.getSelectedIndex());
                vct.add(mp.getNama());
                int a=ambilTotal(rs.getString("No_nota"));
                vct.add(a);
                vct.add(df.format(rs.getDate("tanggalpesan")));
                this.mkeluar=lad.getListMD_Mobil_Keluar().getMDByTanggal(rs.getDate("tanggalpesan"));
                vct.add(df.format(mkeluar.getTgl()));
                vct.add("");
                no++;
                dtm.addRow(vct);
                //JOptionPane.showMessageDialog(null, mp);
                }
            }
        }catch(Exception e){
            System.out.println(e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        t_laporan = new javax.swing.JTable();
        c_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        t_start = new com.toedter.calendar.JDateChooser();
        t_end = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 51, 0), 4), "Laporan Penjualan", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        t_laporan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "No Nota", "Nama Pelanggan", "Total", "Tanggal Pesan", "Tanggal Pengiriman", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(t_laporan);
        if (t_laporan.getColumnModel().getColumnCount() > 0) {
            t_laporan.getColumnModel().getColumn(0).setResizable(false);
            t_laporan.getColumnModel().getColumn(0).setPreferredWidth(5);
            t_laporan.getColumnModel().getColumn(1).setResizable(false);
            t_laporan.getColumnModel().getColumn(2).setResizable(false);
            t_laporan.getColumnModel().getColumn(3).setResizable(false);
            t_laporan.getColumnModel().getColumn(4).setResizable(false);
            t_laporan.getColumnModel().getColumn(5).setResizable(false);
            t_laporan.getColumnModel().getColumn(6).setResizable(false);
        }

        t_start.setDateFormatString("dd-MM-yyyy");

        t_end.setDateFormatString("dd-MM-yyyy");

        jLabel1.setText("Dari Bulan ");

        jLabel2.setText("Sampai Bulan");

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Pelanggan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_start, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_end, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(t_start, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(c_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //isiData();
        tampilkan();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_pelanggan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser t_end;
    private javax.swing.JTable t_laporan;
    private com.toedter.calendar.JDateChooser t_start;
    // End of variables declaration//GEN-END:variables
}
