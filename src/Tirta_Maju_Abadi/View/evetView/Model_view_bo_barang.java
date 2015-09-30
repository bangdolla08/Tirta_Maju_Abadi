/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Bo_barang;
import Tirta_Maju_Abadi.DataModel.listMD_Bo_barang;
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
public class Model_view_bo_barang {
    private MD_Bo_barang mbb;
    private loadAllData lD;
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Bo_barang listMD_bo_barang;
    private database db;
    
    public Model_view_bo_barang(TableModel tm, database db, loadAllData lD, MD_Bo_barang mbb){
        this.dtm=(DefaultTableModel) tm;
        this.lD=lD;
        this.mbb=mbb;
        this.db=db;
        dtm.setRowCount(0);
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Bo_barang md:listMD_bo_barang.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_bo());
            vct.add(md.getTanggal());
            vct.add(md.getNo_pegawai());
            vct.add(md.getId_pegawai_acc());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Bo_barang md){
        if(db.setDB("insert into bo_barang set no_bo='"+md.getNo_bo()+"', tanggal='"+
                md.getTanggal()+"', no_pegawai='"+md.getNo_pegawai()+"', id_pegawai_acc='"+md.getId_pegawai_acc()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Bo_barang md, String No_bo){
        if(db.setDB("update into bo_barang set tanggal='"+md.getTanggal()+
                "', no_pegawai='"+md.getNo_pegawai()+"', id_pegawai_acc='"+md.getId_pegawai_acc()+
                "' where no_bo='"+No_bo+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
