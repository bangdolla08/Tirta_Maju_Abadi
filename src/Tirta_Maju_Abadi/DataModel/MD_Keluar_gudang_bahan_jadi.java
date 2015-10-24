/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.View.ModelSwing.ModelChuser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Keluar_gudang_bahan_jadi {
    private String No_nota, No_surat_jalan,Nopol;
    private int Banyak,Id_produk;
    
    
    public MD_Keluar_gudang_bahan_jadi(String No_nota, String No_surat_jalan,int Banyak,
            String Nopol,int Id_produk){
        this.No_nota=No_nota;
        this.No_surat_jalan=No_surat_jalan;
        this.Banyak=Banyak;
        this.Nopol=Nopol;
        this.Id_produk=Id_produk;
    }
    public MD_Keluar_gudang_bahan_jadi(){
        this.No_nota=null;
        this.No_surat_jalan=null;
        this.Banyak=0;
        this.Nopol=null;
        this.Id_produk=0;
    }

    public String getNo_nota() {
        return No_nota;
    }

    public String getNo_surat_jalan() {
        return No_surat_jalan;
    }

    public String getNopol() {
        return Nopol;
    }

    public int getBanyak() {
        return Banyak;
    }

    public int getId_produk() {
        return Id_produk;
    }

    public void setNo_nota(String No_nota) {
        this.No_nota = No_nota;
    }

    public void setNo_surat_jalan(String No_surat_jalan) {
        this.No_surat_jalan = No_surat_jalan;
    }

    public void setNopol(String Nopol) {
        this.Nopol = Nopol;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }

    public void setId_produk(int Id_produk) {
        this.Id_produk = Id_produk;
    }
    
}
