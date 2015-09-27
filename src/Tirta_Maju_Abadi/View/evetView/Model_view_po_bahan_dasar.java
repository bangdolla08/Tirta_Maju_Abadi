/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Po_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.listMD_Po_bahan_dasar;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_po_bahan_dasar {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Po_bahan_dasar listMD_po_bahan_dasar;
    private database db;
    
    public Model_view_po_bahan_dasar(TableModel dtm, 
            listMD_Po_bahan_dasar listMD_po_bahan_dasar, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_po_bahan_dasar=listMD_po_bahan_dasar;
        this.db=db;
    }
    
    public DefaultTableModel getModel(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Po_bahan_dasar md:listMD_po_bahan_dasar.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_po());
            vct.add(md.getTanggal());
            vct.add(md.getNo_pegwai());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Po_bahan_dasar md){
        if(db.setDB("insert into Po_bahan_dasar set No_po= '"+md.getNo_po()+"', tanggal='"+md.getTanggal()+
                "', No_pegawai='"+md.getNo_pegwai()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        
    }
    
    public void editMetode(MD_Po_bahan_dasar md, String No_po){
        if(db.setDB("insert into Po_bahan_dasar set tangal='"+md.getTanggal()+"', No_pegawai='"+md.getNo_pegwai()+
                "' where No_po='"+No_po+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
