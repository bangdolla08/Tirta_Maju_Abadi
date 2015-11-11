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
public class MD_Full_penjualan {
    private int Id_produk, Banyak;
    private String No_nota;
    private loadAllData lD;
    private MD_Produk mp;
    private ResultSet rs;
    private database db;
   

    public MD_Produk getMp() {
        return mp;
    }

    public void setMp(MD_Produk mp) {
        this.mp = mp;
    }
    
    public MD_Full_penjualan(MD_Produk pro, int Banyak, String No_nota, loadAllData lD){
        this.mp=pro;
        this.lD=lD;
        this.Id_produk=pro.getId_produk();
        this.No_nota=No_nota;
        this.Banyak=Banyak;
    }
    
    public MD_Full_penjualan(int id_produk, int Banyak, String No_nota, loadAllData lD){
        
        this.lD=lD;
        this.Id_produk=id_produk;
        this.No_nota=No_nota;
        this.Banyak=Banyak;
        this.db=db;
        listFull.clear();
        listMD_penjualan_po();
    }
    
    public MD_Full_penjualan(){
        this.Id_produk=0;
        this.Banyak=0;
        this.No_nota=null;
    }
  
//    public MD_Produk getMD_produk(){
//        return lD.getListMD_Produk().getMDByID(Id_produk);
//    }
    
    public int getId_Produk(){
        return Id_produk;
    }
    public int getBanyak(){
        return Banyak;
    }
    public String getNo_nota(){
        return No_nota;
    }
    
    public void setId_produk(int Id_produk){
        this.Id_produk=Id_produk;
    }
    public void setBanyak(int Banyak){
        this.Banyak=Banyak;
    }
    public void setNo_nota(String No_nota){
        this.No_nota=No_nota;
    }
    
    private List<MD_Penjualan_po> listFull=new ArrayList<MD_Penjualan_po>();
    public void listMD_penjualan_po(){
        try {
            rs=db.getRs("select * from Penjualan_po where No_po='"+No_nota+"'");
            while(rs.next()){
                listFull.add(new MD_Penjualan_po(rs.getInt("Id_marketing"), 
                        rs.getString("No_nota"), 
                        rs.getString("No_po"),
                        rs.getDate("tanggalpesan"),
                        rs.getInt("Id_pelanggan"),db,lD));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    } 
    
    
    public void listMD_penjualan_po(MD_Penjualan_po tmp){
        listFull.clear();
        listFull.add(tmp);
    } 

    public List<MD_Penjualan_po> getListFull() {
        return listFull;
    }

    public void setListFull(List<MD_Penjualan_po> listFull) {
        this.listFull = listFull;
    }
}