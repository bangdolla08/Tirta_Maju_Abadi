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

/**
 *
 * @author jepank's
 */
public class Model_view_galon_cacat {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Galon_cacat listMD_galon_cacat;
    private database db;
    
    public Model_view_galon_cacat(TableModel dtm, listMD_Galon_cacat listMD_galon_cacat, database db){
        this.dtm=(DefaultTableModel) dtm;
        this.listMD_galon_cacat=listMD_galon_cacat;
        this.db=db;
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Galon_cacat md:listMD_galon_cacat.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_urut());
            vct.add(md.getTreatment());
            vct.add(md.getPecah());
            dtm.addRow(vct);
        }
    }
    
    public void insertMetode(MD_Galon_cacat md){
        if(db.setDB("insert into galon_cacat set no_urut='"+md.getNo_urut()+"', Treatment='"+
                md.getTreatment()+"', Pecah='"+md.getPecah()+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void editMetode(MD_Galon_cacat md, String No_urut){
        if(db.setDB("update into galon_cacat set Treatment='"+md.getTreatment()+
                "', Pecah='"+md.getPecah()+"' where no_urut='"+No_urut+"'"))
            JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
