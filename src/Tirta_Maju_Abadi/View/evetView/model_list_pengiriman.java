
package Tirta_Maju_Abadi.View.evetView;

import Tirta_Maju_Abadi.DataModel.MD_Pelanggan;
import Tirta_Maju_Abadi.DataModel.MD_Penjualan_po;
import Tirta_Maju_Abadi.DataModel.listMD_Penjualan_po;
import Tirta_Maju_Abadi.toll.loadAllData;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class model_list_pengiriman {
    private listMD_Penjualan_po list_Penjualan;
    private loadAllData lad;
    private DefaultTableModel dtm;
    private listMD_Penjualan_po lmpp;
    public model_list_pengiriman(loadAllData lad,TableModel tm){
        this.lad=lad;
        lmpp=lad.getListMD_Penjualan_po();
        this.dtm=(DefaultTableModel) tm;
        reset();
        //dtm.setRowCount(0);
    }
    public DefaultTableModel getDTM(){
        return dtm;
    }
    public void reset(){
        dtm.setRowCount(0);
        for(MD_Penjualan_po tmp:list_Penjualan.getAll()){
            Vector vct=new Vector();
            vct.add(tmp.getNo_nota());
            vct.add(tmp);
            if(validasiPengiriman(tmp))
                dtm.addRow(vct);
        }
    }
    public MD_Penjualan_po getMD_Penjualan_po(JTable jt,int selectTedROw){
        return (MD_Penjualan_po)jt.getValueAt(selectTedROw, 1);
    }
    
    public boolean validasiPengiriman(MD_Penjualan_po tmp){
        //if_pembayaran
        MD_Pelanggan mp=tmp.getPel();
        
        return false;
    }
}
