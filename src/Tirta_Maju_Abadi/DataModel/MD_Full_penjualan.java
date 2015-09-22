/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

/**
 *
 * @author NEEZAR
 */
public class MD_Full_penjualan {
    private int Id_produk, Banyak;
    private String No_nota;
    
    public MD_Full_penjualan(int Id_produk, int Banyak, String No_nota){
        this.Id_produk=Id_produk;
        this.No_nota=No_nota;
        this.Banyak=Banyak;
    }
    public MD_Full_penjualan(){
        this.Id_produk=0;
        this.Banyak=0;
        this.No_nota=null;
    }
    
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
