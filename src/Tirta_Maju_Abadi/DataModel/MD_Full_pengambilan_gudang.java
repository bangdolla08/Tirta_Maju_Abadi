/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author jepank's
 */
public class MD_Full_pengambilan_gudang {
    private int Id_pegawai,Id_barang, Id_supplier,banyak;
    private Date tanggal;
    private loadAllData lad;
    private MD_Produk mdp;
    private MD_Pegawai mpeg;
    private MD_Supplier msup;
    private database db=new database();
    private ResultSet rs;
    
    public MD_Full_pengambilan_gudang(){
    }
    
    public MD_Full_pengambilan_gudang(MD_Produk mdp, MD_Supplier msup, int banyak){
        this.Id_barang=mdp.getId_produk();
        this.Id_supplier=msup.getId_supplier();
        this.banyak=banyak;
        this.mdp=mdp;
        this.msup=msup;
    }
    
    public MD_Full_pengambilan_gudang(int Id_barang, int Id_supplier, int banyak){
        this.Id_barang=Id_barang;
        this.Id_supplier=Id_supplier;
        this.banyak=banyak;
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

    public MD_Produk getMdp() {
        return mdp;
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

    public database getDb() {
        return db;
    }

    public void setDb(database db) {
        this.db = db;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
}
