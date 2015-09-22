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
public class listMD_Galon_keluar {
     private database db;
    private ResultSet rs;
    private List<MD_Galon_keluar> listDB=new ArrayList<MD_Galon_keluar>();
    
    public listMD_Galon_keluar(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Galon_keluar(rs.getInt("No_urut"),
                        rs.getInt("Banyak_keluar"), 
                        rs.getString("Tanggal"), 
                        rs.getInt("Id_pelanggan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Galon_keluar(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Galon_keluar");
            while(rs.next()){
                listDB.add(new MD_Galon_keluar(rs.getInt("No_urut"),
                        rs.getInt("Banyak_keluar"), 
                        rs.getString("Tanggal"), 
                        rs.getInt("Id_pelanggan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    
    public MD_Galon_keluar getMDByID(int No_urut){
        MD_Galon_keluar pilih=new MD_Galon_keluar();
        for(MD_Galon_keluar mdgk : listDB){
            if(mdgk.getNo_urut()==No_urut){
                pilih=mdgk;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Galon_keluar> getAll(){
        return listDB;
    }
}
