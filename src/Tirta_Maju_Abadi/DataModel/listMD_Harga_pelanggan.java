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
 * @author NEEZAR
 */
public class listMD_Harga_pelanggan {
    private database db;
    private ResultSet rs;
    private List<MD_Harga_pelanggan> listDB=new ArrayList<MD_Harga_pelanggan>();
    
    public listMD_Harga_pelanggan(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
//                listDB.add(new MD_Harga_pelanggan(rs.getInt("Id_pelanggan"), 
//                        rs.getInt("Id_produk"), 
//                        rs.getInt("Harga")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    private loadAllData lad;
     public listMD_Harga_pelanggan(database db,loadAllData lad){
        this.db=db;
        this.lad=lad;
        listDB.clear();
        try {
            rs=db.getRs("select * from harga_pelanggan");
            while(rs.next()){                
                listDB.add(new MD_Harga_pelanggan(rs.getInt("Id_pelanggan"), 
                        lad.getListMD_Produk().getMDByID(rs.getInt("Id_produk")), 
                        rs.getInt("Harga")));
                System.out.println(rs.getInt("Id_produk")+" "+rs.getInt("Id_produk"));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
      public MD_Harga_pelanggan getByIDAndProduk(int id_pelanggan,int id_produk){
        MD_Harga_pelanggan pilih=new MD_Harga_pelanggan();
        for(MD_Harga_pelanggan mdhp : listDB){
            if(mdhp.getId_pelanggan()==id_pelanggan&&mdhp.getId_produk()==id_produk){
                pilih=mdhp;
                break;
            }
        }
        return pilih;
    }
     
    public MD_Harga_pelanggan getMDByID(int Id_pelanggan){
        MD_Harga_pelanggan pilih=new MD_Harga_pelanggan();
        for(MD_Harga_pelanggan mdhp : listDB){
            if(mdhp.getId_pelanggan()==Id_pelanggan){
                pilih=mdhp;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Harga_pelanggan> getAll(){
        return listDB;
    }
}
