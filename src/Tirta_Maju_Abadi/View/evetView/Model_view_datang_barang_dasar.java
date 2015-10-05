/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Datang_bahan_dasar;
import Tirta_Maju_Abadi.DataModel.MD_Full_datang_Bahan_dasar;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Datang_bahan_dasar;
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
 * @author jepank's
 */
public class Model_view_datang_barang_dasar {
    private DefaultListModel dlm=new DefaultListModel();
    private DefaultTableModel dtm=new DefaultTableModel();
    private loadAllData lD;
    private database db;
    private MD_Datang_bahan_dasar mdbd;
    
    public Model_view_datang_barang_dasar(TableModel tm,database db, loadAllData lD, MD_Datang_bahan_dasar mdbd){
        this.db=db;
        this.lD=lD;
        this.mdbd=mdbd;
        this.dlm=(DefaultListModel) dlm;
        this.dtm=(DefaultTableModel) tm;
        dtm.setRowCount(0);
        
    }
    
    public void setTabel(MD_Full_datang_Bahan_dasar mdfd){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mdfd.getMD_Produk().getNama_produk());
        vct.add(mdfd.getBanyak());
        vct.add(mdfd.getFisik());
        dtm.addRow(vct);
    }
    
    List<list2Values> listSp=new ArrayList<>();
    public void listSup(ModelChuser mc){
         for(MD_Supplier ms:lD.getListMD_Suplier().getList()){
            listSp.add(new list2Values(ms.getNama(), ms.getId_supplier()));
        }
        mc.setModel(listSp);
    }
    
    List<list2Values> listProd=new ArrayList<>();
    public void listProd(ModelChuser mc){
         for(MD_Produk mp:lD.getListMD_Produk().getAll()){
            listProd.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(listProd);
    }
    
    public int getNextID(){
        return lD.getListMD_Datang_bahan_dasar().getAll().get(lD.getListMD_Datang_bahan_dasar().getAll().size()-1).getId_bahan()+1;
    }
    
    
    public DefaultTableModel getDtm(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
    
//    public void reset(){
//        for(MD_Datang_bahan_dasar tmp:lD.getListMD_Datang_bahan_dasar().getAll()){
//            dlm.addElement(tmp);
//        }
//        dtm.setRowCount(0);
//    }
    

    
    public void Insert(){
        if(db.setDB("insert into datang_bahan_dasar set No_masuk='"+mdbd.getNo_masuk()+
                "', No_po='"+mdbd.getNo_po()+"', id_bahan='"+mdbd.getId_bahan()+"', "
                + "Banyak='"+mdbd.getBanyak()+"', "
                + "Surat_jalan='"+mdbd.getSurat_jalan()+"'")){
            boolean tmp=true;
            for(MD_Full_datang_Bahan_dasar mfp:mdbd.getListDatang_bahan()){
                tmp=tmp&&db.setDB("insert into full_po_bahan_dasar_datang set "
                        + "No_masuk='"+mdbd.getNo_masuk()+"', "
                        + "Id_barang_dasar_datang='"+mdbd.getId_bahan()+"',"
                        + "Banyak='"+mdbd.getBanyak()+"',"
                        + "Fisik='"+mfp.getFisik()+"'");
            }
            if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            }
        }
    }
    
    public void Update(){
        if(db.setDB("update into datang_bahan_dasar set No_po='"+mdbd.getNo_po()+"', id_bahan='"+mdbd.getId_bahan()+"', Banyak='"+mdbd.getBanyak()+
                "', Surat_jalan='"+mdbd.getSurat_jalan()+"' where "
                + "No_masuk='"+mdbd.getNo_masuk()+"'")){
            boolean tmp=true;
            for(MD_Full_datang_Bahan_dasar mfp:mdbd.getListDatang_bahan()){
                tmp=tmp&&db.setDB("update into full_po_bahan_dasar_datang set "
                        + "Id_barang_dasar_datang='"+mdbd.getId_bahan()+"', "
                        + "Banyak='"+mdbd.getBanyak()+"',"
                        + "Fisik='"+mfp.getFisik()+"' where No_masuk='"+mdbd.getNo_masuk()+"'");
            }
            if(!tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal Diubah");
            }
        }
    }
}
