/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_penjualan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.MD_Produk;
import Tirta_Maju_Abadi.DataModel.list2Values;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import Tirta_Maju_Abadi.View.ModelSwing.modelTextFilt;
import Tirta_Maju_Abadi.View.Penjualan_depo;
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
 * @author NEEZAR
 */
public class View_penjualan_po {
    
    private DefaultTableModel dtm=new DefaultTableModel();
    private listMD_Penjualan_po listmD_penjulanPO;
    private database db;
    private MD_Penjualan_po mdp;
    private modelTextFilt totalText;
    private loadAllData lD;
    private modelTextFilt textfiltNoNota;
    
    public View_penjualan_po(TableModel dtm, listMD_Penjualan_po listmD_Penjualan_po, database db,modelTextFilt total){
        this.dtm=(DefaultTableModel) dtm;
        this.listmD_penjulanPO=listmD_Penjualan_po;
        this.db=db;
    } 
    
    public DefaultTableModel getdtm(){
        return dtm;
    }
    
    public String reset(){
        dtm.setRowCount(0);
        //listmD_penjulanPO.getAll().size();
        return "Ngikuti Peraturan No PO";
    }
    
    public void set_TableBawah(MD_Full_penjualan md_full){
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(md_full.getMD_produk().getNama_produk());
        int bnyk=md_full.getBanyak(),harga=Integer.parseInt(mdp.getHarga(md_full.getId_Produk()).getHarga());
        vct.add(harga);
        vct.add(bnyk);
        vct.add(harga*bnyk);
        totalText.setText(totalText.getInteger()+(harga*bnyk));
        mdp.listMD_Full_penjualan(md_full);
        dtm.addRow(vct);
    }
   
     public void list(ModelChuser mc){
        List<list2Values> list=new ArrayList<>();
        for(MD_Produk mp:lD.getListMD_Produk().getAll()){
            list.add(new list2Values(mp.getNama_produk(), mp.getId_produk()));
        }
        mc.setModel(list);
    }
    
    public void simpanpenjulanpo(MD_Penjualan_po po){
        db.setDB("insert into penjualan_po set id_marketing='"+mdp.getId_marketing()+"',"
        +"id_pelanggan='"+mdp.getId_pelanggan()+"',"
        +"no_nota='"+mdp.getNo_nota()+"',"
        +"no_po='"+mdp.getNo_po()+"'");
        
        for(MD_Full_penjualan tmp:mdp.getListFull()) {
            db.setDB("insert into full_penjualan set id_produk='"+tmp.getId_Produk()+"',"
            +" no_nota='"+mdp.getNo_nota()+"',"
            +" banyak='"+tmp.getBanyak()+"'");
        }
    } 
}
