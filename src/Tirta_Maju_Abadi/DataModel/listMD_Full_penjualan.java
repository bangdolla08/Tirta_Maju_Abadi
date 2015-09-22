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
public class listMD_Full_penjualan {
     private database db;
    private ResultSet rs;
    private List<MD_Full_penjualan> listDB=new ArrayList<MD_Full_penjualan>();
    
    public listMD_Full_penjualan(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Full_penjualan(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("No_nota")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Full_penjualan(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from full_penjualan");
            while(rs.next()){
                listDB.add(new MD_Full_penjualan(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("No_nota")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }    
    
    public MD_Full_penjualan getMDByID(int Id_produk){
        MD_Full_penjualan pilih=new MD_Full_penjualan();
        for(MD_Full_penjualan mdfp : listDB){
            if(mdfp.getId_Produk()==Id_produk){
                pilih=mdfp;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Full_penjualan> getAll(){
        return listDB;
    }
}
