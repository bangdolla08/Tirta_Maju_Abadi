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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author NEEZAR
 */
public class listMD_Keluar_gudang_bahan_mentah {
    private database db;
    private ResultSet rs;
    private List<MD_Keluar_gudang_bahan_mentah> listDB=new ArrayList<MD_Keluar_gudang_bahan_mentah>();

    
    public listMD_Keluar_gudang_bahan_mentah(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try{
            while(rs.next()){
                listDB.add(new MD_Keluar_gudang_bahan_mentah(rs.getInt("Id_supplier"),
                rs.getInt("Banyak"),
                rs.getInt("No_urut")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public listMD_Keluar_gudang_bahan_mentah(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Keluar_gudang_bahan_mentah");
            while(rs.next()){
                listDB.add(new MD_Keluar_gudang_bahan_mentah(rs.getInt("Id_supplier"),
                    rs.getInt("Banyak"),
                    rs.getInt("No_urut")));
            }        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Keluar_gudang_bahan_mentah getMDByID(int Id_supplier){
        MD_Keluar_gudang_bahan_mentah pilih=new MD_Keluar_gudang_bahan_mentah();
        for(MD_Keluar_gudang_bahan_mentah mdk : listDB){
            if(mdk.getId_supplier() == Id_supplier){
                pilih=mdk;
                break;
            }
        }
        return pilih;
    }
     public List<MD_Keluar_gudang_bahan_mentah> getAll(){
         return listDB;
     }
    
}
