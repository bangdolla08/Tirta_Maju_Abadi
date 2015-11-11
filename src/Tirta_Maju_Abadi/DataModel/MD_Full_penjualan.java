/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

/**
 *
 * @author NEEZAR
 */
public class MD_Full_penjualan {
    private int Id_produk, Banyak;
    private String No_nota;
    private loadAllData lD;
    private MD_Produk mp;
   

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
}