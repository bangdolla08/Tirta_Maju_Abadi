package Tirta_Maju_Abadi.DataModel;


import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class listMD_Pesan_barang {
    private database db;
    private ResultSet rs;
    private List<MD_Pesan_barang> listDB=new ArrayList<MD_Pesan_barang>();
    
    public listMD_Pesan_barang(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            while(rs.next()){
                listDB.add(new MD_Pesan_barang(rs.getString("No_po"), 
                        rs.getString("No_pesan"), 
                        rs.getInt("Id_supplier"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public listMD_Pesan_barang(database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from pesan_barang");
            while(rs.next()){
                listDB.add(new MD_Pesan_barang(rs.getString("No_po"), 
                        rs.getString("No_pesan"), 
                        rs.getInt("Id_supplier"),db));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    public MD_Pesan_barang getMDByID(String No_po){
        MD_Pesan_barang pilih=new MD_Pesan_barang();
        for(MD_Pesan_barang mdpb : listDB){
            if(mdpb.getNo_po()==No_po){
                pilih=mdpb;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Pesan_barang> getAll(){
        return listDB;
    }
}
