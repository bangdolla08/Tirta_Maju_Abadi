/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Datang_bahan_dasar {
    
    private String No_po, Surat_jalan;
    private int Id_supplier, Banyak,No_masuk,id_bahan;
    private List<MD_Full_datang_Bahan_dasar> listDatang_bahan=new ArrayList<MD_Full_datang_Bahan_dasar>();
    
    public List<MD_Full_datang_Bahan_dasar> getListDatang_bahan() {
        return listDatang_bahan;
    }

    public void setListDatang_bahan(List<MD_Full_datang_Bahan_dasar> listDatang_bahan) {
        this.listDatang_bahan = listDatang_bahan;
    }

    
    public int getId_bahan() {
        return id_bahan;
    }

    public void setId_bahan(int id_bahan) {
        this.id_bahan = id_bahan;
    }
        
    public MD_Datang_bahan_dasar(String No_po, String Surat_jalan,int Id_supplier){
        this.Id_supplier=Id_supplier;
        this.Surat_jalan=Surat_jalan;
        this.No_po=No_po;
        listDatang_bahan.clear();
    }
    private database db;
    private loadAllData lad;
    public MD_Datang_bahan_dasar(String No_po,String Surat_jalan,
            int Id_supplier,database db,loadAllData lad){
        this.Id_supplier=Id_supplier;
        this.Surat_jalan=Surat_jalan;
        this.No_po=No_po;
        this.db=db;
        this.lad=lad;
        isiListDb();
    }
    public void isiListDb(){
        listDatang_bahan.clear();        
        try {
            ResultSet rs=db.getRs("select * from full_po_bahan_dasar_datang where No_po='"+No_po+"' ");
            while(rs.next()){
                addTOList(new MD_Full_datang_Bahan_dasar( 
                        rs.getInt("Id_barang_dasar_datang"), 
                        rs.getInt("Banyak"),
                        rs.getInt("Fisik")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public void addTOList(MD_Full_datang_Bahan_dasar tm){
        listDatang_bahan.add(tm);
    }
    public MD_Datang_bahan_dasar(){
        this.Surat_jalan=null;
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


    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }

    public void setBanyak(int Banyak) {
        this.Banyak = Banyak;
    }
                    
}
