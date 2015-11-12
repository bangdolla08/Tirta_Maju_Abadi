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
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author NEEZAR
 */
public class listMD_Datang_bahan_dasar {
    private database db;
    private ResultSet rs;
    private List<MD_Datang_bahan_dasar> listDB=new ArrayList<MD_Datang_bahan_dasar>();
    
    public listMD_Datang_bahan_dasar(ResultSet rs){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Datang_bahan_dasar(rs.getString("No_po"), 
                        rs.getString("Surat_jalan"), 
                        rs.getInt("Id_supplier")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
   private loadAllData lad;
    public listMD_Datang_bahan_dasar(database db){
        this.db=db;
        this.lad=lad;
        listDB.clear();
        try {
            rs=db.getRs("select * from datang_bahan_dasar");
            while(rs.next()){
                listDB.add(new MD_Datang_bahan_dasar(rs.getString("No_po"),
                        rs.getString("Surat_jalan"),
                        rs.getInt("Id_supplier")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Datang_bahan_dasar getMDByID(int Id_supplier){
        MD_Datang_bahan_dasar pilih=new MD_Datang_bahan_dasar();
        for(MD_Datang_bahan_dasar dbd : listDB){
            if(dbd.getId_supplier()==Id_supplier){
                pilih=dbd;
                break;
            }
        }
        return pilih;
    }
    
    public MD_Datang_bahan_dasar getMDByNo_po(String No_po){
        MD_Datang_bahan_dasar pilih=new MD_Datang_bahan_dasar();
        for(MD_Datang_bahan_dasar dbds : listDB){
            if(dbds.getNo_po().equals(No_po)){
                pilih=dbds;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Datang_bahan_dasar> getAll(){
        return listDB;
    }
}
