/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;

/**
 *
 * @author jepank's
 */
public class MD_Full_datang_Bahan_dasar {
    private int No_masuk, Id_barang_dasar_datang, Banyak, Fisik;
    private loadAllData lD;
    private MD_Produk mdp;
    
    public MD_Full_datang_Bahan_dasar(int Id_barang_dasar_datang, int Banyak, int Fisik){
        this.Id_barang_dasar_datang=Id_barang_dasar_datang;
        this.Banyak=Banyak;
        this.Fisik=Fisik;
    }
    public MD_Full_datang_Bahan_dasar(MD_Produk mp, int banyak, int fisik){
        this.Id_barang_dasar_datang=mp.getId_produk();
        this.Banyak=banyak;
        this.Fisik=fisik;
        mdp=mp;
    }
    public MD_Full_datang_Bahan_dasar(){
        this.No_masuk=0;
        this.Id_barang_dasar_datang=0;
        this.Banyak=0;
        this.Fisik=0;
    }
    
    public void setMDP(MD_Produk mdp){
        this.mdp=mdp;
    }
    public MD_Produk getMDP(){
        return mdp;
    }

//    public  MD_Produk getMD_Produk(){
//        return lD.getListMD_Produk().getMDByID(Id_barang_dasar_datang);
//    }
    

    public int getId_barang_dasar_datang() {
        return Id_barang_dasar_datang;
    }

    public void setId_barang_dasar_datang(int Id_barang_dasar_datang) {
        this.Id_barang_dasar_datang = Id_barang_dasar_datang;
    }

    public int getBanyak() {
        return Banyak;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }

    public int getFisik() {
        return Fisik;
    }

    public void setFisik(int Fisik) {
        this.Fisik = Fisik;
    }
    
}
