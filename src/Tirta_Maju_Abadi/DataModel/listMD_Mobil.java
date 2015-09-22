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
public class listMD_Mobil {
    private database db;
    private List<MD_Mobil> listDB = new ArrayList<MD_Mobil>();
    private ResultSet rs;
    
    public listMD_Mobil(database db){
        this.db=db;
    listDB.clear();
        try {
            ResultSet rs=db.getRs("select * from mobil");
            while(rs.next()){
                //public MD_Mobil(int driverint, int helperInt, String nopol, String type) {
                listDB.add(new MD_Mobil(rs.getInt("Driver"),rs.getInt("Helper"),rs.getString("Nopol"), 
                        rs.getString("Type"), 
                        rs.getString("Milik"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Mobil(ResultSet rs,database db){
        this.db=db;
    listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Mobil(rs.getInt("driver"),rs.getInt("helper"),rs.getString("nopol"), 
                        rs.getString("type"), 
                        rs.getString("milik"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Mobil getMDByID(String nopol){
        MD_Mobil pilih=new MD_Mobil();
        for(MD_Mobil dbd : listDB){
            if(dbd.getNopol() == nopol){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Mobil> getAll(){
        return listDB;
    }
    
}
