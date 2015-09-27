/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Gudang_barang_jadi;
import Tirta_Maju_Abadi.DataModel.listMD_Gudang_barang_jadi;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_gudang_barang_jadi {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Gudang_barang_jadi listMD_gudang_barang_jadi;
    private database db;
    
    public Model_view_gudang_barang_jadi(TableModel dtm, listMD_Gudang_barang_jadi listMD_gudang_barang_jadi, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_gudang_barang_jadi=listMD_gudang_barang_jadi;
        this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Gudang_barang_jadi md:listMD_gudang_barang_jadi.getAll()){
            Vector vct=new Vector(); 
            vct.add(md.getKoordinator());
            vct.add(md.getOperator());
            vct.add(md.getShift());
            vct.add(md.getId_produk());
            vct.add(md.getBanyak());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Gudang_barang_jadi md){
        if(db.setDB("insert into gudang_barang_jadi set Koordinator='"+md.getKoordinator()+"', Operator='"+
                md.getOperator()+"', Shift='"+md.getShift()+"', Id_poduk='"+md.getId_produk()+"', Banyak='"+md.getBanyak()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Gudang_barang_jadi md, String Koordinator){
        if(db.setDB("update into gudang_barang_jadi set Operator='"+md.getOperator()+
                "', Shift='"+md.getShift()+"', Id_poduk='"+md.getId_produk()+
                "', Banyak='"+md.getBanyak()+"' where Koordinator='"+Koordinator+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
