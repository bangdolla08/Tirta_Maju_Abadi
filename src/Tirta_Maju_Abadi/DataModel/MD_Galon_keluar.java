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
public class MD_Galon_keluar {
    private String Tanggal;
    private int No_surat_jalan,Banyak_keluar,Id_pelanggan;
    
    public MD_Galon_keluar(int No_surat_jalan, int Banyak_keluar,
            String Tanggal, int Id_pelanggan){
        this.No_surat_jalan=No_surat_jalan;
        this.Banyak_keluar=Banyak_keluar;
        this.Tanggal=Tanggal;
        this.Id_pelanggan=Id_pelanggan;
    }
    public MD_Galon_keluar(){
        this.No_surat_jalan=0;
        this.Banyak_keluar=0;
        this.Tanggal=Tanggal;
        this.Id_pelanggan=0;
    }

    public int getNo_surat_jalan() {
        return No_surat_jalan;
    }

    public void setNo_surat_jalan(int No_surat_jalan) {
        this.No_surat_jalan = No_surat_jalan;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public int getBanyak_keluar() {
        return Banyak_keluar;
    }

    public int getId_pelanggan() {
        return Id_pelanggan;
    }

    public void setTanggal(String Tanggal) {
        this.Tanggal = Tanggal;
    }

    public void setBanyak_keluar(int Banyak_keluar) {
        this.Banyak_keluar = Banyak_keluar;
    }

    public void setId_pelanggan(int Id_pelanggan) {
        this.Id_pelanggan = Id_pelanggan;
    }

    
}
