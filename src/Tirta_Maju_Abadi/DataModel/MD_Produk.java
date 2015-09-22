/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

/**
 *
 * @author jepank's
 */
public class MD_Produk {
    private int Id_produk;
    private String Nama_produk,Harga_pokok;
    private loadAllData lD;
    
    public MD_Produk(int Id_produk, String Nama_produk, String Harga_pokok, loadAllData lD){
        this.lD=lD;
        this.Id_produk=Id_produk;
        this.Nama_produk=Nama_produk;
        this.Harga_pokok=Harga_pokok;
    }
    public MD_Produk(){
        this.Id_produk=0;
        this.Nama_produk=null;
        this.Harga_pokok=Harga_pokok=null;
    }

    public int getId_produk() {
        return Id_produk;
    }

    public String getNama_produk() {
        return Nama_produk;
    }

    public String getHarga_pokok() {
        return Harga_pokok;
    }

    public void setId_produk(int Id_produk) {
        this.Id_produk = Id_produk;
    }

    public void setNama_produk(String Nama_produk) {
        this.Nama_produk = Nama_produk;
    }

    public void setHarga_pokok(String Harga_pokok) {
        this.Harga_pokok = Harga_pokok;
    }
}
