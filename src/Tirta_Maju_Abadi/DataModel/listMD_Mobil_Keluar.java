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
public class listMD_Mobil_Keluar {
    private database db;
    private List<MD_Mobil_Keluar> listDB = new ArrayList<MD_Mobil_Keluar>();
    private ResultSet rs;

    public listMD_Mobil_Keluar(database db){
        this.db=db;
        listDB.clear();
        try {
            ResultSet rs=db.getRs("select * from mobil_keluar");
            while(rs.next()){
                listDB.add(new MD_Mobil_Keluar(rs.getInt("id_bo"), 
                        rs.getString("tgl"), 
                        rs.getString("nopol"),rs.getString("tujuan")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public listMD_Mobil_Keluar(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Mobil_Keluar(rs.getInt("id_bo"), 
                        rs.getString("tgl"), 
                        rs.getString("nopol"),rs.getString("tujuan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Mobil_Keluar getMDByID(int Id_bo){
        MD_Mobil_Keluar pilih=new MD_Mobil_Keluar();
        for(MD_Mobil_Keluar dbd : listDB){
            if(dbd.getId_bo()==Id_bo){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Mobil_Keluar> getAll(){
        return listDB;
    }
    
}
