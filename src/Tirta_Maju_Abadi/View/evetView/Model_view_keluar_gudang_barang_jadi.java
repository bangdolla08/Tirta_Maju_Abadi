/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Keluar_gudang_bahan_jadi;
import Tirta_Maju_Abadi.DataModel.listMD_Keluar_gudang_bahan_jadi;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_keluar_gudang_barang_jadi {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Keluar_gudang_bahan_jadi listMD_keluar_gudang_bahan_jadi;
    private database db;
    
    
    public Model_view_keluar_gudang_barang_jadi(TableModel dtm, 
            listMD_Keluar_gudang_bahan_jadi listMD_keluar_gudang_bahan_jadi, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_keluar_gudang_bahan_jadi=listMD_keluar_gudang_bahan_jadi;
        this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Keluar_gudang_bahan_jadi md:listMD_keluar_gudang_bahan_jadi.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_nota());
            vct.add(md.getNo_surat_jalan());
            vct.add(md.getBanyak());
            vct.add(md.getNopol());
            vct.add(md.getId_produk());
            dtm.addRow(vct);
        }
    }
    
    public void Insert(MD_Keluar_gudang_bahan_jadi md){
        if(db.setDB("insert into keluar_gudang_barang_jadi set No_nota='"+md.getNo_nota()+
                "', No_surat_jalan='"+md.getNo_surat_jalan()+"', Banyak='"+md.getBanyak()+
                "', Nopol='"+md.getNopol()+"', Id_produk='"+md.getId_produk()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
//    public void editMetode(MD_Keluar_gudang_bahan_jadi md, String No_surat_jalan){
//        if(db.setDB("update into keluar_gudang_barang_jadi set No_nota='"+md.getNo_nota()+
//                "', Banyak='"+md.getBanyak()+"', Nopol='"+md.getNopol()+
//                "', Id_produk='"+md.getId_produk()+"' where No_surat_jalan='"+No_surat_jalan+"'"))
//            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//        else
//            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//    }
}
