/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Galon_masuk;
import Tirta_Maju_Abadi.DataModel.listMD_Galon_masuk;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_galon_masuk {
        private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Galon_masuk listMD_galon_masuk;
    private database db;
    
    public Model_view_galon_masuk(TableModel dtm, listMD_Galon_masuk listMD_galon_masuk, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_galon_masuk=listMD_galon_masuk;
        this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Galon_masuk md:listMD_galon_masuk.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_urut());
            vct.add(md.getBanyak_masuk());
            vct.add(md.getTanggal());
            vct.add(md.getId_pelanggan());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Galon_masuk md){
        if(db.setDB("insert into galon_masuk set no_urut='"+md.getNo_urut()+"', Banyak_masuk='"+
                md.getBanyak_masuk()+"', Tanggal='"+md.getTanggal()+"', Id_pelanggan='"+md.getId_pelanggan()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Galon_masuk md, String No_urut){
        if(db.setDB("update into galon_masuk set Banyak_masuk='"+
                md.getBanyak_masuk()+"', Tanggal='"+md.getTanggal()+"', Id_pelanggan='"+md.getId_pelanggan()+
                "' where no_urut='"+No_urut+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
