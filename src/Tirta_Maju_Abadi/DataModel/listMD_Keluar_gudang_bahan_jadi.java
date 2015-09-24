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
public class listMD_Keluar_gudang_bahan_jadi {
    private database db;
    private ResultSet rs;
    private List<MD_Keluar_gudang_bahan_jadi> listDB=new ArrayList<MD_Keluar_gudang_bahan_jadi>();
    
    public listMD_Keluar_gudang_bahan_jadi(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Keluar_gudang_bahan_jadi(rs.getString("No_nota"), 
                        rs.getString("No_surat_jalan"), 
                        rs.getInt("Banyak"), 
                        rs.getString("Nopol"), 
                        rs.getInt("Id_produk")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
        public listMD_Keluar_gudang_bahan_jadi(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from keluar_gudang_bahan_jadi");
            while(rs.next()){
                listDB.add(new MD_Keluar_gudang_bahan_jadi(rs.getString("No_nota"), 
                        rs.getString("No_surat_jalan"), 
                        rs.getInt("Banyak"), 
                        rs.getString("nopol"), 
                        rs.getInt("Id_produk")));
            }        
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Keluar_gudang_bahan_jadi getMDByID(String No_nota ){
        MD_Keluar_gudang_bahan_jadi pilih=new MD_Keluar_gudang_bahan_jadi();
        for(MD_Keluar_gudang_bahan_jadi kgbj : listDB){
            if(kgbj.getNo_nota()==No_nota){
                pilih=kgbj;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Keluar_gudang_bahan_jadi> getAll(){
        return listDB;
    }
}
