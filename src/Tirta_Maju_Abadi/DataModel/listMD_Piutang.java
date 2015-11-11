package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Piutang {
    private database db;
    private loadAllData lad;
    private List<MD_Piutang> loadDB=new ArrayList<MD_Piutang>();

    public listMD_Piutang(database db, loadAllData lad) {
        this.db = db;
        this.lad = lad;
        setThelist();
    }
    
    public void setThelist(){
        try {
            ResultSet rs=db.getRs("select * from piutang ");
            while(rs.next()){
                loadDB.add(new MD_Piutang(rs.getInt("Id_supplier"),rs.getString("No_PO"), 
                        rs.getString("no_nota_piutang"), 
                        rs.getDate("tanggal_nota"), 
                        rs.getDate("tanggal_jatuhTempo"), 
                        rs.getString("no_surat_jalan"), 
                        rs.getBoolean("setatusPembayaran"), 
                        rs.getString("NO_pembayaran"), 
                        lad));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public List<MD_Piutang> getList(){
        return loadDB;
    }
    
}
