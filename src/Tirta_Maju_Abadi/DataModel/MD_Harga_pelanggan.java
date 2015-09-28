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
public class MD_Harga_pelanggan {
    private int Id_pelanggan, Id_produk;
    private int Harga;

    public MD_Harga_pelanggan(int Id_pelanggan, int Id_produk, int Harga){
        this.Id_pelanggan=Id_pelanggan;
        this.Id_produk=Id_produk;
        this.Harga=Harga;
    }
    
    public MD_Harga_pelanggan(){
        this.Id_pelanggan=0;
        this.Id_produk=0;
        this.Harga=0;
    }
    
    public int getId_pelanggan(){
        return Id_pelanggan;
    }
    public int getId_produk(){
        return Id_produk;
    }
    public int getHarga(){
        return Harga;
    }
    
    public void setId_pelanggan(int Id_pelanggan){
        this.Id_pelanggan=Id_pelanggan;
    }
    public void setId_produk(int Id_produk){
        this.Id_produk=Id_produk;
    }
    public void setHarga(int Harga){
        this.Harga=Harga;
    }
}
