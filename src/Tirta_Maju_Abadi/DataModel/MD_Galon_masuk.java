/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Date;

/**
 *
 * @author NEEZAR
 */
public class MD_Galon_masuk {
    private Date Tanggal;
    private String No_surat, Nama_pelanggan;
    private int Banyak_masuk,Id_pelanggan;
    private MD_Pelanggan mp;
    private MD_Galon_masuk MDgm;
    private loadAllData lad;
    private listMD_Galon_masuk lgm;

    public String getNama_pelanggan() {
        return Nama_pelanggan;
    }

    public void setNama_pelanggan(String Nama_pelanggan) {
        this.Nama_pelanggan = Nama_pelanggan;
    }

    
    public MD_Galon_masuk getMDgm() {
        return MDgm;
    }

    public void setMDgm(MD_Galon_masuk MDgm) {
        this.MDgm = MDgm;
    }
    
    public MD_Galon_masuk(String No_surat, 
            int Banyak_masuk, Date Tanggal, int Id_pelanggan, loadAllData ld){
        this.No_surat=No_surat;
        this.Banyak_masuk=Banyak_masuk;
        this.Tanggal=Tanggal;
        this.Id_pelanggan=Id_pelanggan;
    }

    public MD_Pelanggan getMp() {
        return mp;
    }

    public void setMp(MD_Pelanggan mp) {
        this.mp = mp;
    }
    
    
    public MD_Galon_masuk(){
        this.No_surat=null;
        this.Banyak_masuk=0;
        this.Id_pelanggan=0;
        this.Nama_pelanggan=null;
    }
    
    
    public String getNo_surat(){
        return No_surat;
    }
    public int getBanyak_masuk(){
        return Banyak_masuk;
    }
    public Date getTanggal(){
        return Tanggal;
    }
    public int getId_pelanggan(){
        return Id_pelanggan;
    }
    
    public void setNo_surat(String No_surat){
        this.No_surat=No_surat;
    }
    public void setBanyak_masuk(int Banyak_masuk){
        this.Banyak_masuk=Banyak_masuk;
    }
    public void setTanggal(Date Tanggal){
        this.Tanggal=Tanggal;
    }
    public void setId_pelanggan(int Id_pelanggan){
        this.Id_pelanggan=Id_pelanggan;
    }
}
