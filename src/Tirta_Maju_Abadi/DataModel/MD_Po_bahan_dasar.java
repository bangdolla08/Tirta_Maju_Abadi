/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NEEZAR
 */
public class MD_Po_bahan_dasar {
    private String No_po;
    private Date tanggal;
    private int no_pegwai;
    private MD_Pegawai md_pegawai;
    
    private listMD_Pegawai lsd;
    
    private MD_Full_po_bahan_dasar mD_Full_po_bahan_dasar=new MD_Full_po_bahan_dasar();
    
    private List<MD_Full_po_bahan_dasar> listfullDB=new ArrayList<MD_Full_po_bahan_dasar>();

    public List<MD_Full_po_bahan_dasar> getListfullDB() {
        return listfullDB;
    }

    public void setListfullDB(List<MD_Full_po_bahan_dasar> listfullDB) {
        this.listfullDB = listfullDB;
    }
    
    private database db=new database();
    
    private ResultSet rs;
    
    public MD_Po_bahan_dasar() {
    }
    
    
    public MD_Po_bahan_dasar(String No_po, Date tanggal, int no_pegwai,database db) {
        this.No_po = No_po;
        this.tanggal = tanggal;
        this.no_pegwai = no_pegwai;
        md_pegawai=lsd.getMDByID(no_pegwai);
        listMD_Full_po_bahan_dasar();
        this.db=db;
        lsd=new listMD_Pegawai(db);
    }
    
    public void listMD_Full_po_bahan_dasar(MD_Full_po_bahan_dasar tmp){
        listfullDB.clear();
        listfullDB.add(tmp);
    }
    
    public void listMD_Full_po_bahan_dasar() {
        try {
            listfullDB.clear();
            rs=db.getRs("select * from full_po_bahan_dasar where No_po ='"+No_po+"'");
            while(rs.next()){
                listfullDB.add(
                        new MD_Full_po_bahan_dasar(rs.getString("No_po"),
                                rs.getInt("id_barang"),
                                rs.getInt("banyak"),
                                rs.getString("Rencana_Kirim"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public String getNo_po() {
        return No_po;
    }

    public void setNo_po(String No_po) {
        this.No_po = No_po;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public int getNo_pegwai() {
        return no_pegwai;
    }

    public void setNo_pegwai(int no_pegwai) {
        this.no_pegwai = no_pegwai;
    }

    public MD_Pegawai getMd_pegawai() {
        return md_pegawai;
    }

    public void setMd_pegawai(MD_Pegawai md_pegawai) {
        this.md_pegawai = md_pegawai;
    }
}
