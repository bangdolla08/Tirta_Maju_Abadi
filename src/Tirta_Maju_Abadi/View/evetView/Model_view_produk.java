package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.listMD_Produk;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Model_view_produk {
    private MD_Produk md_poroduk=new MD_Produk();
    private DefaultTableModel dtm;
    private database db;
    private loadAllData lad;
    private listMD_Produk litProduk;
    
    public Model_view_produk(TableModel dtm, database db, loadAllData lad) {
        this.dtm = (DefaultTableModel) dtm;
        this.db = db;
        this.lad = lad;
        litProduk=lad.getListMD_Produk();
    }
    
    public int reset(){
        return setIsiDataBase();
    }
    
    public DefaultTableModel getDtm(){
        return dtm;
    }
    
    private int setIsiDataBase(){
        dtm.setRowCount(0);
        
        int no=1;
        int lastID=0;
        for(MD_Produk tmpProduk:litProduk.getAll()){
            Vector vct=new Vector();
            vct.add(no);
            
            vct.add(tmpProduk.getId_produk());
            lastID=tmpProduk.getId_produk();
            vct.add(tmpProduk);
            vct.add(tmpProduk.getHarga_pokok());
            dtm.addRow(vct);
        }
        return lastID+1;
    }
    public void setMD_Produk(MD_Produk tmp){
        db.setDB("insert into produk set "
                + "Id_produk='"+tmp.getId_produk()+"', "
                + "Nama_produk='"+tmp.getNama_produk()+"',"
                + "Harga_pokok='"+tmp.getHarga_pokok()+"'");
    }
    public void setUpdateMD_Produk(MD_Produk tmp){
        db.setDB("update produk set "
                + "Id_produk='"+tmp.getId_produk()+"', "
                + "Nama_produk='"+tmp.getNama_produk()+"',"
                + "Harga_pokok='"+tmp.getHarga_pokok()+"' where Id_produk='"+tmp.getId_produk()+"'");
    }
}
