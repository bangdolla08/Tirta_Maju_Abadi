package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Harga_pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import javax.swing.DefaultListModel;
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

    public Model_view_Pelanggan(TableModel tm,ListModel lm,database db, loadAllData lD, MD_Pelanggan mdp) {
        this.db = db;
        this.lD = lD;
        this.mdp = mdp;
        dlm=(DefaultListModel) lm;
        dtm=(DefaultTableModel) tm;
        dtm.setRowCount(0);
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
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
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
            if(!tmp)
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
        }
    }
    
    public void reset(){
        for(MD_Pelanggan tmp:lD.getListMD_Pelanggan().getAll()){
            dlm.addElement(tmp);
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
