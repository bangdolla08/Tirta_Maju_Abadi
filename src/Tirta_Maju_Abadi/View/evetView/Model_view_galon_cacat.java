/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Galon_cacat;
import Tirta_Maju_Abadi.DataModel.listMD_Galon_cacat;
import Tirta_Maju_Abadi.toll.database;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Tirta_Maju_Abadi.DataModel.MD_Galon_masuk;
import Tirta_Maju_Abadi.DataModel.MD_Galon_masuk;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jepank's
 */
public class Model_view_galon_cacat {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Galon_cacat listMD_galon_cacat;
    private database db;
    private MD_Galon_masuk g_masuk=new MD_Galon_masuk();
    private MD_Galon_cacat g_cacat=new MD_Galon_cacat();
    private loadAllData lD;
    
    public Model_view_galon_cacat(TableModel tm, listMD_Galon_cacat listMD_galon_cacat, database db,loadAllData lD){
        this.dtm=(DefaultTableModel) tm;
        this.db=db;
        this.lD=lD;
        this.g_cacat=g_cacat;
        dtm.setRowCount(0);
        this.listMD_galon_cacat=listMD_galon_cacat;
        listGanlonGan.clear();
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
     public void reset(){
        lD.setListMD_Galon_cacat(new listMD_Galon_cacat(db, lD));
        listMD_galon_cacat=lD.getListMD_Galon_cacat();
    }
    private List<MD_Galon_cacat> listGanlonGan=new ArrayList<MD_Galon_cacat>();
    public void isidata(MD_Galon_cacat mg_c){
        //dtm.setRowCount(0);
        listGanlonGan.add(mg_c);
        Vector vct=new Vector();
        vct.add(mg_c.getNo_surat_jalan());
        vct.add(mg_c.getBanyak());
        vct.add(mg_c.getTreatment());
        vct.add(mg_c.getPecah());
        dtm.addRow(vct);
    }
    
    public void insertMetode(){
//        System.out.println("insert into galon_cacat set no_surat_jalan='"+g_cacat.getNo_urut()+"', Treatment="+
//                g_cacat.getTreatment()+", Pecah="+g_cacat.getPecah()+",banyak='"+g_cacat.getBanyak()+"'");
        for(MD_Galon_cacat mdfp:listGanlonGan){
            if(db.setDB("insert into galon_cacat set no_surat_jalan='"+mdfp.getNo_surat_jalan()+"', Treatment="+
                    mdfp.getTreatment()+", Pecah="+mdfp.getPecah()+",banyak='"+mdfp.getBanyak()+"'")){
                JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
            }else
                JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void editMetode(MD_Galon_cacat md, String sj){
        if(db.setDB("update into galon_cacat set Treatment='"+md.getTreatment()+
                "', Pecah='"+md.getPecah()+"' where no_surat_jalan='"+sj+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
