/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Gudang_barang_jadi;
import Tirta_Maju_Abadi.DataModel.MD_Pegawai;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Gudang_barang_jadi;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jepank's
 */
public class Model_view_gudang_barang_jadi {
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Gudang_barang_jadi listMD_gudang_barang_jadi;
    private database db;
    private loadAllData lD;
    private MD_Gudang_barang_jadi md;
    
    public Model_view_gudang_barang_jadi(){
    }
    
    public Model_view_gudang_barang_jadi(MD_Gudang_barang_jadi mgb, database db, loadAllData lD){
        this.md=mgb;
        this.db=db;
        this.lD=lD;
    }
    
    public void Insert(){
        if(db.setDB("insert into gudang_barang_jadi set Koordinator='"+md.getKoordinator()+"', Operator='"+
                md.getOperator()+"', Grup='"+md.getGrup()+"', Id_produk='"+md.getId_produk()+"', Banyak='"+md.getBanyak()+"' ")){
            boolean tmp=true;
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                lD.reset();
            }
        }else
            JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
}
