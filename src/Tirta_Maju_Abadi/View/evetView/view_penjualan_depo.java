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
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.listMD_Full_penjualan;
import java.util.Vector;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import java.util.ArrayList;
import java.util.List;
import Tirta_Maju_Abadi.DataModel.list2Values;
/**
 *
 * @author NEEZAR
 */
public class view_penjualan_depo {
    private DefaultTableModel dtm;
    private database db;
    private loadAllData ld;
    private listMD_Penjualan_po lppo;
    private MD_Penjualan_po mpo;
    private modelTextFilt total;
    private modelTextFilt pembayaran;
    private modelTextFilt kembalian;
    
    public view_penjualan_depo(TableModel dtm, listMD_Penjualan_po lppo, database db, modelTextFilt mtf){
       this.dtm=(DefaultTableModel) dtm;
       this.lppo=lppo;
       this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void set_table(MD_Full_penjualan mfp){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mfp.getMD_produk().getNama_produk());
        int banyak=mfp.getBanyak(),harga=mpo.getHarga(mfp.getId_Produk()).getHarga();
        vct.add(banyak);
        vct.add(harga);
        vct.add(banyak*harga);
       total.setText(total.getInteger()+harga*banyak);
        pembayaran.setText(pembayaran.getInteger());
        kembalian.setText(pembayaran.getInteger()-total.getInteger());
        mpo.listMD_Full_penjualan(mfp);
        dtm.addRow(vct);
    }
    List<list2Values> list=new ArrayList<>();
    public void list(ModelChuser mc){
        //List<list2Values> list=new ArrayList<>();
         for(MD_Produk mp:ld.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
    
     public void simpanpenjulanpo(MD_Penjualan_po mp){
         mpo=mp;
        db.setDB("insert into penjualan_po set id_marketing='"+mpo.getId_marketing()+"',"
        +"id_pelanggan='"+mpo.getId_pelanggan()+"',"
        +"no_nota='"+mpo.getNo_nota()+"',"
        +"no_po='"+mpo.getNo_po()+"'");
        
        for(MD_Full_penjualan tmp:mpo.getListFull()) {
            db.setDB("insert into full_penjualan set id_produk='"+tmp.getId_Produk()+"',"
            +" no_nota='"+mpo.getNo_nota()+"',"
            +" banyak='"+tmp.getBanyak()+"'");
        }
    } 
}
