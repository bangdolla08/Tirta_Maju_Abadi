package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Suplier {
    private database db;
    private ResultSet rs;
    private loadAllData lD;
    private List<MD_Supplier> listDB=new ArrayList<MD_Supplier>();

    public listMD_Suplier(database db, loadAllData lD) {
        this.db=db;
        try {
            rs=db.getRs("select * from supplier");
            while(rs.next()){
                listDB.add(
                        new MD_Supplier(
                                rs.getInt("Id_supplier"), 
                                rs.getBoolean("Ppn"), 
                                rs.getString("Nama"), 
                                rs.getString("Alamat"), 
                                rs.getString("No_telepon1"), 
                                rs.getString("No_telepon2"), 
                                rs.getString("Email"), 
                                rs.getString("No_rekening1"), 
                                rs.getString("No_rekening2"),lD)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public listMD_Suplier(database db, ResultSet rs) {
        this.db = db;
        try {
            while(rs.next()){
                listDB.add(
                        new MD_Supplier(
                                rs.getInt("Id_supplier"), 
                                rs.getBoolean("Ppn"), 
                                rs.getString("Nama"), 
                                rs.getString("Alamat"), 
                                rs.getString("No_telepon1"), 
                                rs.getString("No_telepon2"), 
                                rs.getString("Email"), 
                                rs.getString("No_rekening1"), 
                                rs.getString("No_rekening2"), lD)
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<MD_Supplier> getList(){
        return listDB;
    }
    public MD_Supplier getSuplier(int Id_supplier){
        MD_Supplier pilih=new MD_Supplier();
        for(MD_Supplier mdpr : listDB){
            if(mdpr.getId_supplier()==Id_supplier){
                pilih=mdpr;
                break;
            }
        }
        return pilih;
    }
}
