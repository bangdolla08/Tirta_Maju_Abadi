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
public class listMD_Galon_masuk {
    private database db;
    private ResultSet rs;
    private List<MD_Galon_masuk> listDB=new ArrayList<MD_Galon_masuk>();
    
    public listMD_Galon_masuk(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Galon_masuk(rs.getInt("No_urut"), 
                        rs.getInt("Banyak_masuk"), 
                        rs.getString("Tanggal"), 
                        rs.getInt("Id_pelanggan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Galon_masuk(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from galon_masuk");
            while(rs.next()){
                listDB.add(new MD_Galon_masuk(rs.getInt("No_urut"), 
                        rs.getInt("Banyak_masuk"), 
                        rs.getString("Tanggal"), 
                        rs.getInt("Id_pelanggan")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Galon_masuk getMDByID(int No_urut){
        MD_Galon_masuk pilih=new MD_Galon_masuk();
        for(MD_Galon_masuk mdgm : listDB){
            if(mdgm.getNo_urut()==No_urut){
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
