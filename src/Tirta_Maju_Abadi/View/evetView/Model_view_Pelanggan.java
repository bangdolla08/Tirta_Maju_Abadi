package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Harga_pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Pelanggan;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Model_view_Pelanggan {
    private DefaultListModel dlm=new DefaultListModel();
    private DefaultTableModel dtm=new DefaultTableModel();
    private database db;
    private loadAllData lD;
    private MD_Pelanggan mdp;
    private JList jl;
    public Model_view_Pelanggan(TableModel tm,JList lm,database db, loadAllData lD, MD_Pelanggan mdp) {
        this.db = db;
        this.lD = lD;
        this.mdp = mdp;
        jl=lm;
        //jl=new JList(dlm);
        dtm=(DefaultTableModel) tm;
        dtm.setRowCount(0);
        reset();
    }
    public void listproduk(ModelChuser mc){
        List<list2Values> list=new ArrayList<>();
        for(MD_Produk mp:lD.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
    
    public int getnextID(){
        return lD.getListMD_Pelanggan().getAll().get(lD.getListMD_Pelanggan().getAll().size()-1).getId_Pelanggan()+1;
    }
    
    public void Insert(){
        if(db.setDB("insert into pelanggan set "
                + "Nama='"+mdp.getNama()+"',"
                + "Alamat='"+mdp.getAlamat()+"',No_telepon='"+mdp.getNo_telepon()+"',"
                + "Tipe_pembayaran='"+mdp.getTipe_pembayaran()+"'")){
            boolean tmp=true;
            for(MD_Harga_pelanggan mhp:mdp.getlistHarga()){
                tmp=tmp&&db.setDB("insert into harga_pelanggan set "
                        + "Id_pelanggan='"+mdp.getId_Pelanggan()+"',"
                        + "Id_produk='"+mhp.getId_produk()+"',Harga='"+mhp.getHarga()+"'");
            }
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                lD.reset();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void addtoTablemodel(MD_Harga_pelanggan mdhp){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mdhp);
        vct.add(mdhp.getHarga());
        dtm.addRow(vct);
        mdp.addListHarga(mdhp);
    }
    
    public void setTableModel(MD_Pelanggan MP){
        int i=1;
        dtm.setRowCount(0);
        for(MD_Harga_pelanggan mhp:MP.getlistHarga()){
            addtoTablemodel(mhp);
        }            
    }
    public void update(){
        if(db.setDB("update pelanggan set "
                + "Nama='"+mdp.getNama()+"',"
                + "Alamat='"+mdp.getAlamat()+"',No_telepon='"+mdp.getNo_telepon()+"',"
                + "Tipe_pembayaran='"+mdp.getTipe_pembayaran()+"' where Id_pelanggan='"+mdp.getId_Pelanggan()+"'")){
            boolean tmp=true;
            for(MD_Harga_pelanggan mhp:mdp.getlistHarga()){
                tmp=tmp&&db.setDB("update harga_pelanggan set "
                        + "Id_pelanggan='"+mdp.getId_Pelanggan()+"',"
                        + "Id_produk='"+mhp.getId_produk()+"',Harga='"+mhp.getHarga()+"' where Id_pelanggan='"+mdp.getId_Pelanggan()+"'");
            }
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                lD.reset();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void reset(){
        int i=0;
        dlm.clear();
        for(MD_Pelanggan tmp:lD.getListMD_Pelanggan().getAll()){
            dlm.add(i, tmp);
        }
        dtm.setRowCount(0);
    }
    
    public DefaultTableModel getDTM(){
        return dtm;
    }
    
    public ListModel getDTL(){
        return dlm;
    }
}
