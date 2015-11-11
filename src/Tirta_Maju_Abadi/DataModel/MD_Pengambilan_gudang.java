/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.View.Pegawai;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author jepank's
 */


public class MD_Pengambilan_gudang {
    private int Id_pegawai,Id_barang, Id_supplier,banyak;
    private Date tanggal;
    private loadAllData lad;
    private MD_Produk mdp;
    private MD_Pegawai mpeg;
    private MD_Supplier msup;
    private database db=new database();
    private ResultSet rs;
    private listMD_Pegawai lsd;
    private List<MD_Full_pengambilan_gudang> listFullDb=new ArrayList<MD_Full_pengambilan_gudang>();

    public List<MD_Full_pengambilan_gudang> getListFullDb() {
        return listFullDb;
    }

    public void setListFullDb(List<MD_Full_pengambilan_gudang> listFullDb) {
        this.listFullDb = listFullDb;
    }

    
    public MD_Produk getMdp() {
        return mdp;
    }
    
    
    public void addToList(MD_Full_pengambilan_gudang mpeng){
        listFullDb.add(mpeng);
    }

    public void setMdp(MD_Produk mdp) {
        this.mdp = mdp;
    }

    public MD_Pegawai getMpeg() {
        return mpeg;
    }

    public void setMpeg(MD_Pegawai mpeg) {
        this.mpeg = mpeg;
    }

    public MD_Supplier getMsup() {
        return msup;
    }

    public void setMsup(MD_Supplier msup) {
        this.msup = msup;
    }
    
    private List<MD_Pengambilan_gudang> lsitMD_pengambilan=new ArrayList<MD_Pengambilan_gudang>();

    public List<MD_Pengambilan_gudang> getLsitMD_pengambilan() {
        return lsitMD_pengambilan;
    }

    public void setLsitMD_pengambilan(List<MD_Pengambilan_gudang> lsitMD_pengambilan) {
        this.lsitMD_pengambilan = lsitMD_pengambilan;
    }
    
    public MD_Pengambilan_gudang(){
        this.Id_pegawai=0;
        this.Id_barang=0;
        this.Id_supplier=0;
        //this.tanggal=null;
    }
    
    public MD_Pengambilan_gudang(Date Tanggal, int Id_pegawai, int Id_barang, int Id_supplier, int Banyak){
        this.tanggal=Tanggal;
        this.Id_pegawai=Id_pegawai;
        this.Id_barang=Id_barang;
        this.Id_supplier=Id_supplier;
        this.banyak=banyak;
        listMD_Full_pengambilan_gudang();
        //lsd=new listMD_Pegawai(db);
    }
    
    
    public MD_Pengambilan_gudang(Date tanggal, int Id_pegawai, database db){
        this.tanggal=tanggal;
        mpeg=lsd.getMDByID(Id_pegawai);
        this.db=db;
        lsd=new listMD_Pegawai(db);
    }
    
    
    public void listMD_Full_pengambilan_gudang(MD_Full_pengambilan_gudang mpgu){
        //listFullDb.clear();
        listFullDb.add(mpgu);
    }
    
    
    public void listMD_Full_pengambilan_gudang() {
        try{
            listFullDb.clear();
            //rs=db.getRs("select * from pengambilan_gudang where Id_pegawai ='"+Id_pegawai+"'");
            while(rs.next()){
                listFullDb.add(new MD_Full_pengambilan_gudang(
                    rs.getInt("Id_barang"),
                    rs.getInt("Id_supplier"),
                    rs.getInt("Banyak")));
            }
        }catch(Exception e){
            System.out.println("Eroorr= "+e);
        }
    }
    
    

    public int getId_pegawai() {
        return Id_pegawai;
    }

    public void setId_pegawai(int Id_pegawai) {
        this.Id_pegawai = Id_pegawai;
    }

    public int getId_barang() {
        return Id_barang;
    }

    public void setId_barang(int Id_barang) {
        this.Id_barang = Id_barang;
    }

    public int getId_supplier() {
        return Id_supplier;
    }

    public void setId_supplier(int Id_supplier) {
        this.Id_supplier = Id_supplier;
    }

    public int getBanyak() {
        return banyak;
    }

    public void setBanyak(int banyak) {
        this.banyak = banyak;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public loadAllData getLad() {
        return lad;
    }

    public void setLad(loadAllData lad) {
        this.lad = lad;
    }
    
}
