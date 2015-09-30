/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Keluar_gudang_bahan_mentah;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Keluar_gudang_bahan_mentah;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
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
 * @author jepank's
 */
public class Model_view_keluar_gudang_bahan_mentah {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Keluar_gudang_bahan_mentah listMD_keluar_gudang_bahan_mentah;
    private database db;
    private loadAllData lD;
    
    public Model_view_keluar_gudang_bahan_mentah(TableModel dtm, 
            listMD_Keluar_gudang_bahan_mentah listMD_keluar_gudang_bahan_mentah, database db){
            this.dtm=(DefaultTableModel) dtm;
            this.listMD_keluar_gudang_bahan_mentah=listMD_keluar_gudang_bahan_mentah;
            this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    List<list2Values> list=new ArrayList<>();
    public void listSupplier(ModelChuser mc){
        for(MD_Supplier ms:lD.getListMD_Suplier().getList()){
            list.add(new list2Values(ms.getNama(), ms.getId_supplier()));
        }
        mc.setModel(list);
    }
    public void listProduk(ModelChuser mc){
        for(MD_Produk mp:lD.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
            
    
    public void Insert(MD_Keluar_gudang_bahan_mentah md){
        if(db.setDB("insert into keluar_gudang_bahan_mentah set "
                + "Id_supplier='"+md.getId_supplier()+"',"
                + " Banyak='"+md.getBanyak()+"',"
                + " No_urut='"+md.getNo_urut()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil Simpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal Simpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
