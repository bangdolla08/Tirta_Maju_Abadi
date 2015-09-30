/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jepank's
 */
public class listMD_full_bahan_dasar_datang {
    private database db;
    private ResultSet rs;
    private List<MD_Full_po_bahan_dasar_datang> listDB=new ArrayList<MD_Full_po_bahan_dasar_datang>();
    
    public listMD_full_bahan_dasar_datang(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Full_po_bahan_dasar_datang(rs.getInt("No_masuk"), 
                        rs.getInt("Id_barang_dasar_datang"), 
                        rs.getInt("Banyak"),
                        rs.getInt("Fisik")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
     public listMD_full_bahan_dasar_datang(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from full_po_bahan_dasar_datang");
            while(rs.next()){
                listDB.add(new MD_Full_po_bahan_dasar_datang(rs.getInt("No_masuk"), 
                        rs.getInt("Id_barang_dasar_datang"), 
                        rs.getInt("Banyak"),
                        rs.getInt("Fisik")));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
      public MD_Full_po_bahan_dasar_datang getByNo(int No_masuk,int Id_barang){
        MD_Full_po_bahan_dasar_datang pilih=new MD_Full_po_bahan_dasar_datang();
        for(MD_Full_po_bahan_dasar_datang mdfp : listDB){
            if(mdfp.getNo_masuk()==No_masuk&&mdfp.getId_barang_dasar_datang()==Id_barang){
                pilih=mdfp;
                break;
            }
        }
        return pilih;
    }
     
    public MD_Full_po_bahan_dasar_datang getMDByID(int No_masuk){
        MD_Full_po_bahan_dasar_datang pilih=new MD_Full_po_bahan_dasar_datang();
        for(MD_Full_po_bahan_dasar_datang mdfp : listDB){
            if(mdfp.getNo_masuk()==No_masuk){
                pilih=mdfp;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Full_po_bahan_dasar_datang> getAll(){
        return listDB;
    }
}
