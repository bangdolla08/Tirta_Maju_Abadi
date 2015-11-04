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
 * @author jepank's
 */
public class listMD_pengambilan_gudang {
    private List<MD_Pengambilan_gudang> listDb=new ArrayList<MD_Pengambilan_gudang>();
    private database db;
    private ResultSet rs;
    private loadAllData lad;
    
    public listMD_pengambilan_gudang(database db, loadAllData lad){
        this.db=db;
        this.lad=lad;
        listDb.clear();
        try{
            //rs=db.getRs("select * from pengambilan_gudang");
            while(rs.next()){
                listDb.add(new MD_Pengambilan_gudang(
                    rs.getDate("Tanggal"),
                    rs.getInt("Id_pegawai"), db));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    public listMD_pengambilan_gudang(database db){
        this.db=db;
        listDb.clear();
        try{
            //rs=db.getRs("select * from pengambilan_gudang");
            while(rs.next()){
                listDb.add(new MD_Pengambilan_gudang(
                    rs.getDate("Tanggal"),
                    rs.getInt("Id_pegawai"), db));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public MD_Pengambilan_gudang getMyDB(int Id_barang){
        MD_Pengambilan_gudang pilih=new MD_Pengambilan_gudang();
        for(MD_Pengambilan_gudang mpg:listDb){
            if(mpg.getId_barang()==Id_barang){
                pilih=mpg;
                break;
            }
        }
        return pilih;
    }

    public List<MD_Pengambilan_gudang> getListDb() {
        return listDb;
    }

    public void setListDb(List<MD_Pengambilan_gudang> listDb) {
        this.listDb = listDb;
    }
    
    public List<MD_Pengambilan_gudang> getAll(){
        return listDb;
    }
}
