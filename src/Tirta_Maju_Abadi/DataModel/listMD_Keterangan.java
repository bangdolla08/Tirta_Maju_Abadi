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
public class listMD_Keterangan {
    private database db;
    private List<MD_Keterangan> listDB = new ArrayList<MD_Keterangan>();
    private ResultSet rs;
    
    public listMD_Keterangan(database db){
        this.db=db;
    listDB.clear();
        try {
            ResultSet rs=db.getRs("select * from keterangan");
            while(rs.next()){
                listDB.add(new MD_Keterangan(rs.getInt("id_bo"), 
                        rs.getInt("harga"), 
                        rs.getString("keterangan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Keterangan(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Keterangan(rs.getInt("id_bo"), 
                        rs.getInt("harga"), 
                        rs.getString("keterangan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Keterangan getMDByID(int Id_bo){
        MD_Keterangan pilih=new MD_Keterangan();
        for(MD_Keterangan dbd : listDB){
            if(dbd.getId_bo()==Id_bo){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Keterangan> getAll(){
        return listDB;
    }
     
}
