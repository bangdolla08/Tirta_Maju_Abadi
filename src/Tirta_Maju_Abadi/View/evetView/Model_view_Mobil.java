/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Ban;
import Tirta_Maju_Abadi.DataModel.MD_Mobil;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author putra
 */
public class Model_view_Mobil {
private DefaultTableModel dtm = new DefaultTableModel();
private DefaultListModel dlm = new DefaultListModel();
private database db;
private loadAllData lD;
private MD_Mobil mdm;
private MD_Ban mdb;

public Model_view_Mobil(TableModel tm,database db, loadAllData lD, MD_Mobil mdm)
    {
    this.db = db;
    this.lD = lD;
    this.mdm = mdm;
    dtm=(DefaultTableModel) tm;
    dtm.setRowCount(0);   
    }

    
    public void Insert(){
        if(db.setDB("insert into mobil set "
                + "nopol='"+mdm.getNopol()+"',"
                + "type='"+mdm.getType()+"',driver='"+mdm.getDriver()+"',"
                + "helper='"+mdm.getHelper()+"'")){
            boolean tmp=true;
            for(MD_Ban mdb:mdm.getListFull())
            {
            tmp=tmp&&db.setDB("insert into ban set "
                + "nopol='"+mdb.getNopol()+"',"
                + "noseri='"+mdb.getNoseri()+"',posisi='"+mdb.getPosisi()+"',"
                + "tgl_pasang='"+mdb.getTgl_pasang()+"'");
            }
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");    
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void update(){
        if(db.setDB("update mobil set "
                + "nopol='"+mdm.getNopol()+"',"
                + "type='"+mdm.getType()+"',driver='"+mdm.getDriver()+"',"
                + "helper='"+mdm.getHelper()+"'where nopol ='"+mdm.getNopol()+"'")){
            boolean tmp=true;
            for(MD_Ban mdb:mdm.getListFull()){
                tmp=tmp&&db.setDB("update ban set "
                + "nopol='"+mdb.getNopol()+"',"
                + "noseri='"+mdb.getNoseri()+"',posisi='"+mdb.getPosisi()+"',"
                + "tgl_pasang='"+mdb.getTgl_pasang()+"' where nopol='"+mdm.getNopol()+"'");
            }
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void reset(){
        int i=0;
        dlm.clear();
        for(MD_Mobil tmp:lD.getListMD_Mobil().getAll()){
            dlm.add(i, tmp);
        }
        dtm.setRowCount(0);
    }
    
    public void SetTable(MD_Mobil mobil)
    {
        Vector vct = new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mobil.getNopol());
        vct.add(mobil.getDriver()+"&"+mobil.getHelper());
        vct.add(mobil.getType());
        dtm.addRow(vct);
        
    }
    
    public DefaultTableModel getDTM(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
    
    public void listDriver(ModelChuser mc){
        List<list2Values> list=new ArrayList<>();
        for(MD_Mobil md:lD.getListMD_Mobil().getAll()){
            list.add(new list2Values(md.getDriver()));
        }
        mc.setModel(list);
    }
}
