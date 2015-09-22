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
public class MD_Mobil {
    private int driverint,helperInt;
    private String nopol, type, driver, helper, milik;
    private MD_Pegawai driverMD,HelperMD;
    private database db=new database();

    public MD_Mobil(int driverint, int helperInt, String nopol, String type,String milik,database db) {
        this.db=db;
        this.driverint = driverint;
        this.helperInt = helperInt;
        listMD_Pegawai ldb=new listMD_Pegawai(db);
        this.nopol = nopol;
        this.type = type;
        this.milik=milik;
        driverMD=ldb.getMDByID(driverint);
        HelperMD=ldb.getMDByID(helperInt);
    }

    public MD_Mobil() {
        this.db=null;
        this.driverint = 0;
        this.helperInt = 0;
        //listMD_Pegawai ldb=new listMD_Pegawai(db);
        this.nopol = null;
        this.type = null;
        this.milik=null;
        driverMD=new MD_Pegawai();
        HelperMD=new MD_Pegawai();
    }
         
    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    public String getMilik() {
        return milik;
    }

    public void setMilik(String milik) {
        this.milik = milik;
    }
}
