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
public class listMD_Po_bahan_dasar {
    private database db;
    private ResultSet rs;
    private List<MD_Po_bahan_dasar> listDB=new ArrayList<MD_Po_bahan_dasar>();
    
    public listMD_Po_bahan_dasar(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                //(String No_po, Date tanggal, int no_pegwai)
                listDB.add(new MD_Po_bahan_dasar(rs.getString("No_po"), 
                        rs.getDate("tanggal"), 
                        rs.getInt("no_pegawai"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public listMD_Po_bahan_dasar(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Po_bahan_dasar");
            while(rs.next()){
                listDB.add(new MD_Po_bahan_dasar(rs.getString("No_po"), 
                        rs.getDate("tanggal"), 
                        rs.getInt("no_pegawai"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public MD_Po_bahan_dasar getMDByID(String No_po){
        MD_Po_bahan_dasar pilih=new MD_Po_bahan_dasar();
        for(MD_Po_bahan_dasar mdpo : listDB){
            if(mdpo.getNo_po()==No_po){
                pilih=mdpo;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Po_bahan_dasar> getAll(){
        return listDB;
    }
    
}
