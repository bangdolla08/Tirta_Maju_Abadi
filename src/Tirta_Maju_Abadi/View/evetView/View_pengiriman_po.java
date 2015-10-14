/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Tirta_Maju_Abadi.DataModel.MD_Galon_keluar;

/**
 *
 * @author NEEZAR
 */
public class View_pengiriman_po {
    private DefaultTableModel dtm=new DefaultTableModel();
    private database db=new database();
    private listMD_Penjualan_po lmdppo;
    private MD_Penjualan_po mdpo;
    private loadAllData ld;
    private MD_Galon_keluar gk;
    
    public View_pengiriman_po(TableModel tm, listMD_Penjualan_po lmdppo,database db){
        this.dtm=(DefaultTableModel) tm;
        this.lmdppo=lmdppo;
        this.db=db;
        dtm.setRowCount(0);
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void set_table(MD_Full_penjualan md_full){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(md_full.getMD_produk().getNama_produk());
        vct.add(md_full.getBanyak());
        mdpo.listMD_Full_penjualan(md_full);
        dtm.addRow(vct);
    }
    
     public void list(ModelChuser mc){
        List<list2Values> list=new ArrayList<>();
        for(MD_Produk mp:ld.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
     
     public void simpan_produkGalon(){
         db.setDB("insert into galon_keluar set No_surat_jalan='"+gk.getNo_surat_jalan()+"',"
                 + "Banyak_keluar='"+gk.getBanyak_keluar()+"',"
                 + "Tanggal='"+gk.getTanggal()+"',"
                 + "Id_pelanggan='"+gk.getId_pelanggan()+"'");
     }
     
      
}
