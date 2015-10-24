/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Bahan_metah;
import Tirta_Maju_Abadi.DataModel.listMD_Bahan_mentah;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
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
public class Model_view_bahan_mentah {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Bahan_mentah listMD_bahan_mentah;
    private MD_Bahan_metah mb;
    private database db;
    private loadAllData lD;
    private MD_Bahan_metah md;
    
    public Model_view_bahan_mentah(TableModel tm, database db, loadAllData lD){
        dtm=(DefaultTableModel) tm;
        this.db=db;
        this.lD=lD;
        this.mb=mb;
        listMD_bahan_mentah=lD.getListMD_Bahan_mentah();
    }
    
    public int reset(){
        lD.setListMD_Bahan_mentah(new listMD_Bahan_mentah(db, lD));
        listMD_bahan_mentah=lD.getListMD_Bahan_mentah();
        return isidata();
    }

    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public int isidata(){
        dtm.setRowCount(0);
        int no=1;
        int lastID=0;
        for(MD_Bahan_metah md:listMD_bahan_mentah.getAll()){
            Vector vct=new Vector();
            vct.add(no);
            vct.add(md.getNama_bahan());
            lastID=md.getId_bahan();
            vct.add(md.getUnit());
            vct.add(md.getStok());
            vct.add(md.getLimit_buffer());
            vct.add(md.getSpesifikasi());
            dtm.addRow(vct);
        }
        return lastID+1;
    }
    
//    public String reset(){
//        id_bahan.setText(listMD_bahan_mentah.getAll().get(listMD_bahan_mentah.getAll().size()-1).getId_bahan());
//        return lD.getListMD_Po_bahan_dasar().getAll().get(lD.getListMD_Po_bahan_dasar().getAll().size()-1).getNo_po()+1;
//    }
    
    public void Insert(){
        if(db.setDB("insert into bahan_mentah set id_bahan='"+md.getId_bahan()+"', "
                + "nama_bahan='"+md.getNama_bahan()+"', "
                + "unit='"+md.getUnit()+"', "
                + "stok='"+md.getStok()+"', "
                + "limit_buffer='"+md.getLimit_buffer()+"', "
                + "spesifikasi='"+md.getSpesifikasi()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void Update(){
        if(db.setDB("update into bahan_mentah set nama_bahan='"+md.getNama_bahan()+"', "
                + "unit='"+md.getUnit()+"', stok='"+md.getStok()+"', "
                + "limit_buffer='"+md.getLimit_buffer()+"', "
                + "spesifikasi='"+md.getSpesifikasi()+"' where Id_bahan='"+md.getId_bahan()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
