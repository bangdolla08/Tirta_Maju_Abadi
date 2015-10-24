/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Keluar_gudang_bahan_mentah;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.MD_Supplier;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Keluar_gudang_bahan_mentah;
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
public class Model_view_keluar_gudang_bahan_mentah {
    private database db;
    private loadAllData lD;
    private MD_Keluar_gudang_bahan_mentah mkd;
    
    public Model_view_keluar_gudang_bahan_mentah(MD_Keluar_gudang_bahan_mentah mkd, database db,loadAllData lad){
        this.mkd=mkd;
        this.db=db;
        this.lD=lad;
    }

    public void Insert(){
        if(db.setDB("insert into keluar_gudang_bahan_mentah set "
                + "Id_supplier='"+mkd.getId_supplier()+"',"
                + " Banyak='"+mkd.getBanyak()+"',"
                + " No_urut='"+mkd.getNo_urut()+"',"
                + "Id_bahan='"+mkd.getId_bahan()+"'")){
            boolean tmp=true;
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
                lD.reset();
            }
            }else
                JOptionPane.showMessageDialog(null, "Data Gagal diinputkan","Informasi",JOptionPane.INFORMATION_MESSAGE);
    }
}
