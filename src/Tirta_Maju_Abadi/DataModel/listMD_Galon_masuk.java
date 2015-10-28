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
public class listMD_Galon_masuk {
    private database db;
    private ResultSet rs;
    private loadAllData lad;
    
    private List<MD_Galon_masuk> listDB=new ArrayList<MD_Galon_masuk>();
    private List<MD_Pelanggan> listDBPel=new ArrayList<MD_Pelanggan>();
    
    public listMD_Galon_masuk(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Galon_masuk(rs.getString("No_surat_jalan"), 
                        rs.getInt("Banyak_masuk"), 
                        rs.getDate("Tanggal"), 
                        rs.getInt("Id_pelanggan"), lad));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    private loadAllData lads;
    public listMD_Galon_masuk(database db, loadAllData lad){
        this.db=db;
        this.lad=lad;
        listDB.clear();
        try {
            rs=db.getRs("select * from galon_masuk");
            while(rs.next()){
                listDB.add(new MD_Galon_masuk(rs.getString("No_surat_jalan"), 
                        rs.getInt("Banyak_masuk"), 
                        rs.getDate("Tanggal"), 
                        rs.getInt("Id_pelanggan"), lad));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
        
    public MD_Pelanggan getMDNama(String Nama_pelaggan){
        MD_Pelanggan pilih=new MD_Pelanggan();
        for(MD_Pelanggan mdgm : listDBPel){
            if(mdgm.getNama()==Nama_pelaggan){
                pilih=mdgm;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Galon_masuk> getAll(){
        return listDB;
    }
}
