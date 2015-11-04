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
public class listMD_Galon_cacat {
    private database db;
    private ResultSet rs;
    private List<MD_Galon_cacat> listDB=new ArrayList<MD_Galon_cacat>();
    private loadAllData lad;
    
    public listMD_Galon_cacat(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Galon_cacat(rs.getString("No_surat_jalan"), 
                        rs.getBoolean("Treatment"), 
                        rs.getBoolean("Pecah"),
                        rs.getInt("banyak")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Galon_cacat(database db, loadAllData lad ){
        this.db=db;
        this.lad=lad;
        listDB.clear();
        try {
            rs=db.getRs("select * from galon_cacat");
            while(rs.next()){
                listDB.add(new MD_Galon_cacat(rs.getString("No_surat_jalan"), 
                        rs.getBoolean("Treatment"), 
                        rs.getBoolean("Pecah"),
                        rs.getInt("banyak")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Galon_cacat getMDByID(String No_urut){
        MD_Galon_cacat pilih=new MD_Galon_cacat();
        for(MD_Galon_cacat mdgc : listDB){
            if(mdgc.getNo_surat_jalan()==No_urut){
                pilih=mdgc;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Galon_cacat> getAll(){
        return listDB;
    }
}
