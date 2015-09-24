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
public class listMD_Gudang_barang_jadi {
    private database db;
    private ResultSet rs;
    private List<MD_Gudang_barang_jadi> listDB=new ArrayList<MD_Gudang_barang_jadi>();
    
    public listMD_Gudang_barang_jadi(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Gudang_barang_jadi(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("Koordinator"), 
                        rs.getString("Operator"), 
                        rs.getString("Shift")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Gudang_barang_jadi(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from gudang_barang_jadi");
            while(rs.next()){
                listDB.add(new MD_Gudang_barang_jadi(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("Koordinator"), 
                        rs.getString("Operator"), 
                        rs.getString("Shift")));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Gudang_barang_jadi getMDByID(int Id_produk){
        MD_Gudang_barang_jadi pilih=new MD_Gudang_barang_jadi();
        for(MD_Gudang_barang_jadi mgbj : listDB){
            if(mgbj.getId_produk()==Id_produk){
                pilih=mgbj;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Gudang_barang_jadi> getAll(){
        return listDB;
    }
}
