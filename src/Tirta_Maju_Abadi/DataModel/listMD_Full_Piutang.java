package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class listMD_Full_Piutang {
    private database db;
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
    
    public void addTuList(MD_Full_Piutang MFP){
        listDB.add(MFP);
    }

    public List<MD_Full_Piutang> getListDB() {
        return listDB;
    }

    public void setListDB(List<MD_Full_Piutang> listDB) {
        this.listDB = listDB;
    }
    
    
}
