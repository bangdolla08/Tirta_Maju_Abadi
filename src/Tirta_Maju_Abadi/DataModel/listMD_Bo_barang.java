/*
 * To change this template, choose Tools | Templates
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
 * @author jepank's
 */
public class listMD_Bo_barang {
    private database db;
    private ResultSet rs;
    private List<MD_Bo_barang> listDB=new ArrayList<MD_Bo_barang>();
    private loadAllData lD;
    
    public listMD_Bo_barang(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                  listDB.add(new MD_Bo_barang(rs.getInt("no_bo"),
                        rs.getDate("tanggal"), 
                        rs.getInt("no_pegawai"), 
                        rs.getInt("Id_pegawai_acc")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Bo_barang(database db, loadAllData lD){
        this.lD=lD;
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from bo_barang");
            while(rs.next()){
                listDB.add(new MD_Bo_barang(rs.getInt("no_bo"), 
                        rs.getDate("tanggal"), 
                        rs.getInt("no_pegawai"), 
                        rs.getInt("Id_pegawai_acc")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Bo_barang getMDByID(int No_bo){
        MD_Bo_barang pilih=new MD_Bo_barang();
        for(MD_Bo_barang mbb : listDB){
            if(mbb.getNo_bo()==No_bo){
                pilih=mbb;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Bo_barang> getAll(){
        return listDB;
    }
    
}
