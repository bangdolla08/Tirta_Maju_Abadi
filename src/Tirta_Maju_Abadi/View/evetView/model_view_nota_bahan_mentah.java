package Tirta_Maju_Abadi.View.evetView;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class model_view_nota_bahan_mentah {
    private DefaultTableModel dtm;
    
    public model_view_nota_bahan_mentah(TableModel dtm) {
        this.dtm=(DefaultTableModel) dtm;
    }
    
    public DefaultTableModel getDTM(){
        return dtm;
    }
    
    public void setNamaSuplier(){
        
    }
    
    
}
