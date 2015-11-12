/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Date;

/**
 *
 * @author PUTRA
 */
public class MD_Mobil_Keluar {
    private int id_bo;
    private String nopol, tujuan;
    private MD_Mobil mdmobil;
    private Date tgl;
    public MD_Mobil_Keluar(){
        
    }
    
    public MD_Mobil_Keluar(int id_bo,Date tgl,String nopol, String tujuan,database db,loadAllData lad)
    {
        this.id_bo=id_bo;
        this.nopol=nopol;
        this.mdmobil=lad.getListMD_Mobil().getMDByID(nopol);
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

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
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
