/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.listMD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_datang_barang_dasar {
    private DefaultListModel dlm=new DefaultListModel();
    private DefaultTableModel dtm=new DefaultTableModel();
    private loadAllData lD;
    private database db;
    private MD_Datang_bahan_dasar mdbd;
    
    public Model_view_datang_barang_dasar(TableModel tm, 
            ListModel lm, database db, loadAllData lD, MD_Datang_bahan_dasar mdbd){
        this.db=db;
        this.lD=lD;
        this.mdbd=mdbd;
        this.dlm=(DefaultListModel) dlm;
        this.dtm=(DefaultTableModel) tm;
        dtm.setRowCount(0);
        
    }
    
    public int getNextID(){
        return lD.getListMD_Datang_bahan_dasar().getAll().get(lD.getListMD_Datang_bahan_dasar().getAll().size()-1).getId_bahan()+1;
    }
    
    
    public DefaultTableModel getDtm(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
    
    public void reset(){
        for(MD_Datang_bahan_dasar tmp:lD.getListMD_Datang_bahan_dasar().getAll()){
            dlm.addElement(tmp);
        }
        dtm.setRowCount(0);
    }
    
/*    public void isidata(){
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
    }*/
    
//    public void Insert(){
//        if(db.setDB("insert into datang_bahan_dasar set No_masuk='"+mdbd.getNo_masuk()+
//                "', No_po='"+mdbd.getNo_po()+"', id_bahan='"+mdbd.getId_bahan()+"', Banyak='"+mdbd.getBanyak()+
//                "', Surat_jalan='"+mdbd.getSurat_jalan()+"', Fisik='"+mdbd.getFisik()+"', Id_supplier='"+mdbd.getId_supplier()+"'"))
//            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//        else
//            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//    }
    
//    public void editMetode(MD_Datang_bahan_dasar md, String No_masuk){
//        if(db.setDB("update into datang_bahan_dasar set No_po='"+md.getNo_po()+
//                "', id_bahan='"+md.getId_bahan()+"', Banyak='"+md.getBanyak()+
//                "', Surat_jalan='"+md.getSurat_jalan()+"', Fisik='"+md.getFisik()+"', "
//                + "Id_supplier='"+md.getId_supplier()+"' where No_masuk='"+No_masuk+'"'))
//            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//        else
//            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
//    }
}
