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
public class listMD_Nota_pesan {
    private database db;
    ResultSet rs;
    private List<MD_Nota_pesan> listDB=new ArrayList<MD_Nota_pesan>();
    
    public listMD_Nota_pesan(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Nota_pesan(rs.getString("No_pemesanan"), 
                        rs.getString("Harga"), 
                        rs.getInt("Banyak")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Nota_pesan(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from Nota_pesan");
            while(rs.next()){
                listDB.add(new MD_Nota_pesan(rs.getString("No_pemesanan"), 
                        rs.getString("Harga"), 
                        rs.getInt("Banyak")));
            }        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Nota_pesan getMDByID(String No_pemesanan){
        MD_Nota_pesan pilih=new MD_Nota_pesan();
        for(MD_Nota_pesan mdp : listDB){
            if(mdp.getNo_pemesanan()== No_pemesanan){
                pilih=mdp;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Nota_pesan> getAll(){
        return listDB;
    }    
}
