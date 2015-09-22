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
 * @author PUTRA
 */
public class listMD_Keterangan_Km {
    private database db;
    private List<MD_Keterangan_Km> listDB = new ArrayList<MD_Keterangan_Km>();
    private ResultSet rs;
    public listMD_Keterangan_Km(database db){
        this.db=db;
    listDB.clear();
        try {
            ResultSet rs=db.getRs("select * from keterangan_km");
            while(rs.next()){
                listDB.add(new MD_Keterangan_Km(rs.getInt("id_bo"), 
                        rs.getInt("km"), 
                        rs.getInt("posisi_km")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Keterangan_Km(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Keterangan_Km(rs.getInt("id_bo"), 
                        rs.getInt("km"), 
                        rs.getInt("posisi_km")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Keterangan_Km getMDByID(int Id_bo){
        MD_Keterangan_Km pilih=new MD_Keterangan_Km();
        for(MD_Keterangan_Km dbd : listDB){
            if(dbd.getId_bo()==Id_bo){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Keterangan_Km> getAll(){
        return listDB;
    }
    
}
