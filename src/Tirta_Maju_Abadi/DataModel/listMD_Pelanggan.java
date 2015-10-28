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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NEEZAR
 */
public class listMD_Pelanggan {
    private database db;
    private database dbs;
    private ResultSet rs;
    private List<MD_Pelanggan> listDB=new ArrayList<MD_Pelanggan>();
    private loadAllData lad;
    public listMD_Pelanggan(ResultSet rs,database db){
        this.db=db;
        this.dbs=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Pelanggan(rs.getInt("Id_pelanggan"), 
                        rs.getString("Nama"), 
                        rs.getString("Alamat"),
                        rs.getInt("Tipe_pembayaran"),
                        rs.getString("No_telepon"),dbs,lad));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public listMD_Pelanggan(database db,loadAllData lad){
        this.db=db;
        listDB.clear();
        this.lad=lad;
        try {
            rs=db.getRs("select * from pelanggan");
            while(rs.next()){
                listDB.add(new MD_Pelanggan(rs.getInt("Id_pelanggan"), 
                        rs.getString("Nama"), 
                        rs.getString("Alamat"),
                        rs.getInt("Tipe_pembayaran"),
                        rs.getString("No_telepon"),dbs,lad));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Pelanggan getMDByID(int Id_pelanggan){
        MD_Pelanggan pilih=new MD_Pelanggan();
        for(MD_Pelanggan mdpe : listDB){
            if(mdpe.getId_Pelanggan()==Id_pelanggan){
                pilih=mdpe;
                break;
            }
        }
        return pilih;
    }
    
    public MD_Pelanggan getMDByName(String Nama_pelaggan){
        MD_Pelanggan pilih=new MD_Pelanggan();
        for(MD_Pelanggan mdgm : listDB){
            if(mdgm.getNama().equals(Nama_pelaggan)){
                pilih=mdgm;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Pelanggan> getAll(){
        return listDB;
    }
    
}
