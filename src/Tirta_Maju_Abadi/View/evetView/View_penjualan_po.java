package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.View.Penjualan_depo;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class View_penjualan_po {
    
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Penjualan_po listmD_penjulanPO;
    private database db;
    private modelTextFilt totalText;
    private loadAllData ld;
    private modelTextFilt textfiltNoNota;
    private MD_Produk mpro;
    private MD_Pelanggan pel=new MD_Pelanggan();
    private MD_Penjualan_po mpo;
    private MD_Full_penjualan m_depo;
    
    public View_penjualan_po(TableModel tm, MD_Full_penjualan m_depo, database db,loadAllData ld, MD_Pelanggan pel,MD_Penjualan_po mpo){
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
    
    public void set_TableBawah(MD_Full_penjualan md_full,int id_pelanggan){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(md_full.getMp());
        int bnyk=md_full.getBanyak();
        int harga=ld.getListMD_Harga_pelanggan().getByIDAndProduk(id_pelanggan, md_full.getId_Produk()).getHarga();
        vct.add(bnyk);
        vct.add(harga);
        vct.add(harga*bnyk);
//      totalText.setText(totalText.getInteger()+(harga*bnyk));
        mpo.listMD_Full_penjualan(md_full);
        dtm.addRow(vct);
    }
   
//      String bln;
    ResultSet rs;
    public void reset_notadanpo(){
        Date date=new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH)+1;
        int year=cal.get(Calendar.YEAR);
        System.out.print(month);
        try{
        rs=new database().getRs("select count(*) as a " +
        "from penjualan_po " +
        "where year(tanggalpesan) = '"+year+"' and month(tanggalpesan) = '"+month+"'");
        if(rs.next()){
            int myInt = 100;
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String nota=String.valueOf(decimalFormat.format(rs.getInt("a")+1))+"/"+month+"/"+year+" "+pel.getTipe_pembayaran();
            mpo.setNo_po(nota);
        }
        } catch(Exception e){
            System.out.print(e);
        }
     }
    
//    public String getReset_nota(){
//        reset_notadanpo();
//        return mpo.getNo_nota();
//    }
    
     public String getReset_po(){
        reset_notadanpo();
        return mpo.getNo_po();
}
    
   public void simpanpenjulanpo(){
//   try{
       System.out.println("nota nya "+mpo.getNo_po());
       if(db.setDB("insert into penjualan_po set Id_pelanggan='"+mpo.getId_pelanggan()+"',"
        +"no_nota='"+mpo.getNo_nota()+"',"
        +"No_po_penjulan='"+mpo.getNo_po()+"',"
        +"tanggalpesan='"+mpo.getTanggalpesan()+"',"
        +"id_marketing='"+mpo.getId_marketing()+"'")){
        boolean tmp=true;
        for(MD_Full_penjualan mdfp:mpo.getListFull()) {
        tmp=tmp&&db.setDB("insert into full_penjualan set id_produk='"+mdfp.getId_Produk()+"',"
            +" no_nota='"+mpo.getNo_nota()+"',"
            +" banyak='"+mdfp.getBanyak()+"'");
        }
       if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }
       } 
//    }catch(Exception e){
//        System.out.println("kesalannya adalah "+e);
//    }
     }
}

