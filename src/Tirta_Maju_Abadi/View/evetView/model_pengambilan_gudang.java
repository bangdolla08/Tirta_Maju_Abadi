package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Full_pengambilan_gudang;
import Tirta_Maju_Abadi.DataModel.MD_Pengambilan_gudang;
import Tirta_Maju_Abadi.toll.database;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class model_pengambilan_gudang {
    private loadAllData lad;
    private database db;
    private MD_Pengambilan_gudang mdpg;
    private DefaultTableModel dtm;
    public model_pengambilan_gudang(loadAllData lad, database db, MD_Pengambilan_gudang mdpg,DefaultTableModel dtm) {
        this.lad = lad;
        this.db = db;
        this.mdpg = mdpg;
        this.dtm=dtm;
    }
    
    public DefaultTableModel getDTM(){
        return dtm;
    }
    
    public void reset(){
        dtm.setRowCount(0);
    }
    
    public void addFull(MD_Full_pengambilan_gudang tmp){
        mdpg.addToList(tmp);
        Vector vct=new Vector();
        vct.add(dtm.getRowCount()+1);
        vct.add(tmp.getMdp().getNama_produk());
        
    }
    
}
