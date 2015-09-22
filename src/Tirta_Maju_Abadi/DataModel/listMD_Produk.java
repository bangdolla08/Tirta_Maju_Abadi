/*
 * To change this template, choose Tools | Templates
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
 * @author jepank's
 */
public class listMD_Produk {
    private database db;
    private ResultSet rs;
    private List<MD_Produk> listDB=new ArrayList<MD_Produk>();
    
    public listMD_Produk(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Produk(rs.getInt("Id_produk"), 
                        rs.getString("Nama_produk"), 
                        rs.getString("Harga_pokok")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public listMD_Produk(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from admin");
            while(rs.next()){
                listDB.add(new MD_Produk(rs.getInt("Id_produk"), 
                        rs.getString("Nama_produk"), 
                        rs.getString("Harga_pokok")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public MD_Produk getMDByID(int Id_produk){
        MD_Produk pilih=new MD_Produk();
        for(MD_Produk mdpr : listDB){
            if(mdpr.getId_produk()==Id_produk){
                pilih=mdpr;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Produk> getAll(){
        return listDB;
    }
}
