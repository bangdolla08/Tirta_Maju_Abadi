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
public class MD_Full_po_bahan_dasar_datang {
    private int No_masuk, Id_barang_dasar_datang, Banyak, Fisik;
    
    public MD_Full_po_bahan_dasar_datang(int No_masuk, int Id_barang_dasar_datang, int Banyak, int Fisik){
        this.No_masuk=No_masuk;
        this.Id_barang_dasar_datang=Id_barang_dasar_datang;
        this.Banyak=Banyak;
        this.Fisik=Fisik;
    }
    
    public MD_Full_po_bahan_dasar_datang(){
        this.No_masuk=0;
        this.Id_barang_dasar_datang=0;
        this.Banyak=0;
        this.Fisik=0;
    }

    public int getNo_masuk() {
        return No_masuk;
    }

    public void setNo_masuk(int No_masuk) {
        this.No_masuk = No_masuk;
    }

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
