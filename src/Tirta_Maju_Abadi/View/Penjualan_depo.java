/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View;
import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
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
import Tirta_Maju_Abadi.View.evetView.view_penjualan_depo;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.Report.InvoiceDatas;
import Tirta_Maju_Abadi.Report.InvoiceDesign;
import Tirta_Maju_Abadi.Report.InvoiceDesignPenj;
import Tirta_Maju_Abadi.Report.Invoices;
import Tirta_Maju_Abadi.Report.Items;
import Tirta_Maju_Abadi.View.Form_utama_TMA;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import net.sf.dynamicreports.examples.complex.invoice.Invoice;
import net.sf.dynamicreports.examples.complex.invoice.Item;
/**
 *
 * @author NEEZAR
 */
public class Penjualan_depo extends javax.swing.JInternalFrame {
    private MD_Penjualan_po mpel=new MD_Penjualan_po();
    private MD_Full_penjualan mp;
    private View_penjualan_po vpp;
    private database db;
    private listMD_Penjualan_po lppo;
    private Date date=new Date();
    private loadAllData lad;
    private MD_Pelanggan pel=new MD_Pelanggan();
    private MD_Produk pro;
    private view_penjualan_depo v_depo;
    private InvoiceDatas inv;
    private Invoices invoices;
    /**
     * Creates new form Penjualan_depo
     */
    public Penjualan_depo(database db,loadAllData lad) {
        initComponents();
        this.mp=mp;
        this.v_depo=v_depo;
        int defl=0;
        f_total.setText(0);
        this.db=db;
        this.lad=lad;
        pel.list(c_pembayaran);
        v_depo=new view_penjualan_depo(tbl_penjualan_depo.getModel(), mp, db,lad,pel,mpel );
        reset();
        tbl_penjualan_depo.setModel(v_depo.getdtm());
      }
    
 
    public void setlist(){
        for(MD_Produk mp:lad.getListMD_Produk().getAll()){
           c_nm_barang.addItem(mp);
            //mc.addItem(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
       // mc.setModel(list);
    }
    
   private void reset(){
        ngesetTgl();
        v_depo.reset_nota();
        f_no_nota.setText(v_depo.getReset_nota());
        f_nm_pelanggan.reset();
        tex_area_alamat.setText("");
        c_pembayaran.reset();
        f_banyak.reset();
        f_pembayaran.reset();
        f_kembali.reset();
        pel.setTipe_pembayaran(c_pembayaran.getSelectedIndex());
        setlist();
    }
   private void setpeln(){
       f_nm_pelanggan.reset();
       tex_area_alamat.setText("");
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
        for(MD_Pelanggan mp:lad.getListMD_Pelanggan().getAll()){
            list.add(new list2Values(mp.getNama(), mp.getId_Pelanggan()));
        }
        mtf.setText(list);
    }
    
    public void tttt(MD_Pelanggan mp){
        pel=mp;
        //System.out.println(lad.getListMD_Harga_pelanggan().getByIDAndProduk(mp.getId_Pelanggan(),3).getHarga());
        mpel.setId_pelanggan(pel.getId_Pelanggan());
        mpel.setPel(pel);
        f_nm_pelanggan.setText(mp.getNama());
        tex_area_alamat.setText(mp.getAlamat());
    }
    
    public void ngesetTgl(){
        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        int subtractYearValue = 10;
//        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
//        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
//        int currentDate= Calendar.getInstance().get(Calendar.DATE);
//        calendar.set(currentYear - subtractYearValue , currentMonth , currentDate);
//        date.setTime(calendar.getTimeInMillis());
        d_penjualan_depo.setDate(date);
    }
    
    public MD_Full_penjualan setPenjualan_depo(){
        String no_nota=f_no_nota.getText();
        int bnyk=f_banyak.getInteger();
        MD_Produk tmpMP=(MD_Produk)c_nm_barang.getSelectedItem();
        return new MD_Full_penjualan(tmpMP, bnyk, no_nota, lad);
      }
    
    private void setMpel(){
        mpel.setNo_nota(f_no_nota.getText());
        mpel.setNo_po(f_no_nota.getText());
        mpel.setId_pelanggan(pel.getId_Pelanggan());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String tgl=sdf.format(d_penjualan_depo.getDate());
        mpel.setTanggalpesan(convertUtilDateToSqlDate(d_penjualan_depo.getDate()));
        int kembali=f_pembayaran.getInteger()-f_total.getInteger();
        f_kembali.setText(kembali);
    }
    
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
    if(date != null) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }
    return null;
}
    
    public void tambah(){
        MD_Produk tmpMP=(MD_Produk)c_nm_barang.getSelectedItem();
        int bannyak=f_banyak.getInteger();
        int harga=lad.getListMD_Harga_pelanggan().getByIDAndProduk(mpel.getId_pelanggan(),tmpMP.getId_produk()).getHarga();
        //System.out.println("--ASUUUU--"+lad.getListMD_Harga_pelanggan().getByIDAndProduk(mpel.getId_pelanggan(), tmpMP.getId_produk()).getHarga());
        //int harga=mpel.getHarga(mp.getId_Produk()).getHarga();
        MD_Full_penjualan mfp=new MD_Full_penjualan(tmpMP, bannyak,f_no_nota.getString(), lad);
        v_depo.set_table(mfp,pel.getId_Pelanggan());   
        f_total.setText(harga*bannyak);
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
        jLabel1 = new javax.swing.JLabel();
        d_penjualan_depo = new com.toedter.calendar.JDateChooser();
        l_nota = new javax.swing.JLabel();
        l_nm_pelanggan = new javax.swing.JLabel();
        l_alamat = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tex_area_alamat = new javax.swing.JTextArea();
        f_no_nota = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_nota);
        f_nm_pelanggan = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_nm_pelanggan);
        c_pembayaran = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        l_bnyak = new javax.swing.JLabel();
        f_banyak = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_bnyak);
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_penjualan_depo = new javax.swing.JTable();
        l_total = new javax.swing.JLabel();
        l_pembayaran = new javax.swing.JLabel();
        l_kembali = new javax.swing.JLabel();
        f_total = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt();
        f_pembayaran = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_pembayaran);
        f_kembali = new Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt(l_kembali);
        c_nm_barang = new Tirta_Maju_Abadi.View.ModelSwing.ModelChuser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Penjualan Depo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel1.setText("Tanggal");

        d_penjualan_depo.setDateFormatString("dd-MM-yyyy");

        l_nota.setText("No Nota");

        l_nm_pelanggan.setText("Nama Pelanggan");

        l_alamat.setText("Alamat");

        jLabel5.setText("Pembayaran");

        tex_area_alamat.setEditable(false);
        tex_area_alamat.setColumns(20);
        tex_area_alamat.setRows(5);
        jScrollPane1.setViewportView(tex_area_alamat);

        f_no_nota.setEditable(false);

        f_nm_pelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                f_nm_pelangganMouseClicked(evt);
            }
        });
        f_nm_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_nm_pelangganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(d_penjualan_depo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_alamat)
                    .addComponent(jLabel5)
                    .addComponent(l_nm_pelanggan)
                    .addComponent(l_nota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(c_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(f_nm_pelanggan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(f_no_nota, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(l_nota)
                        .addComponent(f_no_nota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(d_penjualan_depo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_nm_pelanggan)
                    .addComponent(f_nm_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(l_alamat)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(c_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4), "Tabel Penjulan Depo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 0, 0))); // NOI18N

        jLabel6.setText("Nama Barang");

        l_bnyak.setText("Banyak ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/tambah.png"))); // NOI18N
        jButton1.setText("Tambahkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tbl_penjualan_depo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbl_penjualan_depo);
        if (tbl_penjualan_depo.getColumnModel().getColumnCount() > 0) {
            tbl_penjualan_depo.getColumnModel().getColumn(0).setResizable(false);
            tbl_penjualan_depo.getColumnModel().getColumn(0).setPreferredWidth(5);
            tbl_penjualan_depo.getColumnModel().getColumn(1).setResizable(false);
            tbl_penjualan_depo.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_penjualan_depo.getColumnModel().getColumn(2).setResizable(false);
            tbl_penjualan_depo.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbl_penjualan_depo.getColumnModel().getColumn(3).setResizable(false);
            tbl_penjualan_depo.getColumnModel().getColumn(3).setPreferredWidth(100);
            tbl_penjualan_depo.getColumnModel().getColumn(4).setResizable(false);
            tbl_penjualan_depo.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        l_total.setText("Total");

        l_pembayaran.setText("Pembayaran");

        l_kembali.setText("Kembali");

        f_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_kembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_total)
                            .addComponent(l_pembayaran)
                            .addComponent(l_kembali))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(f_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_pembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(f_kembali, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_nm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_bnyak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(l_bnyak)
                    .addComponent(f_banyak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(c_nm_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_total)
                    .addComponent(f_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_pembayaran)
                    .addComponent(f_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l_kembali)
                    .addComponent(f_kembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/pesan.png"))); // NOI18N
        jButton2.setText("Jual");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Tirta_Maju_Abadi/Images/Reset.png"))); // NOI18N
        jButton3.setText("Reset");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void f_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_kembaliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here: 
      tambah();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setPenjualan_depo();
        setMpel();
        v_depo.simpanpenjulanpo();
        new InvoiceDesignPenj(f_no_nota.getString());
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void f_nm_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_nm_pelangganActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_f_nm_pelangganActionPerformed

    private void f_nm_pelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_f_nm_pelangganMouseClicked
        // TODO add your handling code here:
        panggil_pelanggan();
    }//GEN-LAST:event_f_nm_pelangganMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_nm_barang;
    private Tirta_Maju_Abadi.View.ModelSwing.ModelChuser c_pembayaran;
    private com.toedter.calendar.JDateChooser d_penjualan_depo;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_banyak;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_kembali;
    public static Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_nm_pelanggan;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_no_nota;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_pembayaran;
    private Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt f_total;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel l_alamat;
    private javax.swing.JLabel l_bnyak;
    private javax.swing.JLabel l_kembali;
    private javax.swing.JLabel l_nm_pelanggan;
    private javax.swing.JLabel l_nota;
    private javax.swing.JLabel l_pembayaran;
    private javax.swing.JLabel l_total;
    private javax.swing.JTable tbl_penjualan_depo;
    public static javax.swing.JTextArea tex_area_alamat;
    // End of variables declaration//GEN-END:variables
}
