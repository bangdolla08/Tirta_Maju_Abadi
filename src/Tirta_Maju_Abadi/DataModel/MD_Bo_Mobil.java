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
import java.util.Date;
import java.util.List;

/**
 *
 * @author putra
 */
public class MD_Bo_Mobil {
    //private int Id_pelanggan, Id_marketing;
    private String nopol;
    private Date tanggal;
    private int no_bo, id_pegawai_acc;
    private ResultSet rs;
    private database db;
    private loadAllData lD;
    private List<MD_Full_Bo_Mobil> list_bo= new ArrayList<MD_Full_Bo_Mobil>();

    
    public int getId_pegawai_acc() {
        return id_pegawai_acc;
    }

    public void setId_pegawai_acc(int id_pegawai_acc) {
        this.id_pegawai_acc = id_pegawai_acc;
    }
    
    public List<MD_Full_Bo_Mobil> getList_bo() {
        return list_bo;
    }

    public void setList_bo(List<MD_Full_Bo_Mobil> list_bo) {
        this.list_bo = list_bo;
    }
    
    public MD_Bo_Mobil(int no_bo, Date tanggal, String nopol, int id_pegawai_acc, database db)
    {
        this.db=db;
        list_bo.clear();
        this.tanggal=tanggal;
        this.nopol=nopol;
        this.no_bo=no_bo;
        this.id_pegawai_acc=id_pegawai_acc;
        ListBo();
    }
    
    public MD_Bo_Mobil(int no_bo, Date tanggal, String nopol, int id_pegawai_acc)
    {
        this.db=db;
        list_bo.clear();
        this.tanggal=tanggal;
        this.nopol=nopol;
        this.no_bo=no_bo;
        this.id_pegawai_acc=id_pegawai_acc;
    }
    
    public MD_Bo_Mobil()
    {
        this.db=db;
        list_bo.clear();
        this.tanggal=tanggal;
        this.nopol=nopol;
        this.no_bo=no_bo;
        this.id_pegawai_acc=id_pegawai_acc;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public int getNo_bo() {
        return no_bo;
    }

    public void setNo_bo(int no_bo) {
        this.no_bo = no_bo;
    }
    
    public void ListBo()
    {
        list_bo.clear();
        try{
            ResultSet rs = db.getRs("select * from full_bo_mobil where no_bo="+this.no_bo);
            while(rs.next())
            {
                list_bo.add(null);
            }
        }
        catch(Exception e)
                    {
                    }
    }
    
    public void addlistfull(MD_Full_Bo_Mobil mdfull)
    {
    list_bo.add(mdfull);
    }
    
    
}
