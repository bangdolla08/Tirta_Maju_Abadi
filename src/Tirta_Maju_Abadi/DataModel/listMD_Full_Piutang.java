package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Full_Piutang {
    private database db;
    private loadAllData lD;
    private ResultSet rs;
    private List<MD_Full_Piutang> listDB=new ArrayList<MD_Full_Piutang>();

    public listMD_Full_Piutang(database db) {
        this.db = db;
    }
    
    private void reset(){
        try {
            ResultSet rs=db.getRs("select * full_piutang");
            listDB.clear();
            while(rs.next()){
                
            }
        } catch (Exception e) {
        }
    }
    
     public listMD_Full_Piutang(ResultSet rs,database db){
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from full_piutang");
            while(rs.next()){
                listDB.add(new MD_Full_Piutang(rs.getString("No_PO"), 
                        rs.getString("no_nota_piutang"), 
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"),
                        rs.getInt("banyak_barang")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public listMD_Full_Piutang(database db, loadAllData lD){
        this.lD=lD;
        this.db=db;
        listDB.clear();
        try {
            rs=db.getRs("select * from full_piutang");
            while(rs.next()){
                listDB.add(new MD_Full_Piutang(rs.getString("No_PO"), 
                        rs.getString("no_nota_piutang"), 
                        rs.getString("nama_barang"),
                        rs.getInt("harga_barang"),
                        rs.getInt("banyak_barang")));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
    
    public void addTuList(MD_Full_Piutang MFP){
        listDB.add(MFP);
    }

    public List<MD_Full_Piutang> getListDB() {
        return listDB;
    }

    public void setListDB(List<MD_Full_Piutang> listDB) {
        this.listDB = listDB;
    }
    
    public MD_Full_Piutang getMDByNo_nota(String No_nota){
        MD_Full_Piutang pilih=new MD_Full_Piutang();
        for(MD_Full_Piutang mdfp : listDB){
            if(mdfp.getNo_nota_piutang().equals(No_nota)){
                pilih=mdfp;
                break;
            }
        }
        return pilih;
    }
    
    
}
