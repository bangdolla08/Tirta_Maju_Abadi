/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Galon_masuk;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.listMD_Galon_masuk;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.text.SimpleDateFormat;
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
    private MD_Galon_masuk mgm;
    private loadAllData lD;
    private MD_Galon_masuk mdg;
    private MD_Pelanggan mp;
    private SimpleDateFormat ft=new SimpleDateFormat("dd-MM-yyyy");
    
    
    public Model_view_galon_masuk(TableModel tm, database db, loadAllData lD, MD_Pelanggan mp, MD_Galon_masuk mgm){
        dtm=(DefaultTableModel) tm;
        this.mdg=mgm;
        this.db=db;
        this.lD=lD;
        this.mp=mp;
        dtm.setRowCount(0);
        listMD_galon_masuk=lD.getListMD_Galon_masuk();
        reset();
    }
    
    public void reset(){
        lD.setListMD_Galon_masuk(new listMD_Galon_masuk(db, lD));
        listMD_galon_masuk=lD.getListMD_Galon_masuk();
        isidata();
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    private loadAllData lad;
    public void isidata(){
        dtm.setRowCount(0);
        int no=1;
        for(MD_Galon_masuk md:listMD_galon_masuk.getAll()){
            Vector vct=new Vector();
            vct.add(no);
            //vct.add(md);
            vct.add(md.getNo_surat());
            vct.add(md.getBanyak_masuk());
            vct.add(ft.format(md.getTanggal()));
            this.mp=lD.getListMD_Pelanggan().getMDByID(md.getId_pelanggan());
            vct.add(mp.getNama());
            no++;
            dtm.addRow(vct);
        }
    }
    private loadAllData lads;
    public void Insert(MD_Galon_masuk mdg){
        if(db.setDB("insert into galon_masuk set No_surat_jalan='"+mdg.getNo_surat()+"', Banyak_masuk='"+
                mdg.getBanyak_masuk()+"', Tanggal='"+mdg.getTanggal()+"', Id_pelanggan='"+mdg.getId_pelanggan()+"'")){
            boolean tmp=true;
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                lD.reset();
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
}
