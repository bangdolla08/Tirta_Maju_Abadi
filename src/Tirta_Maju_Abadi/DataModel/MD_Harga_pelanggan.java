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
public class MD_Harga_pelanggan {
    private int Id_pelanggan, Id_produk;
    private int Harga;
    private MD_Produk mdP;

    public MD_Produk getMdP() {
        return mdP;
    }

    public void setMdP(MD_Produk mdP) {
        this.mdP = mdP;
    }
    public MD_Harga_pelanggan(int Id_pelanggan, int Id_produk, int Harga,loadAllData ld){
        this.Id_pelanggan=Id_pelanggan;
        this.Id_produk=Id_produk;
        this.Harga=Harga;
        this.mdP=ld.getListMD_Produk().getMDByID(Id_produk);
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
