/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;
import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Galon_keluar;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.View.Penjualan_depo;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author NEEZAR
 */
public class view_keberangkatan_armada {
    private DefaultTableModel dtm=new DefaultTableModel();
    private database db=new database();
    private listMD_Penjualan_po lmdppo;
    private MD_Penjualan_po mdpo;
    private loadAllData ld;
    private MD_Galon_keluar gk;
    
    public view_keberangkatan_armada(TableModel dtm, listMD_Penjualan_po lmdppo, database db,modelTextFilt total){
        this.dtm=(DefaultTableModel) dtm;
        this.lmdppo=lmdppo;
        this.db=db;
    } 
    
    public DefaultTableModel getdtm(){
        return dtm;
    }

    public void set_TableBawah(MD_Full_penjualan md_full){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(md_full.getMp());
        int bnyk=md_full.getBanyak();
        vct.add(bnyk);
        mdpo.listMD_Full_penjualan(md_full);
        dtm.addRow(vct);
    }
   
    public void list(modelTextFilt mtf){
        List<list2Values> list=new ArrayList<>();
        for(MD_Produk mp:ld.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mtf.setText(list);
    }
    
     public void simpanpenjulanpo(MD_Penjualan_po po){
        db.setDB("insert into penjualan_po set id_marketing='"+mdpo.getId_marketing()+"',"
        +"id_pelanggan='"+mdpo.getId_pelanggan()+"',"
        +"no_nota='"+mdpo.getNo_nota()+"',"
        +"no_po='"+mdpo.getNo_po()+"'");
        
        for(MD_Full_penjualan tmp:mdpo.getListFull()) {
            db.setDB("insert into full_penjualan set id_produk='"+tmp.getId_Produk()+"',"
            +" no_nota='"+mdpo.getNo_nota()+"',"
            +" banyak='"+tmp.getBanyak()+"'");
        }
    } 
}

