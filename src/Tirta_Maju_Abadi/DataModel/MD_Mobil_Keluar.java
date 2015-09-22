/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;

/**
 *
 * @author PUTRA
 */
public class MD_Mobil_Keluar {
    private int id_bo;
    private String tgl,nopol, tujuan;
    private MD_Mobil mdmobil;
    private database db=new database();
    public MD_Mobil_Keluar(){
    }
    
    public MD_Mobil_Keluar(int id_bo,String tgl,String nopol, String tujuan)
    {
        this.id_bo=id_bo;
        this.nopol=nopol;
        this.mdmobil=new listMD_Mobil(db).getMDByID(nopol);
        this.tgl=tgl;
        this.tujuan=tujuan;
    }

    public MD_Mobil getMdmobil() {
        return mdmobil;
    }

    public void setMdmobil(MD_Mobil mdmobil) {
        this.mdmobil = mdmobil;
    }

    public int getId_bo() {
        return id_bo;
    }

    public void setId_bo(int id_bo) {
        this.id_bo = id_bo;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }
    
}
