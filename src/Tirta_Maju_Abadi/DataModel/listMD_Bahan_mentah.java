package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Bahan_mentah {
    private List<MD_Bahan_metah> listDB=new ArrayList<MD_Bahan_metah>();
    private database db;
    private ResultSet rs;

    public listMD_Bahan_mentah(database db) {
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from bahan_mentah ");
            while(rs.next()){
                listDB.add(new MD_Bahan_metah(
                        rs.getInt("id_bahan"), 
                        rs.getInt("stok"), 
                        rs.getInt("limit_buffer"), 
                        rs.getString("nama_bahan"), 
                        rs.getString("unit"), 
                        rs.getString("spesifikasi")
                ));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public listMD_Bahan_mentah(ResultSet rs,database db) {
        try {
            this.db=db;
            while(rs.next()){
                listDB.add(new MD_Bahan_metah(
                        rs.getInt("id_bahan"), 
                        rs.getInt("stok"), 
                        rs.getInt("limit_buffer"), 
                        rs.getString("nama_bahan"), 
                        rs.getString("unit"), 
                        rs.getString("spesifikasi")
                ));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public MD_Bahan_metah getMyDB(int id_bahan){
        MD_Bahan_metah pilih=new MD_Bahan_metah();
        for(MD_Bahan_metah mda : listDB){
            if(mda.getId_bahan()==id_bahan){
                pilih=mda;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Bahan_metah> getAll(){
        return listDB;
    }
}
