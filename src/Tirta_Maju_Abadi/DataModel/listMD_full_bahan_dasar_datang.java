/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
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
    private List<MD_Full_datang_Bahan_dasar> listDB=new ArrayList<MD_Full_datang_Bahan_dasar>();
    
    public listMD_full_bahan_dasar_datang(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Full_datang_Bahan_dasar(rs.getInt("Id_barang_dasar_datang"),
                        rs.getInt("Banyak"),
                        rs.getInt("Fisik")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    private loadAllData lad;
     public listMD_full_bahan_dasar_datang(database db, loadAllData lad){
        this.db=db;
        this.lad=lad;
        listDB.clear();
        try {
            rs=db.getRs("select * from full_po_bahan_dasar_datang");
            while(rs.next()){
                listDB.add(new MD_Full_datang_Bahan_dasar(rs.getInt("Id_barang_dasar_datang"),
                        rs.getInt("Banyak"),
                        rs.getInt("Fisik")));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
      public MD_Full_datang_Bahan_dasar getByNo(int No_po,int Id_barang){
        MD_Full_datang_Bahan_dasar pilih=new MD_Full_datang_Bahan_dasar();
        for(MD_Full_datang_Bahan_dasar mdfp : listDB){
            if(mdfp.getId_barang_dasar_datang()==No_po&&mdfp.getId_barang_dasar_datang()==Id_barang){
                pilih=mdfp;
                break;
            }
        }
        return pilih;
    }
     
//    public MD_Full_datang_Bahan_dasar getMDByID(int No_po){
//        MD_Full_datang_Bahan_dasar pilih=new MD_Full_datang_Bahan_dasar();
//        for(MD_Full_datang_Bahan_dasar mdfp : listDB){
//            if(mdfp.get==No_po){
//                pilih=mdfp;
//                break;
//            }
//        }
//        return pilih;
//    }
    
    public List<MD_Full_datang_Bahan_dasar> getAll(){
        return listDB;
    }
}
