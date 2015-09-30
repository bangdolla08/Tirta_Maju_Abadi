/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Bahan_metah;
import Tirta_Maju_Abadi.DataModel.listMD_Bahan_mentah;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.toll.database;
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
    private database db;
    private modelTextFilt id_bahan;
    
    public Model_view_bahan_mentah(TableModel dtm, 
            listMD_Bahan_mentah listMD_bahan_mentah, database db, modelTextFilt id_bahan){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_bahan_mentah=listMD_bahan_mentah;
        this.db=db;
        this.id_bahan=id_bahan;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Bahan_metah md:listMD_bahan_mentah.getAll()){
            Vector vct=new Vector();
            vct.add(dtm.getRowCount()+1);
            vct.add(md.getNama_bahan());
            vct.add(md.getUnit());
            vct.add(md.getStok());
            vct.add(md.getLimit_buffer());
            vct.add(md.getSpesifikasi());
            dtm.addRow(vct);
        }
    }
    
    public void reset(){
        id_bahan.setText(listMD_bahan_mentah.getAll().get(listMD_bahan_mentah.getAll().size()-1).getId_bahan());
    }
    
    public void Insert(MD_Bahan_metah md){
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
    
    public void Update(MD_Bahan_metah md, String Id_bahan){
        if(db.setDB("update into bahan_mentah set nama_bahan='"+md.getNama_bahan()+"', "
                + "unit='"+md.getUnit()+"', stok='"+md.getStok()+"', "
                + "limit_buffer='"+md.getLimit_buffer()+"', "
                + "spesifikasi='"+md.getSpesifikasi()+"' where Id_bahan='"+Id_bahan+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
