package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.ArrayList;
import java.util.List;

public class listMD_Piutang {
    private database db;
    private loadAllData lad;
    private List<MD_Piutang> loadDB=new ArrayList<MD_Piutang>();

    public listMD_Piutang(database db, loadAllData lad) {
        this.db = db;
        this.lad = lad;
    }
    
}
