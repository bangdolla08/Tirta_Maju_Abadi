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
public class MD_Nota_pesan {
    private String No_pemesanan, Harga;
    private int banyak;
    
    public MD_Nota_pesan(String No_pemesanan, String Harga, int Banyak){
        this.No_pemesanan=No_pemesanan;
        this.Harga=Harga;
        this.banyak=Banyak;
    }
    public MD_Nota_pesan(){
        this.No_pemesanan=null;
        this.Harga=null;
        this.banyak=0;
    }

    public String getNo_pemesanan() {
        return No_pemesanan;
    }

    public String getHarga() {
        return Harga;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setNo_pemesanan(String No_pemesanan) {
        this.No_pemesanan = No_pemesanan;
    }

    public void setHarga(String Harga) {
        this.Harga = Harga;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }
}
