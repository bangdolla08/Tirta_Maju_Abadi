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
public class listMD_Ban {
     private database db;
    private List<MD_Ban> listDB = new ArrayList<MD_Ban>();
    private ResultSet rs;
    
    public listMD_Ban(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Ban(rs.getString("nopol"), 
                        rs.getString("posisi"), 
                        rs.getString("no_seri"),rs.getString("tgl_pasang")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Ban(database db){
        this.db=db;
        listDB.clear();
        try {
            ResultSet rs=db.getRs("select * from ban");
            while(rs.next()){
                listDB.add(new MD_Ban(rs.getString("nopol"), 
                        rs.getString("posisi"), 
                        rs.getString("no_seri"),rs.getString("tgl_pasang")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Ban getMDByID(String nopol){
        MD_Ban pilih=new MD_Ban();
        for(MD_Ban dbd : listDB){
            if(dbd.getNopol()==nopol){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Ban> getAll(){
        return listDB;
    }
    
}
