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
                listDB.add(new MD_Harga_pelanggan(rs.getInt("Id_pelanggan"), 
                        rs.getInt("Id_produk"), 
                        rs.getString("Harga")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
     public listMD_Harga_pelanggan(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Harga_pelanggan");
            while(rs.next()){
                listDB.add(new MD_Harga_pelanggan(rs.getInt("Id_pelanggan"), 
                        rs.getInt("Id_produk"), 
                        rs.getString("Harga")));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
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
