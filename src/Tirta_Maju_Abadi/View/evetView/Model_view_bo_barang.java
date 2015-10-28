/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Bo_barang;
import Tirta_Maju_Abadi.DataModel.MD_Full_Bo_barang;
import Tirta_Maju_Abadi.DataModel.MD_Pegawai;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Bo_barang;
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
public class Model_view_bo_barang {
    private MD_Bo_barang mbb;
    private loadAllData lD;
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Bo_barang listMD_bo_barang;
    private database db;
    
    public Model_view_bo_barang(TableModel tm, database db, loadAllData lD, MD_Bo_barang mbb){
        this.dtm=(DefaultTableModel) tm;
        this.lD=lD;
        this.mbb=mbb;
        this.db=db;
        dtm.setRowCount(0);
        reset();
    }
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public void reset(){
        dtm.setRowCount(0);
    }
    
    
    public void setTabel(MD_Full_Bo_barang mfbb){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(mfbb.getMp());
        vct.add(mfbb.getEstimasi_harga());
        dtm.addRow(vct);
        mbb.addlistFull(mfbb);
    }
    
//    public int reset(){
//        return lD.getListMD_bo_barang().getAll().get(lD.getListMD_bo_barang().getAll().size()-1).getNo_bo()+1;
//    }
    
    List<list2Values> list=new ArrayList<>();
    public void list(ModelChuser mc){
         for(MD_Pegawai mp:lD.getListMD_Pegawai().getList()){
            list.add(new list2Values(mp.getNama(), mp.getNo_pegawai()));
        }
        mc.setModel(list);
    }
    
    List<list2Values> listPro=new ArrayList<>();
    public void listProd(ModelChuser mc){
        for(MD_Produk mpro:lD.getListMD_Produk().getAll()){
            listPro.add(new list2Values(mpro.getNama_produk(), mpro.getId_produk()));
        }
        mc.setModel(listPro);
    }
    
    
/*    public void isidata(){
        dtm.setRowCount(0);
        for(MD_Bo_barang md:listMD_bo_barang.getAll()){
            Vector vct=new Vector();
            vct.add(md.getNo_bo());
            vct.add(md.getTanggal());
            vct.add(md.getNo_pegawai());
            vct.add(md.getId_pegawai_acc());
            dtm.addRow(vct);
        }
    }
*/    
    public void Insert(){
        if(db.setDB("insert into bo_barang set no_bo='"+mbb.getNo_bo()+"', tanggal='"+
                mbb.getTanggal()+"', no_pegawai='"+mbb.getNo_pegawai()+"', id_pegawai_acc='"+mbb.getId_pegawai_acc()+"'")){
            boolean tmp=true;
            for(MD_Full_Bo_barang mfb:mbb.getListFull()){
                tmp=tmp&&db.setDB("insert into full_po_bahan_dasar set no_bo='"+mbb.getNo_bo()+"', "
                        + "nama_barang='"+mfb.getNama_barang()+"', estimasi='"+mfb.getEstimasi_harga()+"'");
            }
            if(tmp){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                lD.reset();
            }else{
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan");
            }
        }
    }
}
