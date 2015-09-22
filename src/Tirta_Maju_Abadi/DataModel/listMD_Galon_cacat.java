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
public class listMD_Galon_cacat {
    private database db;
    private ResultSet rs;
    private List<MD_Galon_cacat> listDB=new ArrayList<MD_Galon_cacat>();
    
    public listMD_Galon_cacat(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Galon_cacat(rs.getInt("No_urut"), 
                        rs.getString("Treatment"), 
                        rs.getString("Pecah")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Galon_cacat(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Galon_cacat");
            while(rs.next()){
                listDB.add(new MD_Galon_cacat(rs.getInt("No_urut"), 
                        rs.getString("Treatment"), 
                        rs.getString("Pecah")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Galon_cacat getMDByID(int No_urut){
        MD_Galon_cacat pilih=new MD_Galon_cacat();
        for(MD_Galon_cacat mdgc : listDB){
            if(mdgc.getNo_urut()==No_urut){
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
