/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_po_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.MD_Po_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.listMD_Po_bahan_dasar;
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
public class Model_view_po_bahan_dasar {
    private DefaultListModel dlm=new DefaultListModel();
    private MD_Po_bahan_dasar mpb;
    private loadAllData lD;
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Po_bahan_dasar listMD_po_bahan_dasar;
    private database db;
    
    public Model_view_po_bahan_dasar(TableModel tm, database db, loadAllData lD, MD_Po_bahan_dasar mpb){
        this.lD=lD;
        this.mpb=mpb;
        dtm=(DefaultTableModel) tm;
        this.db=db;
        dtm.setRowCount(0);
    }
    
    public int getNextID(){
        no.setText(lmp.getList().get(lmp.getList().size()-1).getNo_pegawai());
        return lD.getListMD_Po_bahan_dasar().getAll().get(lD.getListMD_Bahan_mentah().getAll().size()-1).getNo_pegwai()+1;
    }
    
    
    public DefaultTableModel getModel(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
    
    
    public void Insert(){
        if(db.setDB("insert into Po_bahan_dasar set No_po= '"+mpb.getNo_po()+"', tanggal='"+mpb.getTanggal()+
                "', No_pegawai='"+mpb.getNo_pegwai()+"'")){
            boolean tmp=true;
            for(MD_Full_po_bahan_dasar mfp:mpb.getListfullDB()){
                tmp=tmp&&db.setDB("insert into full_po_bahan_dasar set No_po='"+mpb.getNo_po()+
                        "', id_barang='"+mfp.getId_barang()+"', banyak='"+mfp.getBanyak()+"', Rencana_kirim='"+mfp.getRencana_kirim()+"'");
            }
            if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            }
        }
    }

        public void Update(){
        if(db.setDB("update into Po_bahan_dasar set tanggal='"+mpb.getTanggal()+
                "', No_pegawai='"+mpb.getNo_pegwai()+"' where No_po= '"+mpb.getNo_po()+"'")){
            boolean tmp=true;
            for(MD_Full_po_bahan_dasar mfp:mpb.getListfullDB()){
                tmp=tmp&&db.setDB("update into full_po_bahan_dasar set id_barang='"+mfp.getId_barang()+"', banyak='"+mfp.getBanyak()+
                        "', Rencana_kirim='"+mfp.getRencana_kirim()+"' where No_po='"+mpb.getNo_po()+"'");
            }
            if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
        }
    }
}
