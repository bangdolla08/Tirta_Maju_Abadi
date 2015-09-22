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
public class listMD_Penjualan_po {
    private database db;
    private ResultSet rs;
    private List<MD_Penjualan_po> listDB=new ArrayList<MD_Penjualan_po>();
    
    public listMD_Penjualan_po(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Penjualan_po(rs.getInt("Id_pelanggan"), 
                        rs.getString("No_nota"), 
                        rs.getString("No_po_penjulan"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Penjualan_po(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Penjualan_po");
            while(rs.next()){
                listDB.add(new MD_Penjualan_po(rs.getInt("Id_pelanggan"), 
                        rs.getString("No_nota"), 
                        rs.getString("No_po_penjulan"),db));            
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public MD_Penjualan_po getMDByID(int Id_pelanggan){
        MD_Penjualan_po pilih=new MD_Penjualan_po();
        for(MD_Penjualan_po mdpo : listDB){
            if(mdpo.getId_pelanggan()==Id_pelanggan){
                pilih=mdpo;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Penjualan_po> getAll(){
        return listDB;
    }
}
