/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Bo_Mobil;
import Tirta_Maju_Abadi.DataModel.MD_Full_Bo_Mobil;
import Tirta_Maju_Abadi.DataModel.MD_Pegawai;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author putra
 */
public class Model_view_Bo_Mobil {
private DefaultTableModel dtm = new DefaultTableModel();
private DefaultListModel dlm = new DefaultListModel();
private database db;
private loadAllData lD;
private MD_Bo_Mobil mdbm;
 
    public void Model_view_Bo_Mobil(TableModel tm,ListModel lm,database db, loadAllData lD, MD_Bo_Mobil mdbm)
    {
    this.db = db;
    this.lD = lD;
    this.mdbm = mdbm;
    dlm=(DefaultListModel) lm;
    dtm=(DefaultTableModel) tm;
    dtm.setRowCount(0);
    }
    
   
    
    
    public void Insert(){
        if(db.setDB("insert into bo_mobil set "
                + "no_bo='"+mdbm.getNo_bo()+"',"
                + "tanggal='"+mdbm.getTanggal()+"',nopol='"+mdbm.getNopol()+"',"
                + "id_pegawai_acc='"+mdbm.getId_pegawai_acc()+"'")){
            boolean tmp=true;
            for(MD_Full_Bo_Mobil mdb:mdbm.getList_bo())
            {
            tmp=tmp&&db.setDB("insert into ban set "
                + "no_bo='"+mdb.getNo_bo()+"',"
                + "pembayaran='"+mdb.getPembayaran()+"',estimasi='"+mdb.getEstimasi()+"',"
                + "banyak='"+mdb.getBanyak()+"'");
            }
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");    
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void update(){
        if(db.setDB("update bo_mobil set "
                + "no_bo='"+mdbm.getNo_bo()+"',"
                + "tanggal='"+mdbm.getTanggal()+"',nopol='"+mdbm.getNopol()+"',"
                + "id_pegawai_acc='"+mdbm.getId_pegawai_acc()+"'where no_bo ='"+mdbm.getNo_bo()+"'")){
            boolean tmp=true;
            for(MD_Full_Bo_Mobil mdb:mdbm.getList_bo()){
                tmp=tmp&&db.setDB("update ban set "
                + "no_bo='"+mdb.getNo_bo()+"',"
                + "pembayaran='"+mdb.getPembayaran()+"',estimasi='"+mdb.getEstimasi()+"',"
                + "banyak='"+mdb.getBanyak()+"' where no_bo='"+mdb.getNo_bo()+"'");
            }
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public int reset(){
        return lD.getListMD_bo_mobil().getAll().get(lD.getListMD_bo_mobil().getAll().size()-1).getNo_bo()+1;
            
        
    }
    
    public DefaultTableModel getDTM(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
}
