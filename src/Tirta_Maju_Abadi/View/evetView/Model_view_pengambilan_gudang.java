/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_pengambilan_gudang;
import Tirta_Maju_Abadi.DataModel.MD_Pengambilan_gudang;
import Tirta_Maju_Abadi.DataModel.listMD_pengambilan_gudang;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_pengambilan_gudang {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_pengambilan_gudang lsp;
    private database db;
    private loadAllData lD;
    private MD_Pengambilan_gudang mp;
    private listMD_pengambilan_gudang listMD_Pengambilan;
    
    public Model_view_pengambilan_gudang(TableModel tm, database db, loadAllData lD, MD_Pengambilan_gudang mp){
        this.dtm=(DefaultTableModel)tm;
        this.db=db;
        this.mp=mp;
        this.lD=lD;
        dtm.setRowCount(0);
        reset();
    }
    
    public void reset(){
        dtm.setRowCount(0);
    }
    
    public void setTabel(MD_Full_pengambilan_gudang mpg){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mpg.getMdp());
        vct.add(mpg.getMsup());
        vct.add(mpg.getBanyak());
        dtm.addRow(vct);
        mp.addToList(mpg);
    }
    
    public void Insert(){
        boolean tmp=false;
        for(MD_Full_pengambilan_gudang mfp : mp.getListFullDb()){
            if(db.setDB("insert into pengambilan_gudang set Tanggal='"+mp.getTanggal()+"', "
                + "Id_pegawai='"+mp.getId_pegawai()+"', Id_barang='"+mfp.getId_barang()+"',"
                + "Id_supplier='"+mfp.getId_supplier()+"', Banyak='"+mfp.getBanyak()+"'")){
                tmp=true;
            }
        }
            if(tmp){
               JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
               lD.reset();
            }else
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
    }
}