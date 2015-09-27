/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.listMD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_datang_barang_dasar {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Datang_bahan_dasar listMD_datang_barang_dasar;
    private database db;
    
    public Model_view_datang_barang_dasar(TableModel dtm, 
            listMD_Datang_bahan_dasar listMD_datang_barang_dasar, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_datang_barang_dasar=listMD_datang_barang_dasar;
        this.db=db;
    }
    
    public DefaultTableModel getDtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Datang_bahan_dasar md:listMD_datang_barang_dasar.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_masuk());
            vct.add(md.getNo_po());
            vct.add(md.getId_bahan());
            vct.add(md.getBanyak());
            vct.add(md.getSurat_jalan());
            vct.add(md.getFisik());
            vct.add(md.getId_supplier());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Datang_bahan_dasar md){
        if(db.setDB("insert into datang_bahan_dasar set No_masuk='"+md.getNo_masuk()+
                "', No_po='"+md.getNo_po()+"', id_bahan='"+md.getId_bahan()+"', Banyak='"+md.getBanyak()+
                "', Surat_jalan='"+md.getSurat_jalan()+"', Fisik='"+md.getFisik()+"', Id_supplier='"+md.getId_supplier()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Datang_bahan_dasar md, String No_masuk){
        if(db.setDB("update into datang_bahan_dasar set No_po='"+md.getNo_po()+
                "', id_bahan='"+md.getId_bahan()+"', Banyak='"+md.getBanyak()+
                "', Surat_jalan='"+md.getSurat_jalan()+"', Fisik='"+md.getFisik()+"', "
                + "Id_supplier='"+md.getId_supplier()+"' where No_masuk='"+No_masuk+'"'))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
