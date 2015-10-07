/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import Tirta_Maju_Abadi.DataModel.MD_Bo_Mobil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author putra
 */
public class listMD_Bo_Mobil {
    private database db;
    private ResultSet rs;
    private loadAllData lD;
    private List<MD_Bo_Mobil> md = new ArrayList<MD_Bo_Mobil>();
    
    public listMD_Bo_Mobil(ResultSet rs,database db)
    {
        this.db=db;
        md.clear();
        try {
            while(rs.next()){
                  md.add(new MD_Bo_Mobil(rs.getInt("no_bo"),
                  rs.getDate("tanggal"),
                  rs.getString("nopol"),
                  rs.getInt("id_pegawai_acc")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Bo_Mobil(database db, loadAllData lD)
    {
        this.lD=lD;
        this.db=db;
        md.clear();
        try {
            rs=db.getRs("select * from bo_mobil");
            while(rs.next()){
                md.add(new MD_Bo_Mobil(rs.getInt("no_bo"),
                  rs.getDate("tanggal"),
                  rs.getString("nopol"),
                  rs.getInt("id_pegawai_acc")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Bo_Mobil getMDbyID(int no_bo)
    {
        MD_Bo_Mobil pilih = new MD_Bo_Mobil();
        for(MD_Bo_Mobil mdm:md)
        {
            if(mdm.getNo_bo()==no_bo)
            {
            pilih = mdm;
            break;
            }
        }
        return pilih;
    }
    
    public List<MD_Bo_Mobil> getAll()
    {
        return md;
    }
    
    
}
