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
public class MD_Datang_bahan_dasar {
    
    private String No_po, Surat_jalan, Fisik;
    private int Id_supplier, Banyak,No_masuk,id_bahan;

    public int getId_bahan() {
        return id_bahan;
    }

    public void setId_bahan(int id_bahan) {
        this.id_bahan = id_bahan;
    }
        
    public MD_Datang_bahan_dasar(int Banyak,
            int Id_supplier,int No_masuk,int id_bahan,
            String No_po,
            String Surat_jalan,
            String Fisik){
        this.id_bahan=id_bahan;
        this.Banyak=Banyak;
        this.Id_supplier=Id_supplier;
        this.Fisik=Fisik;
        this.Surat_jalan=Surat_jalan;
        this.No_po=No_po;
        this.No_masuk=No_masuk;
    }
    public MD_Datang_bahan_dasar(){
        this.Surat_jalan=null;
        this.Fisik=null;
        this.No_po=null;
        this.Id_supplier=0;
        this.Banyak=0;
        this.No_masuk=0;
    }

    public int getNo_masuk() {
        return No_masuk;
    }

    public void setNo_masuk(int No_masuk) {
        this.No_masuk = No_masuk;
    }

    public String getNo_po() {
        return No_po;
    }

    public String getSurat_jalan() {
        return Surat_jalan;
    }

    public String getFisik() {
        return Fisik;
    }

    public int getId_supplier() {
        return Id_supplier;
    }

    public int getBanyak() {
        return Banyak;
    }

    public void setNo_po(String No_po) {
        this.No_po = No_po;
    }

    public void setSurat_jalan(String Surat_jalan) {
        this.Surat_jalan = Surat_jalan;
    }

    public void setFisik(String Fisik) {
        this.Fisik = Fisik;
    }

    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }
                    
}
