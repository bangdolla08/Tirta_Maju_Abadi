/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.listMD_Full_penjualan;
import java.util.Vector;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import java.util.ArrayList;
import java.util.List;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.*;
import Tirta_Maju_Abadi.Report.Items;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author NEEZAR
 */
public class view_penjualan_depo {
    private MD_Full_penjualan m_depo;
    private DefaultTableModel dtm;
    private MD_Pelanggan pel=new MD_Pelanggan();
    private database db;
    private loadAllData ld;
    private listMD_Penjualan_po lppo;
    private MD_Penjualan_po mpo;
    private MD_Galon_keluar mgk=new MD_Galon_keluar();
    private modelTextFilt total;
    private modelTextFilt pembayaran;
    private modelTextFilt kembalian;
    private List<Items> items = new ArrayList<Items>();

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    
    public view_penjualan_depo(TableModel tm, MD_Full_penjualan m_depo, database db,loadAllData ld, MD_Pelanggan pel,MD_Penjualan_po mpo){
       this.dtm=(DefaultTableModel) tm;
       this.m_depo=m_depo;
       this.db=db;
       this.pel=pel;
       this.ld=ld;
       this.mpo=mpo;
       dtm.setRowCount(0);
      
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void set_table(MD_Full_penjualan mfp,int id_pelanggan){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mfp.getMp());
        int banyak=mfp.getBanyak();
        int harga=ld.getListMD_Harga_pelanggan().getByIDAndProduk(id_pelanggan, mfp.getId_Produk()).getHarga();
        //System.out.println("Embuh Kok Gak Bisa akukhan galau"+harga+"asdasd"+mfp.getId_Produk()+"    "+pel.getId_Pelanggan());
        vct.add(harga);
        vct.add(banyak);
        vct.add(banyak*harga);
//        total.setText(total.getInteger()+harga*banyak);
//        pembayaran.setText(pembayaran.getInteger());
//        kembalian.setText(pembayaran.getInteger()-total.getInteger());
        mpo.listMD_Full_penjualan(mfp);
        dtm.addRow(vct);
    }
    

    
   // List<list2Values> list=new ArrayList<>();
    
   // String bln;
    ResultSet rs;
    public void reset_nota(){
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        int year=cal.get(Calendar.YEAR);
        try{
        rs=new database().getRs("select count(*) as a " +
        "from penjualan_po " +
        "where year(tanggalpesan) = '"+year+"' and month(tanggalpesan) = '"+month+"' and no_po_penjulan like 'PD%'");
        if(rs.next()){
            System.out.println("cobabababa="+rs.getInt("a"));
            int myInt = 100;
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String nota="PD "+String.valueOf(decimalFormat.format(rs.getInt("a")+1))+"/"+month+"/"+year+" "+pel.getTipe_pembayaran();
            mpo.setNo_nota(nota);
              }
        } catch(Exception e){
            System.out.print(e);
        }
     }
        
    public String getReset_nota(){
        reset_nota();
        return mpo.getNo_nota();
    }
    
    
     public void simpanpenjulanpo(){
     try{
       if(db.setDB("insert into penjualan_po set id_pelanggan='"+mpo.getId_pelanggan()+"',"
        +"no_nota='"+mpo.getNo_nota()+"',"
        +"No_po_penjulan='"+mpo.getNo_po()+"',"
        +"tanggalpesan='"+mpo.getTanggalpesan()+"',"
        +"id_marketing='"+mpo.getId_marketing()+"'")){
        boolean tmp=true;
        for(MD_Full_penjualan mdfp:mpo.getListFull()) {
        tmp=tmp&&db.setDB("insert into full_penjualan set id_produk='"+mdfp.getId_Produk()+"',"
            +" no_nota='"+mpo.getNo_po()+"',"
            +" banyak='"+mdfp.getBanyak()+"'");
        }
       if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
       } 
    }catch(Exception e){
        System.out.println("kesalannya adalah "+e);
    }
     }
}
