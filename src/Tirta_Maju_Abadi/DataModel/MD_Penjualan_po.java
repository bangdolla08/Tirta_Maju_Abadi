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

/**
 *
 * @author NEEZAR
 */
public class MD_Penjualan_po {
    private int Id_pelanggan, Id_marketing;
    private String No_nota, No_po;
    private ResultSet rs;
    private database db;
    private loadAllData lD;
    //private MD_Harga_pelanggan mhp;
    public MD_Penjualan_po(int Id_marketing, int Id_pelanggan, String No_nota, String No_po,database db, loadAllData lD){
        this.lD=lD;
        this.Id_marketing=Id_marketing;
        this.Id_pelanggan=Id_pelanggan;
        this.No_nota=No_nota;
        this.No_po=No_po;
        this.db=db;
        listFull.clear();
        listMD_Full_penjualan();
        
    }
    private List<MD_Full_penjualan> listFull=new ArrayList<MD_Full_penjualan>();
    public void listMD_Full_penjualan(){
        try {
            rs=db.getRs("select * from full_penjualan where No_nota='"+No_nota+"'");
            while(rs.next()){
                listFull.add(new MD_Full_penjualan(rs.getInt("Id_produk"), 
                        rs.getInt("Banyak"), 
                        rs.getString("No_nota"), lD));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    } 
    public MD_Harga_pelanggan getHarga(int id_produk){
        return lD.getListMD_Harga_pelanggan().getByIDAndProduk(Id_pelanggan, id_produk);
    }
    public void listMD_Full_penjualan(MD_Full_penjualan tmp){
        listFull.clear();
        listFull.add(tmp);
    } 

    public List<MD_Full_penjualan> getListFull() {
        return listFull;
    }

    public void setListFull(List<MD_Full_penjualan> listFull) {
        this.listFull = listFull;
    }
    
    public MD_Penjualan_po(){
        this.Id_marketing=0;
        this.Id_pelanggan=0;
        this.No_nota=null;
        this.No_po=null;
    }

    public void setId_marketing(int Id_marketing) {
        this.Id_marketing = Id_marketing;
    }

    public int getId_marketing() {
        return Id_marketing;
    }
    
    public int getId_pelanggan(){
        return Id_pelanggan;
    }
    public String getNo_nota(){
     return No_nota;
    }
    public String getNo_po(){
        return No_po;
    }
    
    public void setId_pelanggan(int Id_pelanggan){
        this.Id_pelanggan=Id_pelanggan;
    }
    public void setNo_nota(String No_nota){
        this.No_nota=No_nota;
    }
    public void setNo_po(String No_po){
        this.No_po=No_po;
    }
}
