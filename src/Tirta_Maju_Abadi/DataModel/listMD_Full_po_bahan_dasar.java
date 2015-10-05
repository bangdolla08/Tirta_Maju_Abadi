package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Full_po_bahan_dasar {
    private database db;
    private ResultSet rs;
    private List<MD_Full_po_bahan_dasar> listDB=new ArrayList<MD_Full_po_bahan_dasar>();

    public listMD_Full_po_bahan_dasar(String no_po,database db){
        this.db=db;
        try {
            listDB.clear();
            rs=db.getRs("select * from full_po_bahan_dasar ORDER BY No_po ASC");
            while(rs.next()){
                listDB.add(
                        new MD_Full_po_bahan_dasar(rs.getString("No_po"),
                                rs.getInt("id_barang"),
                                rs.getInt("banyak"),
                                rs.getString("Rencana_Kirim"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public listMD_Full_po_bahan_dasar(ResultSet rs,database db){
        this.db=db;
        try {
            while(rs.next()){
                listDB.add(
                        new MD_Full_po_bahan_dasar(rs.getString("No_po"),
                                rs.getInt("id_barang"),
                                rs.getInt("banyak"),
                                rs.getString("Rencana_Kirim"))
                        );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public MD_Full_po_bahan_dasar getMDByID(String no_po){
        MD_Full_po_bahan_dasar pilih=new MD_Full_po_bahan_dasar();
        for(MD_Full_po_bahan_dasar mdpr : listDB){
            if(mdpr.getNo_po().equals(no_po)){
                pilih=mdpr;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Full_po_bahan_dasar> getList(){
        return listDB;
    }
}
