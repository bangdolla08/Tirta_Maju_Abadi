/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Keluar_gudang_bahan_mentah;
import Tirta_Maju_Abadi.DataModel.listMD_Keluar_gudang_bahan_mentah;
import Tirta_Maju_Abadi.toll.database;
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
    
    public Model_view_keluar_gudang_bahan_mentah(TableModel dtm, 
            listMD_Keluar_gudang_bahan_mentah listMD_keluar_gudang_bahan_mentah, database db){
            this.dtm=(DefaultTableModel) dtm;
            this.listMD_keluar_gudang_bahan_mentah=listMD_keluar_gudang_bahan_mentah;
            this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Keluar_gudang_bahan_mentah md:listMD_keluar_gudang_bahan_mentah.getAll()){
            Vector vct=new Vector();
            vct.add(md.getId_supplier());
            vct.add(md.getBanyak());
            vct.add(md.getNo_urut());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Keluar_gudang_bahan_mentah md){
        if(db.setDB("insert into keluar_gudang_bahan_mentah set Id_supplier='"+md.getId_supplier()+
                "', Banyak='"+md.getBanyak()+"', No_urut='"+md.getNo_urut()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Keluar_gudang_bahan_mentah md, String No_urut){
        if(db.setDB("update into keluar_gudang_bahan_mentah set Id_supplier='"+md.getId_supplier()+
                "', Banyak='"+md.getBanyak()+"' where No_urut='"+No_urut+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
